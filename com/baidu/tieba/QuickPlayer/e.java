package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.g;
import java.util.Map;
/* loaded from: classes2.dex */
public class e implements d.a, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private IQuickMediaPlayer bNd;
    private g.a bNe;
    private g.f bNf;
    private g.b bNg;
    private g.c bNh;
    private g.e bNi;
    private g.InterfaceC0150g bNj;
    private g.i bNk;
    private g.d bNl;
    private g.h bNm;
    private b bNn;
    private Context mContext;
    private boolean bNo = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.SH().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.SH().b(e.this);
                e.this.a(e.this.bNd);
                e.this.bNd = null;
            } else if (message.what == 3) {
                e.this.b(e.this.bNd);
            } else if (message.what == 4) {
                e.this.c(e.this.bNd);
            } else if (message.what == 5) {
                e.this.jp(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.SL();
            }
            return true;
        }
    };
    private Handler.Callback bNp = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bNf != null) {
                    e.this.bNf.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bNe != null) {
                    e.this.bNe.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.c.d)) {
                    com.baidu.tieba.play.c.d dVar = (com.baidu.tieba.play.c.d) message.obj;
                    if (e.this.bNg != null) {
                        e.this.bNg.onError(e.this, dVar.what, dVar.gFn);
                    }
                    if (e.this.bNh != null) {
                        e.this.bNh.a(e.this, dVar.gFm, dVar.what, dVar.gFn);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.bNi != null) {
                    e.this.bNi.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bNj != null) {
                    e.this.bNj.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.bNk != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.bNk.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bNl != null && (message.obj instanceof String)) {
                    e.this.bNl.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bNm != null && (message.obj instanceof Long)) {
                e.this.bNm.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.SG().getLooper(), this.mHandlerCallback);
    private Handler Ga = new Handler(Looper.getMainLooper(), this.bNp);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.setSurfaceTexture(surfaceTexture);
        bVar.setHost(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Map<String, String> Ig;
        this.bNn = bVar;
        try {
            this.bNd = d.SH().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.If()) && (Ig = com.baidu.tbadk.coreExtra.model.f.Ig()) != null) {
                for (Map.Entry<String, String> entry : Ig.entrySet()) {
                    this.bNd.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bNd.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bqj() == 0) | this.bNo);
            this.bNd.setListener(new PlayerListener(this.Ga));
            this.bNd.openVideo(this.bNn.getUri(), new Surface(this.bNn.getSurfaceTexture()), this.bNn.getHost());
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
        Map<String, String> Ig;
        this.bNn = bVar;
        try {
            this.bNd = d.SH().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.If()) && (Ig = com.baidu.tbadk.coreExtra.model.f.Ig()) != null) {
                for (Map.Entry<String, String> entry : Ig.entrySet()) {
                    this.bNd.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bNd.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bqj() == 0) | this.bNo);
            this.bNd.setListener(new PlayerListener(this.Ga));
            this.bNd.openVideo(this.bNn.getUri(), new Surface(this.bNn.getSurfaceTexture()), this.bNn.getHost());
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
    public void SL() {
        jp(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bNf = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bNe = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bNh = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.bNi = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0150g interfaceC0150g) {
        this.bNj = interfaceC0150g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.bNk = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bNl = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bNm = hVar;
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
        if (this.bNd != null) {
            try {
                return this.bNd.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.bNd != null) {
            try {
                return this.bNd.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int SM() {
        if (this.bNd != null) {
            try {
                return this.bNd.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.bNd != null) {
            try {
                return this.bNd.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.bNd != null) {
            try {
                return this.bNd.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.bNd != null) {
            try {
                return this.bNd.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.bNd != null) {
            try {
                return this.bNd.getVideoHeight();
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
    public void jp(int i) {
        if (this.bNd != null) {
            try {
                this.bNd.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.bNd != null) {
            try {
                return this.bNd.isPlaying();
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
        bVar.setSurfaceTexture(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(10);
        obtainMessage.obj = bVar;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // com.baidu.tieba.play.g
    public void setVolume(float f, float f2) {
        if (this.bNd != null) {
            try {
                this.bNd.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.bNd != null) {
            try {
                this.bNd.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.bNd != null) {
            try {
                return this.bNd.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.bNo = z;
        try {
            this.bNd.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.bNd != null) {
            try {
                if (this.bNd.isIjkPlayer()) {
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
    public void SK() {
        if (this.bNh != null) {
            this.bNh.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void OP() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.Ga != null) {
            this.Ga.removeCallbacksAndMessages(null);
        }
    }
}
