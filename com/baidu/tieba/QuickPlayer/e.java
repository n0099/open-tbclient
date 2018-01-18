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
    private IQuickMediaPlayer bNl;
    private g.a bNm;
    private g.f bNn;
    private g.b bNo;
    private g.c bNp;
    private g.e bNq;
    private g.InterfaceC0149g bNr;
    private g.i bNs;
    private g.d bNt;
    private g.h bNu;
    private b bNv;
    private Context mContext;
    private boolean bNw = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Sv().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Sv().b(e.this);
                e.this.a(e.this.bNl);
                e.this.bNl = null;
            } else if (message.what == 3) {
                e.this.b(e.this.bNl);
            } else if (message.what == 4) {
                e.this.c(e.this.bNl);
            } else if (message.what == 5) {
                e.this.jl(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.Sz();
            }
            return true;
        }
    };
    private Handler.Callback bNx = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bNn != null) {
                    e.this.bNn.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bNm != null) {
                    e.this.bNm.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.c.d)) {
                    com.baidu.tieba.play.c.d dVar = (com.baidu.tieba.play.c.d) message.obj;
                    if (e.this.bNo != null) {
                        e.this.bNo.onError(e.this, dVar.what, dVar.guv);
                    }
                    if (e.this.bNp != null) {
                        e.this.bNp.a(e.this, dVar.guu, dVar.what, dVar.guv);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.bNq != null) {
                    e.this.bNq.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bNr != null) {
                    e.this.bNr.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.bNs != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.bNs.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bNt != null && (message.obj instanceof String)) {
                    e.this.bNt.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bNu != null && (message.obj instanceof Long)) {
                e.this.bNu.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Su().getLooper(), this.mHandlerCallback);
    private Handler Ga = new Handler(Looper.getMainLooper(), this.bNx);

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
        Map<String, String> HZ;
        this.bNv = bVar;
        try {
            this.bNl = d.Sv().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.HY()) && (HZ = com.baidu.tbadk.coreExtra.model.f.HZ()) != null) {
                for (Map.Entry<String, String> entry : HZ.entrySet()) {
                    this.bNl.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bNl.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bjC() == 0) | this.bNw);
            this.bNl.setListener(new PlayerListener(this.Ga));
            this.bNl.openVideo(this.bNv.getUri(), new Surface(this.bNv.getSurfaceTexture()), this.bNv.getHost());
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
        Map<String, String> HZ;
        this.bNv = bVar;
        try {
            this.bNl = d.Sv().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.HY()) && (HZ = com.baidu.tbadk.coreExtra.model.f.HZ()) != null) {
                for (Map.Entry<String, String> entry : HZ.entrySet()) {
                    this.bNl.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bNl.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bjC() == 0) | this.bNw);
            this.bNl.setListener(new PlayerListener(this.Ga));
            this.bNl.openVideo(this.bNv.getUri(), new Surface(this.bNv.getSurfaceTexture()), this.bNv.getHost());
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
    public void Sz() {
        jl(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bNn = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bNm = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bNp = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.bNq = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0149g interfaceC0149g) {
        this.bNr = interfaceC0149g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.bNs = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bNt = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bNu = hVar;
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
        if (this.bNl != null) {
            try {
                return this.bNl.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.bNl != null) {
            try {
                return this.bNl.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int SA() {
        if (this.bNl != null) {
            try {
                return this.bNl.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.bNl != null) {
            try {
                return this.bNl.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.bNl != null) {
            try {
                return this.bNl.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.bNl != null) {
            try {
                return this.bNl.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.bNl != null) {
            try {
                return this.bNl.getVideoHeight();
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
        if (this.bNl != null) {
            try {
                this.bNl.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.bNl != null) {
            try {
                return this.bNl.isPlaying();
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
        if (this.bNl != null) {
            try {
                this.bNl.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.bNl != null) {
            try {
                this.bNl.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.bNl != null) {
            try {
                return this.bNl.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.bNw = z;
        try {
            this.bNl.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.bNl != null) {
            try {
                if (this.bNl.isIjkPlayer()) {
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
    public void Sy() {
        if (this.bNp != null) {
            this.bNp.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void OD() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.Ga != null) {
            this.Ga.removeCallbacksAndMessages(null);
        }
    }
}
