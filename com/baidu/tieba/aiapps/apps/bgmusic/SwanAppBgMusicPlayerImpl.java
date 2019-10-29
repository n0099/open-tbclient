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
    private MediaPlayer aVo;
    private boolean aVu;
    private PlayerStatus dof = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a dog;
    private a doh;
    private c doi;
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
            this.dog = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.dof != PlayerStatus.NONE) {
                    LU().reset();
                }
                LU().setDataSource(a2.mUrl);
                this.dof = PlayerStatus.IDLE;
                this.dog.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.dog.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void CJ() {
        EO();
        LU().release();
        this.aVo = null;
        this.dof = PlayerStatus.NONE;
        if (this.doi != null) {
            this.doi.removeMessages(0);
            this.doi = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.dof == PlayerStatus.PREPARED) {
            LX();
            LU().start();
            this.dog.onStateChanged(BgMusicPlayState.PLAY);
            if (this.doi != null) {
                this.doi.sendEmptyMessage(0);
            }
        } else if (this.dof == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            LU().prepareAsync();
            this.dof = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.dog.onInvokeFailed();
            CJ();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (LU().isPlaying()) {
            LU().pause();
            this.dog.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.doi != null) {
                this.doi.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.dof == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            LU().stop();
            this.dof = PlayerStatus.IDLE;
            this.dog.onStateChanged(BgMusicPlayState.STOP);
            if (this.doi != null) {
                this.doi.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void seek(int i) {
        LU().seekTo(i);
    }

    @Override // com.baidu.swan.apps.u.b.e
    public int getDuration() {
        return LU().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.e
    public boolean isPlaying() {
        return LU().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer LU() {
        if (this.aVo == null) {
            this.aVo = new MediaPlayer();
            b bVar = new b();
            this.aVo.setOnPreparedListener(bVar);
            this.aVo.setOnCompletionListener(bVar);
            this.aVo.setOnErrorListener(bVar);
            this.aVo.setOnBufferingUpdateListener(bVar);
            this.aVo.setAudioStreamType(3);
            this.doi = new c();
        }
        return this.aVo;
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
            SwanAppBgMusicPlayerImpl.this.dof = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dog.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.dof = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dog.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.doi != null) {
                SwanAppBgMusicPlayerImpl.this.doi.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.dog.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.dof == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.LU().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.LU().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.dog.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.LU().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.LU().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.dog.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.dog.onGetPosition(currentPosition, aJ(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int aJ(int i, int i2) {
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
                            SwanAppBgMusicPlayerImpl.this.EO();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void LX() {
        if (!this.aVu) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.doh == null) {
                this.doh = new a();
            }
            this.aVu = this.mAudioManager.requestAudioFocus(this.doh, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        if (this.aVu) {
            if (this.mAudioManager != null && this.doh != null) {
                this.mAudioManager.abandonAudioFocus(this.doh);
                this.mAudioManager = null;
                this.doh = null;
            }
            this.aVu = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
