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
    private g.i bNA;
    private g.d bNB;
    private g.h bNC;
    private b bND;
    private IQuickMediaPlayer bNt;
    private g.a bNu;
    private g.f bNv;
    private g.b bNw;
    private g.c bNx;
    private g.e bNy;
    private g.InterfaceC0150g bNz;
    private Context mContext;
    private boolean bNE = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Sx().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Sx().b(e.this);
                e.this.a(e.this.bNt);
                e.this.bNt = null;
            } else if (message.what == 3) {
                e.this.b(e.this.bNt);
            } else if (message.what == 4) {
                e.this.c(e.this.bNt);
            } else if (message.what == 5) {
                e.this.jl(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.SB();
            }
            return true;
        }
    };
    private Handler.Callback bNF = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bNv != null) {
                    e.this.bNv.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bNu != null) {
                    e.this.bNu.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.c.d)) {
                    com.baidu.tieba.play.c.d dVar = (com.baidu.tieba.play.c.d) message.obj;
                    if (e.this.bNw != null) {
                        e.this.bNw.onError(e.this, dVar.what, dVar.guQ);
                    }
                    if (e.this.bNx != null) {
                        e.this.bNx.a(e.this, dVar.guP, dVar.what, dVar.guQ);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.bNy != null) {
                    e.this.bNy.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bNz != null) {
                    e.this.bNz.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.bNA != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.bNA.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bNB != null && (message.obj instanceof String)) {
                    e.this.bNB.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bNC != null && (message.obj instanceof Long)) {
                e.this.bNC.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Sw().getLooper(), this.mHandlerCallback);
    private Handler Ga = new Handler(Looper.getMainLooper(), this.bNF);

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
        Map<String, String> Ib;
        this.bND = bVar;
        try {
            this.bNt = d.Sx().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.Ia()) && (Ib = com.baidu.tbadk.coreExtra.model.f.Ib()) != null) {
                for (Map.Entry<String, String> entry : Ib.entrySet()) {
                    this.bNt.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bNt.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bjD() == 0) | this.bNE);
            this.bNt.setListener(new PlayerListener(this.Ga));
            this.bNt.openVideo(this.bND.getUri(), new Surface(this.bND.getSurfaceTexture()), this.bND.getHost());
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
        Map<String, String> Ib;
        this.bND = bVar;
        try {
            this.bNt = d.Sx().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.Ia()) && (Ib = com.baidu.tbadk.coreExtra.model.f.Ib()) != null) {
                for (Map.Entry<String, String> entry : Ib.entrySet()) {
                    this.bNt.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bNt.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bjD() == 0) | this.bNE);
            this.bNt.setListener(new PlayerListener(this.Ga));
            this.bNt.openVideo(this.bND.getUri(), new Surface(this.bND.getSurfaceTexture()), this.bND.getHost());
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
    public void SB() {
        jl(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bNv = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bNu = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bNx = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.bNy = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0150g interfaceC0150g) {
        this.bNz = interfaceC0150g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.bNA = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bNB = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bNC = hVar;
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
        if (this.bNt != null) {
            try {
                return this.bNt.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.bNt != null) {
            try {
                return this.bNt.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int SC() {
        if (this.bNt != null) {
            try {
                return this.bNt.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.bNt != null) {
            try {
                return this.bNt.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.bNt != null) {
            try {
                return this.bNt.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.bNt != null) {
            try {
                return this.bNt.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.bNt != null) {
            try {
                return this.bNt.getVideoHeight();
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
    public void jl(int i) {
        if (this.bNt != null) {
            try {
                this.bNt.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.bNt != null) {
            try {
                return this.bNt.isPlaying();
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
        if (this.bNt != null) {
            try {
                this.bNt.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.bNt != null) {
            try {
                this.bNt.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.bNt != null) {
            try {
                return this.bNt.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.bNE = z;
        try {
            this.bNt.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.bNt != null) {
            try {
                if (this.bNt.isIjkPlayer()) {
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
    public void SA() {
        if (this.bNx != null) {
            this.bNx.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void OF() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.Ga != null) {
            this.Ga.removeCallbacksAndMessages(null);
        }
    }
}
