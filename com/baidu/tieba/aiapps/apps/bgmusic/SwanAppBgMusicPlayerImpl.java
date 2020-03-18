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
    private boolean bbA;
    private MediaPlayer bbx;
    private com.baidu.swan.apps.media.audio.service.a bbz;
    private PlayerStatus edV = PlayerStatus.NONE;
    private a edW;
    private c edX;
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
            this.bbz = aVar;
            try {
                com.baidu.swan.apps.media.audio.a a2 = com.baidu.swan.apps.media.audio.a.a(new JSONObject(str), new com.baidu.swan.apps.media.audio.a());
                if (this.edV != PlayerStatus.NONE) {
                    HG().reset();
                }
                HG().setDataSource(a2.mUrl);
                this.edV = PlayerStatus.IDLE;
                this.bbz.onGetCurrentSong(a2.mUrl);
                play();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                this.bbz.onInvokeFailed();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void onRelease() {
        zh();
        HG().release();
        this.bbx = null;
        this.edV = PlayerStatus.NONE;
        if (this.edX != null) {
            this.edX.removeMessages(0);
            this.edX = null;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void play() {
        if (this.edV == PlayerStatus.PREPARED) {
            zg();
            HG().start();
            this.bbz.onStateChanged(BgMusicPlayState.PLAY);
            if (this.edX != null) {
                this.edX.sendEmptyMessage(0);
            }
        } else if (this.edV == PlayerStatus.IDLE) {
            prepare();
        }
    }

    private void prepare() {
        try {
            HG().prepareAsync();
            this.edV = PlayerStatus.PREPARING;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.bbz.onInvokeFailed();
            onRelease();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void pause() {
        if (HG().isPlaying()) {
            HG().pause();
            this.bbz.onStateChanged(BgMusicPlayState.PAUSE);
            if (this.edX != null) {
                this.edX.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void stop() {
        if (this.edV == PlayerStatus.PREPARED) {
            if (DEBUG) {
                Log.d("AudioPlayerListener", "===stop");
            }
            HG().stop();
            this.edV = PlayerStatus.IDLE;
            this.bbz.onStateChanged(BgMusicPlayState.STOP);
            if (this.edX != null) {
                this.edX.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public void seek(int i) {
        HG().seekTo(i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public int getDuration() {
        return HG().getDuration();
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public boolean isPlaying() {
        return HG().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer HG() {
        if (this.bbx == null) {
            this.bbx = new MediaPlayer();
            b bVar = new b();
            this.bbx.setOnPreparedListener(bVar);
            this.bbx.setOnCompletionListener(bVar);
            this.bbx.setOnErrorListener(bVar);
            this.bbx.setOnBufferingUpdateListener(bVar);
            this.bbx.setAudioStreamType(3);
            this.edX = new c();
        }
        return this.bbx;
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
            SwanAppBgMusicPlayerImpl.this.edV = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbz.onStateChanged(BgMusicPlayState.READY);
            SwanAppBgMusicPlayerImpl.this.play();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (SwanAppBgMusicPlayerImpl.DEBUG) {
                Log.d("AudioPlayerListener", "--onCompletion");
            }
            SwanAppBgMusicPlayerImpl.this.edV = PlayerStatus.PREPARED;
            SwanAppBgMusicPlayerImpl.this.bbz.onStateChanged(BgMusicPlayState.END);
            if (SwanAppBgMusicPlayerImpl.this.edX != null) {
                SwanAppBgMusicPlayerImpl.this.edX.removeMessages(0);
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
            SwanAppBgMusicPlayerImpl.this.bbz.onGetDownloadProgress(i);
            if (SwanAppBgMusicPlayerImpl.this.edV == PlayerStatus.PREPARED && (SwanAppBgMusicPlayerImpl.this.HG().getDuration() * i) / 100 <= SwanAppBgMusicPlayerImpl.this.HG().getCurrentPosition()) {
                SwanAppBgMusicPlayerImpl.this.bbz.onStateChanged(BgMusicPlayState.LOADING);
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
                int duration = SwanAppBgMusicPlayerImpl.this.HG().getDuration();
                int currentPosition = SwanAppBgMusicPlayerImpl.this.HG().getCurrentPosition();
                SwanAppBgMusicPlayerImpl.this.bbz.onGetDuration(duration);
                SwanAppBgMusicPlayerImpl.this.bbz.onGetPosition(currentPosition, W(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        private int W(int i, int i2) {
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
                            SwanAppBgMusicPlayerImpl.this.zh();
                            SwanAppBgMusicPlayerImpl.this.pause();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    private void zg() {
        if (!this.bbA) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
                if (this.mAudioManager == null) {
                    return;
                }
            }
            if (this.edW == null) {
                this.edW = new a();
            }
            this.bbA = this.mAudioManager.requestAudioFocus(this.edW, 3, 1) == 1;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   requestAudioFocus");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        if (this.bbA) {
            if (this.mAudioManager != null && this.edW != null) {
                this.mAudioManager.abandonAudioFocus(this.edW);
                this.mAudioManager = null;
                this.edW = null;
            }
            this.bbA = false;
            if (DEBUG) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }
}
