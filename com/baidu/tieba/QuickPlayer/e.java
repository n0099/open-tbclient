package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
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
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.h bPA;
    private b bPB;
    private IQuickMediaPlayer bPr;
    private g.a bPs;
    private g.f bPt;
    private g.b bPu;
    private g.c bPv;
    private g.e bPw;
    private g.InterfaceC0220g bPx;
    private g.i bPy;
    private g.d bPz;
    private Context mContext;
    private boolean bPC = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Te().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Te().b(e.this);
                e.this.a(e.this.bPr);
                e.this.bPr = null;
            } else if (message.what == 3) {
                e.this.b(e.this.bPr);
            } else if (message.what == 4) {
                e.this.c(e.this.bPr);
            } else if (message.what == 5) {
                e.this.jh(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.Tk();
            }
            return true;
        }
    };
    private Handler.Callback bPD = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bPt != null) {
                    e.this.bPt.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bPs != null) {
                    e.this.bPs.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.bPu != null) {
                        e.this.bPu.onError(e.this, dVar.what, dVar.gwB);
                    }
                    if (e.this.bPv != null) {
                        e.this.bPv.a(e.this, dVar.gwA, dVar.what, dVar.gwB);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.bPw != null) {
                    e.this.bPw.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bPx != null) {
                    e.this.bPx.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.bPy != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.bPy.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bPz != null && (message.obj instanceof String)) {
                    e.this.bPz.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bPA != null && (message.obj instanceof Long)) {
                e.this.bPA.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Td().getLooper(), this.mHandlerCallback);
    private Handler FU = new Handler(Looper.getMainLooper(), this.bPD);

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
        this.bPB = bVar;
        try {
            this.bPr = d.Te().createPlayer();
            if (this.bPr != null) {
                Ti();
            } else {
                Tj();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ti() throws RemoteException {
        Map<String, String> IH;
        if (this.bPr != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.IG()) && (IH = com.baidu.tbadk.coreExtra.model.f.IH()) != null) {
                for (Map.Entry<String, String> entry : IH.entrySet()) {
                    this.bPr.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bPr.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bkN() == 0) | this.bPC);
            this.bPr.setListener(new PlayerListener(this.FU));
            this.bPr.openVideo(this.bPB.getUri(), new Surface(this.bPB.getSurfaceTexture()), this.bPB.getHost());
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
        this.bPB = bVar;
        try {
            this.bPr = d.Te().createPlayer();
            if (this.bPr != null) {
                Ti();
            } else {
                Tj();
            }
            if (i == 3) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(7), 1000L);
            } else if (i == 2) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4), 1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Tj() {
        d.Te().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.bPr = iQuickMediaPlayerService.createPlayer();
                    e.this.Ti();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.Te().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tk() {
        jh(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bPt = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bPs = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bPv = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.bPw = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0220g interfaceC0220g) {
        this.bPx = interfaceC0220g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.bPy = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bPz = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bPA = hVar;
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
        if (this.bPr != null) {
            try {
                return this.bPr.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.bPr != null) {
            try {
                return this.bPr.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int Tl() {
        if (this.bPr != null) {
            try {
                return this.bPr.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.bPr != null) {
            try {
                return this.bPr.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.bPr != null) {
            try {
                return this.bPr.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.bPr != null) {
            try {
                return this.bPr.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.bPr != null) {
            try {
                return this.bPr.getVideoHeight();
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
    public void jh(int i) {
        if (this.bPr != null) {
            try {
                this.bPr.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.bPr != null) {
            try {
                return this.bPr.isPlaying();
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
        if (this.bPr != null) {
            try {
                this.bPr.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.bPr != null) {
            try {
                this.bPr.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.bPr != null) {
            try {
                return this.bPr.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.bPC = z;
        try {
            this.bPr.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.bPr != null) {
            try {
                if (this.bPr.isIjkPlayer()) {
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

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void Th() {
        if (this.bPv != null) {
            this.bPv.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Pk() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.FU != null) {
            this.FU.removeCallbacksAndMessages(null);
        }
    }
}
