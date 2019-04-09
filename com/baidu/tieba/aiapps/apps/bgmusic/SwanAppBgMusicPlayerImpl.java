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
    private boolean aAc;
    private MediaPlayer azW;
    private PlayerStatus cSS = PlayerStatus.NONE;
    private com.baidu.swan.apps.media.audio.service.a cST;
    private a cSU;
    private c cSV;
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
            this.cST = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.cSS != PlayerStatus.NONE) {
                    Eq().reset();
                }
                Eq().setDataSource(a2.mUrl);
                this.cSS = PlayerStatus.IDLE;
                this.cST.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.cST.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void onRelease() {
        yo();
        Eq().release();
        this.azW = null;
        this.cSS = PlayerStatus.NONE;
        if (this.cSV != null) {
            this.cSV.removeMessages(0);
            this.cSV = null;
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void play() {
        if (this.cSS == PlayerStatus.PREPARED) {
            Et();
            Eq().start();
            this.cST.onStateChanged(BgMusicPlayState.PLAY);
            if (this.cSV != null) {
                this.cSV.sendEmptyMessage(0);
            }
        } else if (this.cSS == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Eq().prepareAsync();
            this.cSS = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.cST.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void pause() {
        if (Eq().isPlaying()) {
            Eq().pause();
            this.cST.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.cSV != null) {
                this.cSV.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.e
    public void stop() {
        if (this.cSS == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Eq().stop();
            this.cSS = PlayerStatus.IDLE;
            this.cST.onStateChanged(BgMusicPlayState.STOP);
            if (this.cSV != null) {
                this.cSV.removeMessages(0);
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
        if (this.azW == null) {
            this.azW = new MediaPlayer();
            b bVar = new b();
            this.azW.setOnPreparedListener(bVar);
            this.azW.setOnCompletionListener(bVar);
            this.azW.setOnErrorListener(bVar);
            this.azW.setOnBufferingUpdateListener(bVar);
            this.azW.setAudioStreamType(3);
            this.cSV = new c();
        }
        return this.azW;
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
            SwanAppBgMusicPlayerImpl.this.cSS = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cST.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.cSS = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.cST.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.cSV != null) {
                SwanAppBgMusicPlayerImpl.this.cSV.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.cST.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.cSS == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Eq().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Eq().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.cST.onStateChanged(BgMusicPlayState.LOADING);
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
                SwanAppBgMusicPlayerImpl.this.cST.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.cST.onGetPosition(currentPosition, aD(duration, currentPosition));
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
        if (!this.aAc) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.cSU == null) {
                this.cSU = new a();
            }
            this.aAc = this.mAudioManager.requestAudioFocus(this.cSU, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo() {
        if (this.aAc) {
            if (this.mAudioManager != null && this.cSU != null) {
                this.mAudioManager.abandonAudioFocus(this.cSU);
                this.mAudioManager = null;
                this.cSU = null;
            }
            this.aAc = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
