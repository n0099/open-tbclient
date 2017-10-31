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
    private IQuickMediaPlayer aVZ;
    private g.a aWa;
    private g.InterfaceC0121g aWb;
    private g.b aWc;
    private g.c aWd;
    private g.e aWe;
    private g.h aWf;
    private g.f aWg;
    private g.i aWh;
    private g.d aWi;
    private b aWk;
    private Context mContext;
    private boolean aWl = false;
    private Handler.Callback aWm = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.KB().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.KB().b(e.this);
                e.this.a(e.this.aVZ);
                e.this.aVZ = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aVZ);
            } else if (message.what == 4) {
                e.this.c(e.this.aVZ);
            } else if (message.what == 5) {
                e.this.gj(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.KE();
            }
            return true;
        }
    };
    private Handler.Callback aWn = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aWb != null) {
                    e.this.aWb.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aWa != null) {
                    e.this.aWa.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.c.c)) {
                    com.baidu.tieba.play.c.c cVar = (com.baidu.tieba.play.c.c) message.obj;
                    if (e.this.aWc != null) {
                        e.this.aWc.onError(e.this, cVar.what, cVar.exE);
                    }
                    if (e.this.aWd != null) {
                        e.this.aWd.a(e.this, cVar.exD, cVar.what, cVar.exE);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.aWe != null) {
                    e.this.aWe.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 11) {
                if (e.this.aWg != null) {
                    e.this.aWg.onReleaseFinished();
                }
            } else if (message.what == 12) {
                if (e.this.aWf != null) {
                    e.this.aWf.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.aWh != null) {
                    e.this.aWh.onSubError(message.arg1, message.arg2);
                }
            } else if (message.what == 14 && e.this.aWi != null && (message.obj instanceof String)) {
                e.this.aWi.onHandleOppoError((String) message.obj);
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.KA().getLooper(), this.aWm);
    private Handler aWj = new Handler(Looper.getMainLooper(), this.aWn);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.hi(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.aWk = bVar;
        try {
            this.aVZ = d.KB().createPlayer();
            this.aVZ.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bgY() == 0) | this.aWl);
            this.aVZ.setListener(new PlayerListener(this.aWj));
            this.aVZ.openVideo(this.aWk.getUri(), new Surface(this.aWk.getSurfaceTexture()), this.aWk.getHost());
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
        this.aWk = bVar;
        try {
            this.aVZ = d.KB().createPlayer();
            this.aVZ.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bgY() == 0) | this.aWl);
            this.aVZ.setListener(new PlayerListener(this.aWj));
            this.aVZ.openVideo(this.aWk.getUri(), new Surface(this.aWk.getSurfaceTexture()), this.aWk.getHost());
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
    public void KE() {
        gj(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.InterfaceC0121g interfaceC0121g) {
        this.aWb = interfaceC0121g;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.aWa = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.aWd = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.aWe = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.f fVar) {
        this.aWg = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.h hVar) {
        this.aWf = hVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.aWh = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.aWi = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void start() {
        if (this.mHandler.hasMessages(4)) {
            this.mHandler.removeMessages(4);
        }
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
        if (this.aVZ != null) {
            try {
                return this.aVZ.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.aVZ != null) {
            try {
                return this.aVZ.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.aVZ != null) {
            try {
                return this.aVZ.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.aVZ != null) {
            try {
                return this.aVZ.getVideoHeight();
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
    public void gj(int i) {
        if (this.aVZ != null) {
            try {
                this.aVZ.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.aVZ != null) {
            try {
                return this.aVZ.isPlaying();
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
        if (this.aVZ != null) {
            try {
                this.aVZ.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.aVZ != null) {
            try {
                this.aVZ.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.aVZ != null) {
            try {
                return this.aVZ.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.aWl = z;
        try {
            this.aVZ.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.aVZ != null) {
            try {
                if (this.aVZ.isIjkPlayer()) {
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
    public void KD() {
        if (this.aWd != null) {
            this.aWd.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void GX() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aWj != null) {
            this.aWj.removeCallbacksAndMessages(null);
        }
    }
}
