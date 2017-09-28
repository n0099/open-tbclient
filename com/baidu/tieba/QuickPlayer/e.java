package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.g;
import java.util.Map;
/* loaded from: classes.dex */
public class e implements d.a, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private IQuickMediaPlayer aWc;
    private g.a aWd;
    private g.f aWe;
    private g.b aWf;
    private g.c aWg;
    private g.d aWh;
    private g.InterfaceC0121g aWi;
    private g.e aWj;
    private b aWl;
    private Context mContext;
    private boolean aWm = false;
    private Handler.Callback aWn = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Ky().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Ky().b(e.this);
                e.this.a(e.this.aWc);
                e.this.aWc = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aWc);
            } else if (message.what == 4) {
                e.this.c(e.this.aWc);
            } else if (message.what == 5) {
                e.this.gb(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.KB();
            }
            return true;
        }
    };
    private Handler.Callback aWo = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aWe != null) {
                    e.this.aWe.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aWd != null) {
                    e.this.aWd.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.c)) {
                    com.baidu.tieba.play.b.c cVar = (com.baidu.tieba.play.b.c) message.obj;
                    if (e.this.aWf != null) {
                        e.this.aWf.onError(e.this, cVar.what, cVar.fyu);
                    }
                    if (e.this.aWg != null) {
                        e.this.aWg.a(e.this, cVar.fyt, cVar.what, cVar.fyu);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.aWh != null) {
                    e.this.aWh.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 11) {
                if (e.this.aWj != null) {
                    e.this.aWj.onReleaseFinished();
                }
            } else if (message.what == 12 && e.this.aWi != null) {
                e.this.aWi.a(e.this);
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Kx().getLooper(), this.aWn);
    private Handler aWk = new Handler(Looper.getMainLooper(), this.aWo);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.hb(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.aWl = bVar;
        try {
            this.aWc = d.Ky().createPlayer();
            this.aWc.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bdW() == 0) | this.aWm);
            this.aWc.setListener(new PlayerListener(this.aWk));
            this.aWc.openVideo(this.aWl.getUri(), new Surface(this.aWl.getSurfaceTexture()), this.aWl.getHost());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public void release() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IQuickMediaPlayer iQuickMediaPlayer) {
        if (iQuickMediaPlayer != null) {
            try {
                iQuickMediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, int i) {
        this.aWl = bVar;
        try {
            this.aWc = d.Ky().createPlayer();
            this.aWc.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bdW() == 0) | this.aWm);
            this.aWc.setListener(new PlayerListener(this.aWk));
            this.aWc.openVideo(this.aWl.getUri(), new Surface(this.aWl.getSurfaceTexture()), this.aWl.getHost());
            if (i == 3) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(7), 1000L);
            } else if (i == 2) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4), 1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KB() {
        gb(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.aWe = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.aWd = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.aWg = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.aWh = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.aWj = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0121g interfaceC0121g) {
        this.aWi = interfaceC0121g;
    }

    @Override // com.baidu.tieba.play.g
    public void start() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IQuickMediaPlayer iQuickMediaPlayer) {
        if (iQuickMediaPlayer != null) {
            try {
                iQuickMediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void pause() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IQuickMediaPlayer iQuickMediaPlayer) {
        if (iQuickMediaPlayer != null) {
            try {
                iQuickMediaPlayer.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getDuration() {
        if (this.aWc != null) {
            try {
                return this.aWc.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.aWc != null) {
            try {
                return this.aWc.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.aWc != null) {
            try {
                return this.aWc.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.aWc != null) {
            try {
                return this.aWc.getVideoHeight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public void seekTo(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(int i) {
        if (this.aWc != null) {
            try {
                this.aWc.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.aWc != null) {
            try {
                return this.aWc.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(10);
        obtainMessage.obj = bVar;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // com.baidu.tieba.play.g
    public void setVolume(float f, float f2) {
        if (this.aWc != null) {
            try {
                this.aWc.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.aWc != null) {
            try {
                this.aWc.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.aWc != null) {
            try {
                return this.aWc.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.aWm = z;
        try {
            this.aWc.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.aWc != null) {
            try {
                if (this.aWc.isIjkPlayer()) {
                    return SapiErrorCode.NETWORK_FAILED;
                }
                return -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.a
    public void KA() {
        if (this.aWg != null) {
            this.aWg.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void GR() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aWk != null) {
            this.aWk.removeCallbacksAndMessages(null);
        }
    }
}
