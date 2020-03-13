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
    private MediaPlayer bbk;
    private com.baidu.swan.apps.media.audio.service.a bbm;
    private boolean bbn;
    private PlayerStatus edF = PlayerStatus.NONE;
    private a edG;
    private c edH;
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
            this.bbm = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.edF != PlayerStatus.NONE) {
                    HB().reset();
                }
                HB().setDataSource(a2.mUrl);
                this.edF = PlayerStatus.IDLE;
                this.bbm.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bbm.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        HD();
        HB().release();
        this.bbk = null;
        this.edF = PlayerStatus.NONE;
        if (this.edH != null) {
            this.edH.removeMessages(0);
            this.edH = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.edF == PlayerStatus.PREPARED) {
            HC();
            HB().start();
            this.bbm.onStateChanged(BgMusicPlayState.PLAY);
            if (this.edH != null) {
                this.edH.sendEmptyMessage(0);
            }
        } else if (this.edF == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            HB().prepareAsync();
            this.edF = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bbm.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (HB().isPlaying()) {
            HB().pause();
            this.bbm.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.edH != null) {
                this.edH.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.edF == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            HB().stop();
            this.edF = PlayerStatus.IDLE;
            this.bbm.onStateChanged(BgMusicPlayState.STOP);
            if (this.edH != null) {
                this.edH.removeMessages(0);
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
        if (this.bbk == null) {
            this.bbk = new MediaPlayer();
            b bVar = new b();
            this.bbk.setOnPreparedListener(bVar);
            this.bbk.setOnCompletionListener(bVar);
            this.bbk.setOnErrorListener(bVar);
            this.bbk.setOnBufferingUpdateListener(bVar);
            this.bbk.setAudioStreamType(3);
            this.edH = new c();
        }
        return this.bbk;
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
            SwanAppBgMusicPlayerImpl.this.edF = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbm.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.edF = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbm.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.edH != null) {
                SwanAppBgMusicPlayerImpl.this.edH.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.bbm.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.edF == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.HB().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.HB().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.bbm.onStateChanged(BgMusicPlayState.LOADING);
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
                SwanAppBgMusicPlayerImpl.this.bbm.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.bbm.onGetPosition(currentPosition, W(duration, currentPosition));
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
        if (!this.bbn) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.edG == null) {
                this.edG = new a();
            }
            this.bbn = this.mAudioManager.requestAudioFocus(this.edG, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (this.bbn) {
            if (this.mAudioManager != null && this.edG != null) {
                this.mAudioManager.abandonAudioFocus(this.edG);
                this.mAudioManager = null;
                this.edG = null;
            }
            this.bbn = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
