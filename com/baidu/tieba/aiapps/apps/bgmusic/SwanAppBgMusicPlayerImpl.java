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
    private MediaPlayer bbj;
    private com.baidu.swan.apps.media.audio.service.a bbl;
    private boolean bbm;
    private PlayerStatus eds = PlayerStatus.NONE;
    private a edt;
    private c edu;
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
            this.bbl = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.eds != PlayerStatus.NONE) {
                    HB().reset();
                }
                HB().setDataSource(a2.mUrl);
                this.eds = PlayerStatus.IDLE;
                this.bbl.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bbl.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        HD();
        HB().release();
        this.bbj = null;
        this.eds = PlayerStatus.NONE;
        if (this.edu != null) {
            this.edu.removeMessages(0);
            this.edu = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.eds == PlayerStatus.PREPARED) {
            HC();
            HB().start();
            this.bbl.onStateChanged(BgMusicPlayState.PLAY);
            if (this.edu != null) {
                this.edu.sendEmptyMessage(0);
            }
        } else if (this.eds == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            HB().prepareAsync();
            this.eds = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bbl.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (HB().isPlaying()) {
            HB().pause();
            this.bbl.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.edu != null) {
                this.edu.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.eds == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            HB().stop();
            this.eds = PlayerStatus.IDLE;
            this.bbl.onStateChanged(BgMusicPlayState.STOP);
            if (this.edu != null) {
                this.edu.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        HB().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return HB().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return HB().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer HB() {
        if (this.bbj == null) {
            this.bbj = new MediaPlayer();
            b bVar = new b();
            this.bbj.setOnPreparedListener(bVar);
            this.bbj.setOnCompletionListener(bVar);
            this.bbj.setOnErrorListener(bVar);
            this.bbj.setOnBufferingUpdateListener(bVar);
            this.bbj.setAudioStreamType(3);
            this.edu = new c();
        }
        return this.bbj;
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
            SwanAppBgMusicPlayerImpl.this.eds = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbl.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.eds = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbl.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.edu != null) {
                SwanAppBgMusicPlayerImpl.this.edu.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.bbl.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.eds == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.HB().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.HB().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.bbl.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.HB().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.HB().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.bbl.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.bbl.onGetPosition(currentPosition, W(duration, currentPosition));
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
                            SwanAppBgMusicPlayerImpl.this.HD();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void HC() {
        if (!this.bbm) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.edt == null) {
                this.edt = new a();
            }
            this.bbm = this.mAudioManager.requestAudioFocus(this.edt, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (this.bbm) {
            if (this.mAudioManager != null && this.edt != null) {
                this.mAudioManager.abandonAudioFocus(this.edt);
                this.mAudioManager = null;
                this.edt = null;
            }
            this.bbm = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
