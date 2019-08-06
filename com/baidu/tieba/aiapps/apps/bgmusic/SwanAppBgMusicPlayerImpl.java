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
    private MediaPlayer aBB;
    private boolean aBH;
    private PlayerStatus dcX = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a dcY;
    private a dcZ;
    private c dda;
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
            this.dcY = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.dcX != PlayerStatus.NONE) {
                    GW().reset();
                }
                GW().setDataSource(a2.mUrl);
                this.dcX = PlayerStatus.IDLE;
                this.dcY.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.dcY.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void xK() {
        zP();
        GW().release();
        this.aBB = null;
        this.dcX = PlayerStatus.NONE;
        if (this.dda != null) {
            this.dda.removeMessages(0);
            this.dda = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.dcX == PlayerStatus.PREPARED) {
            GZ();
            GW().start();
            this.dcY.onStateChanged(BgMusicPlayState.PLAY);
            if (this.dda != null) {
                this.dda.sendEmptyMessage(0);
            }
        } else if (this.dcX == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            GW().prepareAsync();
            this.dcX = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.dcY.onInvokeFailed();
            xK();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (GW().isPlaying()) {
            GW().pause();
            this.dcY.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.dda != null) {
                this.dda.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.dcX == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            GW().stop();
            this.dcX = PlayerStatus.IDLE;
            this.dcY.onStateChanged(BgMusicPlayState.STOP);
            if (this.dda != null) {
                this.dda.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void seek(int i) {
        GW().seekTo(i);
    }

    @Override // com.baidu.swan.apps.u.b.e
    public int getDuration() {
        return GW().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.e
    public boolean isPlaying() {
        return GW().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer GW() {
        if (this.aBB == null) {
            this.aBB = new MediaPlayer();
            b bVar = new b();
            this.aBB.setOnPreparedListener(bVar);
            this.aBB.setOnCompletionListener(bVar);
            this.aBB.setOnErrorListener(bVar);
            this.aBB.setOnBufferingUpdateListener(bVar);
            this.aBB.setAudioStreamType(3);
            this.dda = new c();
        }
        return this.aBB;
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
            SwanAppBgMusicPlayerImpl.this.dcX = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dcY.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.dcX = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dcY.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.dda != null) {
                SwanAppBgMusicPlayerImpl.this.dda.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.dcY.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.dcX == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.GW().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.GW().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.dcY.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.GW().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.GW().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.dcY.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.dcY.onGetPosition(currentPosition, aI(duration, currentPosition));
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
                            SwanAppBgMusicPlayerImpl.this.zP();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void GZ() {
        if (!this.aBH) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dcZ == null) {
                this.dcZ = new a();
            }
            this.aBH = this.mAudioManager.requestAudioFocus(this.dcZ, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zP() {
        if (this.aBH) {
            if (this.mAudioManager != null && this.dcZ != null) {
                this.mAudioManager.abandonAudioFocus(this.dcZ);
                this.mAudioManager = null;
                this.dcZ = null;
            }
            this.aBH = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
