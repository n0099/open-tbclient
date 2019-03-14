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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer azS;
    private boolean azY;
    private PlayerStatus cSP = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cSQ;
    private a cSR;
    private c cSS;
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
            this.cSQ = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cSP != PlayerStatus.NONE) {
                    Es().reset();
                }
                Es().setDataSource(a2.mUrl);
                this.cSP = PlayerStatus.IDLE;
                this.cSQ.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cSQ.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void onRelease() {
        yp();
        Es().release();
        this.azS = null;
        this.cSP = PlayerStatus.NONE;
        if (this.cSS != null) {
            this.cSS.removeMessages(0);
            this.cSS = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.cSP == PlayerStatus.PREPARED) {
            Ev();
            Es().start();
            this.cSQ.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cSS != null) {
                this.cSS.sendEmptyMessage(0);
            }
        } else if (this.cSP == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Es().prepareAsync();
            this.cSP = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cSQ.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (Es().isPlaying()) {
            Es().pause();
            this.cSQ.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cSS != null) {
                this.cSS.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.cSP == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Es().stop();
            this.cSP = PlayerStatus.IDLE;
            this.cSQ.onStateChanged(BgMusicPlayState.STOP);
            if (this.cSS != null) {
                this.cSS.removeMessages(0);
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
        if (this.azS == null) {
            this.azS = new MediaPlayer();
            b bVar = new b();
            this.azS.setOnPreparedListener(bVar);
            this.azS.setOnCompletionListener(bVar);
            this.azS.setOnErrorListener(bVar);
            this.azS.setOnBufferingUpdateListener(bVar);
            this.azS.setAudioStreamType(3);
            this.cSS = new c();
        }
        return this.azS;
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
            SwanAppBgMusicPlayerImpl.this.cSP = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cSQ.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.cSP = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cSQ.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.cSS != null) {
                SwanAppBgMusicPlayerImpl.this.cSS.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.cSQ.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.cSP == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Es().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Es().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.cSQ.onStateChanged(BgMusicPlayState.LOADING);
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
                SwanAppBgMusicPlayerImpl.this.cSQ.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.cSQ.onGetPosition(currentPosition, aD(duration, currentPosition));
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
        if (!this.azY) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cSR == null) {
                this.cSR = new a();
            }
            this.azY = this.mAudioManager.requestAudioFocus(this.cSR, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp() {
        if (this.azY) {
            if (this.mAudioManager != null && this.cSR != null) {
                this.mAudioManager.abandonAudioFocus(this.cSR);
                this.mAudioManager = null;
                this.cSR = null;
            }
            this.azY = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
