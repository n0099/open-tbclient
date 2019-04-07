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
    private boolean aAb;
    private MediaPlayer azV;
    private PlayerStatus cSR = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cSS;
    private a cST;
    private c cSU;
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
            this.cSS = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cSR != PlayerStatus.NONE) {
                    Eq().reset();
                }
                Eq().setDataSource(a2.mUrl);
                this.cSR = PlayerStatus.IDLE;
                this.cSS.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cSS.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void onRelease() {
        yo();
        Eq().release();
        this.azV = null;
        this.cSR = PlayerStatus.NONE;
        if (this.cSU != null) {
            this.cSU.removeMessages(0);
            this.cSU = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.cSR == PlayerStatus.PREPARED) {
            Et();
            Eq().start();
            this.cSS.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cSU != null) {
                this.cSU.sendEmptyMessage(0);
            }
        } else if (this.cSR == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Eq().prepareAsync();
            this.cSR = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cSS.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (Eq().isPlaying()) {
            Eq().pause();
            this.cSS.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cSU != null) {
                this.cSU.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.cSR == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Eq().stop();
            this.cSR = PlayerStatus.IDLE;
            this.cSS.onStateChanged(BgMusicPlayState.STOP);
            if (this.cSU != null) {
                this.cSU.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void seek(int i) {
        Eq().seekTo(i);
    }

    @Override // com.baidu.swan.apps.u.b.e
    public int getDuration() {
        return Eq().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.e
    public boolean isPlaying() {
        return Eq().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Eq() {
        if (this.azV == null) {
            this.azV = new MediaPlayer();
            b bVar = new b();
            this.azV.setOnPreparedListener(bVar);
            this.azV.setOnCompletionListener(bVar);
            this.azV.setOnErrorListener(bVar);
            this.azV.setOnBufferingUpdateListener(bVar);
            this.azV.setAudioStreamType(3);
            this.cSU = new c();
        }
        return this.azV;
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
            SwanAppBgMusicPlayerImpl.this.cSR = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cSS.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.cSR = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cSS.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.cSU != null) {
                SwanAppBgMusicPlayerImpl.this.cSU.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.cSS.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.cSR == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Eq().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Eq().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.cSS.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.Eq().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.Eq().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.cSS.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.cSS.onGetPosition(currentPosition, aD(duration, currentPosition));
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
                            SwanAppBgMusicPlayerImpl.this.yo();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Et() {
        if (!this.aAb) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cST == null) {
                this.cST = new a();
            }
            this.aAb = this.mAudioManager.requestAudioFocus(this.cST, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo() {
        if (this.aAb) {
            if (this.mAudioManager != null && this.cST != null) {
                this.mAudioManager.abandonAudioFocus(this.cST);
                this.mAudioManager = null;
                this.cST = null;
            }
            this.aAb = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
