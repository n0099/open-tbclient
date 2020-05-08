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
    private MediaPlayer bzQ;
    private com.baidu.swan.apps.media.audio.service.a bzS;
    private boolean bzT;
    private PlayerStatus eDR = PlayerStatus.NONE;
    private a eDS;
    private c eDT;
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
            this.bzS = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.eDR != PlayerStatus.NONE) {
                    Ps().reset();
                }
                Ps().setDataSource(a2.mUrl);
                this.eDR = PlayerStatus.IDLE;
                this.bzS.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bzS.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        Eb();
        Ps().release();
        this.bzQ = null;
        this.eDR = PlayerStatus.NONE;
        if (this.eDT != null) {
            this.eDT.removeMessages(0);
            this.eDT = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.eDR == PlayerStatus.PREPARED) {
            Ea();
            Ps().start();
            this.bzS.onStateChanged(BgMusicPlayState.PLAY);
            if (this.eDT != null) {
                this.eDT.sendEmptyMessage(0);
            }
        } else if (this.eDR == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            Ps().prepareAsync();
            this.eDR = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bzS.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (Ps().isPlaying()) {
            Ps().pause();
            this.bzS.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.eDT != null) {
                this.eDT.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.eDR == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            Ps().stop();
            this.eDR = PlayerStatus.IDLE;
            this.bzS.onStateChanged(BgMusicPlayState.STOP);
            if (this.eDT != null) {
                this.eDT.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        Ps().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return Ps().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return Ps().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer Ps() {
        if (this.bzQ == null) {
            this.bzQ = new MediaPlayer();
            b bVar = new b();
            this.bzQ.setOnPreparedListener(bVar);
            this.bzQ.setOnCompletionListener(bVar);
            this.bzQ.setOnErrorListener(bVar);
            this.bzQ.setOnBufferingUpdateListener(bVar);
            this.bzQ.setAudioStreamType(3);
            this.eDT = new c();
        }
        return this.bzQ;
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
            SwanAppBgMusicPlayerImpl.this.eDR = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bzS.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.eDR = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bzS.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.eDT != null) {
                SwanAppBgMusicPlayerImpl.this.eDT.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.bzS.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.eDR == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.Ps().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.Ps().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.bzS.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.Ps().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.Ps().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.bzS.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.bzS.onGetPosition(currentPosition, Y(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int Y(int i, int i2) {
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
                            SwanAppBgMusicPlayerImpl.this.Eb();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void Ea() {
        if (!this.bzT) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.eDS == null) {
                this.eDS = new a();
            }
            this.bzT = this.mAudioManager.requestAudioFocus(this.eDS, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eb() {
        if (this.bzT) {
            if (this.mAudioManager != null && this.eDS != null) {
                this.mAudioManager.abandonAudioFocus(this.eDS);
                this.mAudioManager = null;
                this.eDS = null;
            }
            this.bzT = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
