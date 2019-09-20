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
    private MediaPlayer aBZ;
    private boolean aCf;
    private PlayerStatus deK = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a deL;
    private a deM;
    private c deN;
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
            this.deL = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.deK != PlayerStatus.NONE) {
                    Ha().reset();
                }
                Ha().setDataSource(a2.mUrl);
                this.deK = PlayerStatus.IDLE;
                this.deL.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.deL.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void xO() {
        zT();
        Ha().release();
        this.aBZ = null;
        this.deK = PlayerStatus.NONE;
        if (this.deN != null) {
            this.deN.removeMessages(0);
            this.deN = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.deK == PlayerStatus.PREPARED) {
            Hd();
            Ha().start();
            this.deL.onStateChanged(BgMusicPlayState.PLAY);
            if (this.deN != null) {
                this.deN.sendEmptyMessage(0);
            }
        } else if (this.deK == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Ha().prepareAsync();
            this.deK = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.deL.onInvokeFailed();
            xO();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (Ha().isPlaying()) {
            Ha().pause();
            this.deL.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.deN != null) {
                this.deN.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.deK == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Ha().stop();
            this.deK = PlayerStatus.IDLE;
            this.deL.onStateChanged(BgMusicPlayState.STOP);
            if (this.deN != null) {
                this.deN.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void seek(int i) {
        Ha().seekTo(i);
    }

    @Override // com.baidu.swan.apps.u.b.e
    public int getDuration() {
        return Ha().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.e
    public boolean isPlaying() {
        return Ha().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Ha() {
        if (this.aBZ == null) {
            this.aBZ = new MediaPlayer();
            b bVar = new b();
            this.aBZ.setOnPreparedListener(bVar);
            this.aBZ.setOnCompletionListener(bVar);
            this.aBZ.setOnErrorListener(bVar);
            this.aBZ.setOnBufferingUpdateListener(bVar);
            this.aBZ.setAudioStreamType(3);
            this.deN = new c();
        }
        return this.aBZ;
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
            SwanAppBgMusicPlayerImpl.this.deK = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.deL.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.deK = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.deL.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.deN != null) {
                SwanAppBgMusicPlayerImpl.this.deN.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.deL.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.deK == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Ha().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Ha().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.deL.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.Ha().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.Ha().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.deL.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.deL.onGetPosition(currentPosition, aI(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int aI(int i, int i2) {
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
                            SwanAppBgMusicPlayerImpl.this.zT();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Hd() {
        if (!this.aCf) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.deM == null) {
                this.deM = new a();
            }
            this.aCf = this.mAudioManager.requestAudioFocus(this.deM, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT() {
        if (this.aCf) {
            if (this.mAudioManager != null && this.deM != null) {
                this.mAudioManager.abandonAudioFocus(this.deM);
                this.mAudioManager = null;
                this.deM = null;
            }
            this.aCf = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
