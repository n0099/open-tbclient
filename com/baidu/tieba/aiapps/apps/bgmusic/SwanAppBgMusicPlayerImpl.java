package com.baidu.tieba.aiapps.apps.bgmusic;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import com.baidu.swan.apps.u.b.e;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppBgMusicPlayerImpl implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private MediaPlayer azR;
    private boolean azX;
    private PlayerStatus cST = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cSU;
    private a cSV;
    private c cSW;
    private AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void a(String str, com.baidu.swan.apps.media.audio.service.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.cSU = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cST != PlayerStatus.NONE) {
                    Es().reset();
                }
                Es().setDataSource(a2.mUrl);
                this.cST = PlayerStatus.IDLE;
                this.cSU.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cSU.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void onRelease() {
        yp();
        Es().release();
        this.azR = null;
        this.cST = PlayerStatus.NONE;
        if (this.cSW != null) {
            this.cSW.removeMessages(0);
            this.cSW = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.cST == PlayerStatus.PREPARED) {
            Ev();
            Es().start();
            this.cSU.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cSW != null) {
                this.cSW.sendEmptyMessage(0);
            }
        } else if (this.cST == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Es().prepareAsync();
            this.cST = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cSU.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (Es().isPlaying()) {
            Es().pause();
            this.cSU.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cSW != null) {
                this.cSW.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.cST == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Es().stop();
            this.cST = PlayerStatus.IDLE;
            this.cSU.onStateChanged(BgMusicPlayState.STOP);
            if (this.cSW != null) {
                this.cSW.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void seek(int i) {
        Es().seekTo(i);
    }

    @Override // com.baidu.swan.apps.u.b.e
    public int getDuration() {
        return Es().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.e
    public boolean isPlaying() {
        return Es().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Es() {
        if (this.azR == null) {
            this.azR = new MediaPlayer();
            b bVar = new b();
            this.azR.setOnPreparedListener(bVar);
            this.azR.setOnCompletionListener(bVar);
            this.azR.setOnErrorListener(bVar);
            this.azR.setOnBufferingUpdateListener(bVar);
            this.azR.setAudioStreamType(3);
            this.cSW = new c();
        }
        return this.azR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onPrepared");
            }
            SwanAppBgMusicPlayerImpl.this.cST = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cSU.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.cST = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cSU.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.cSW != null) {
                SwanAppBgMusicPlayerImpl.this.cSW.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.cSU.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.cST == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Es().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Es().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.cSU.onStateChanged(BgMusicPlayState.LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                int duration = SwanAppBgMusicPlayerImpl.this.Es().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.Es().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.cSU.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.cSU.onGetPosition(currentPosition, aD(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int aD(int i, int i2) {
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
    /* loaded from: classes4.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.bgmusic.SwanAppBgMusicPlayerImpl.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            SwanAppBgMusicPlayerImpl.this.yp();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Ev() {
        if (!this.azX) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cSV == null) {
                this.cSV = new a();
            }
            this.azX = this.mAudioManager.requestAudioFocus(this.cSV, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp() {
        if (this.azX) {
            if (this.mAudioManager != null && this.cSV != null) {
                this.mAudioManager.abandonAudioFocus(this.cSV);
                this.mAudioManager = null;
                this.cSV = null;
            }
            this.azX = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
