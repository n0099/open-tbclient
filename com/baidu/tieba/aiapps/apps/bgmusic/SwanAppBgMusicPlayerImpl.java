package com.baidu.tieba.aiapps.apps.bgmusic;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class SwanAppBgMusicPlayerImpl implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer bbi;
    private com.baidu.swan.apps.media.audio.service.a bbk;
    private boolean bbl;
    private PlayerStatus edr = PlayerStatus.NONE;
    private a eds;
    private c edt;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.bbk = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.edr != PlayerStatus.NONE) {
                    Hz().reset();
                }
                Hz().setDataSource(a2.mUrl);
                this.edr = PlayerStatus.IDLE;
                this.bbk.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bbk.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        HB();
        Hz().release();
        this.bbi = null;
        this.edr = PlayerStatus.NONE;
        if (this.edt != null) {
            this.edt.removeMessages(0);
            this.edt = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.edr == PlayerStatus.PREPARED) {
            HA();
            Hz().start();
            this.bbk.onStateChanged(BgMusicPlayState.PLAY);
            if (this.edt != null) {
                this.edt.sendEmptyMessage(0);
            }
        } else if (this.edr == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Hz().prepareAsync();
            this.edr = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bbk.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (Hz().isPlaying()) {
            Hz().pause();
            this.bbk.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.edt != null) {
                this.edt.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.edr == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Hz().stop();
            this.edr = PlayerStatus.IDLE;
            this.bbk.onStateChanged(BgMusicPlayState.STOP);
            if (this.edt != null) {
                this.edt.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        Hz().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return Hz().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return Hz().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Hz() {
        if (this.bbi == null) {
            this.bbi = new MediaPlayer();
            b bVar = new b();
            this.bbi.setOnPreparedListener(bVar);
            this.bbi.setOnCompletionListener(bVar);
            this.bbi.setOnErrorListener(bVar);
            this.bbi.setOnBufferingUpdateListener(bVar);
            this.bbi.setAudioStreamType(3);
            this.edt = new c();
        }
        return this.bbi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            SwanAppBgMusicPlayerImpl.this.edr = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbk.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.edr = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbk.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.edt != null) {
                SwanAppBgMusicPlayerImpl.this.edt.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onError -> what: " + i + " extra: " + i2);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i + "%");
            }
            SwanAppBgMusicPlayerImpl.this.bbk.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.edr == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Hz().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Hz().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.bbk.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = SwanAppBgMusicPlayerImpl.this.Hz().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.Hz().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.bbk.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.bbk.onGetPosition(currentPosition, W(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int W(int i, int i2) {
            if (i2 > i) {
                i2 = i;
            }
            if (i > 0) {
                return (int) ((((i2 * 100) * 1.0f) / i) + 0.5f);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.bgmusic.SwanAppBgMusicPlayerImpl.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            SwanAppBgMusicPlayerImpl.this.HB();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void HA() {
        if (!this.bbl) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.eds == null) {
                this.eds = new a();
            }
            this.bbl = this.mAudioManager.requestAudioFocus(this.eds, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.bbl) {
            if (this.mAudioManager != null && this.eds != null) {
                this.mAudioManager.abandonAudioFocus(this.eds);
                this.mAudioManager = null;
                this.eds = null;
            }
            this.bbl = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
