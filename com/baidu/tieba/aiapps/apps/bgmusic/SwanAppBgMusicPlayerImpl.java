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
    private MediaPlayer aAT;
    private boolean aAZ;
    private PlayerStatus dbn = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a dbo;
    private a dbp;
    private c dbq;
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
            this.dbo = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.dbn != PlayerStatus.NONE) {
                    Gm().reset();
                }
                Gm().setDataSource(a2.mUrl);
                this.dbn = PlayerStatus.IDLE;
                this.dbo.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.dbo.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void onRelease() {
        zi();
        Gm().release();
        this.aAT = null;
        this.dbn = PlayerStatus.NONE;
        if (this.dbq != null) {
            this.dbq.removeMessages(0);
            this.dbq = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.dbn == PlayerStatus.PREPARED) {
            Gp();
            Gm().start();
            this.dbo.onStateChanged(BgMusicPlayState.PLAY);
            if (this.dbq != null) {
                this.dbq.sendEmptyMessage(0);
            }
        } else if (this.dbn == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Gm().prepareAsync();
            this.dbn = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.dbo.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (Gm().isPlaying()) {
            Gm().pause();
            this.dbo.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.dbq != null) {
                this.dbq.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.dbn == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Gm().stop();
            this.dbn = PlayerStatus.IDLE;
            this.dbo.onStateChanged(BgMusicPlayState.STOP);
            if (this.dbq != null) {
                this.dbq.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void seek(int i) {
        Gm().seekTo(i);
    }

    @Override // com.baidu.swan.apps.u.b.e
    public int getDuration() {
        return Gm().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.e
    public boolean isPlaying() {
        return Gm().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Gm() {
        if (this.aAT == null) {
            this.aAT = new MediaPlayer();
            b bVar = new b();
            this.aAT.setOnPreparedListener(bVar);
            this.aAT.setOnCompletionListener(bVar);
            this.aAT.setOnErrorListener(bVar);
            this.aAT.setOnBufferingUpdateListener(bVar);
            this.aAT.setAudioStreamType(3);
            this.dbq = new c();
        }
        return this.aAT;
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
            SwanAppBgMusicPlayerImpl.this.dbn = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dbo.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.dbn = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.dbo.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.dbq != null) {
                SwanAppBgMusicPlayerImpl.this.dbq.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.dbo.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.dbn == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Gm().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Gm().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.dbo.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.Gm().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.Gm().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.dbo.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.dbo.onGetPosition(currentPosition, aD(duration, currentPosition));
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
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.bgmusic.SwanAppBgMusicPlayerImpl.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                                Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                            }
                            SwanAppBgMusicPlayerImpl.this.zi();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Gp() {
        if (!this.aAZ) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.dbp == null) {
                this.dbp = new a();
            }
            this.aAZ = this.mAudioManager.requestAudioFocus(this.dbp, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        if (this.aAZ) {
            if (this.mAudioManager != null && this.dbp != null) {
                this.mAudioManager.abandonAudioFocus(this.dbp);
                this.mAudioManager = null;
                this.dbp = null;
            }
            this.aAZ = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
