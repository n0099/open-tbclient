package com.baidu.tieba.aiapps.apps.bgmusic;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import com.baidu.swan.apps.u.b.e;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppBgMusicPlayerImpl implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aUW;
    private boolean aVc;
    private PlayerStatus dnm = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a dnn;
    private a dno;
    private c dnp;
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
            this.dnn = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.dnm != PlayerStatus.NONE) {
                    LV().reset();
                }
                LV().setDataSource(a2.mUrl);
                this.dnm = PlayerStatus.IDLE;
                this.dnn.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.dnn.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void CK() {
        EP();
        LV().release();
        this.aUW = null;
        this.dnm = PlayerStatus.NONE;
        if (this.dnp != null) {
            this.dnp.removeMessages(0);
            this.dnp = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.dnm == PlayerStatus.PREPARED) {
            LY();
            LV().start();
            this.dnn.onStateChanged(BgMusicPlayState.PLAY);
            if (this.dnp != null) {
                this.dnp.sendEmptyMessage(0);
            }
        } else if (this.dnm == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            LV().prepareAsync();
            this.dnm = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.dnn.onInvokeFailed();
            CK();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (LV().isPlaying()) {
            LV().pause();
            this.dnn.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.dnp != null) {
                this.dnp.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.dnm == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            LV().stop();
            this.dnm = PlayerStatus.IDLE;
            this.dnn.onStateChanged(BgMusicPlayState.STOP);
            if (this.dnp != null) {
                this.dnp.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void seek(int i) {
        LV().seekTo(i);
    }

    @Override // com.baidu.swan.apps.u.b.e
    public int getDuration() {
        return LV().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.e
    public boolean isPlaying() {
        return LV().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer LV() {
        if (this.aUW == null) {
            this.aUW = new MediaPlayer();
            b bVar = new b();
            this.aUW.setOnPreparedListener(bVar);
            this.aUW.setOnCompletionListener(bVar);
            this.aUW.setOnErrorListener(bVar);
            this.aUW.setOnBufferingUpdateListener(bVar);
            this.aUW.setAudioStreamType(3);
            this.dnp = new c();
        }
        return this.aUW;
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
            SwanAppBgMusicPlayerImpl.this.dnm = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dnn.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.dnm = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dnn.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.dnp != null) {
                SwanAppBgMusicPlayerImpl.this.dnp.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.dnn.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.dnm == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.LV().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.LV().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.dnn.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.LV().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.LV().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.dnn.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.dnn.onGetPosition(currentPosition, aH(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int aH(int i, int i2) {
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
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.bgmusic.SwanAppBgMusicPlayerImpl.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            SwanAppBgMusicPlayerImpl.this.EP();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void LY() {
        if (!this.aVc) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dno == null) {
                this.dno = new a();
            }
            this.aVc = this.mAudioManager.requestAudioFocus(this.dno, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP() {
        if (this.aVc) {
            if (this.mAudioManager != null && this.dno != null) {
                this.mAudioManager.abandonAudioFocus(this.dno);
                this.mAudioManager = null;
                this.dno = null;
            }
            this.aVc = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
