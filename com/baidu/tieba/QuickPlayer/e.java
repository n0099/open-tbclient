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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.t.s;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.g;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b cTy;
    private IQuickMediaPlayer dcR;
    private g.a dcS;
    private g.f dcT;
    private g.c dcU;
    private g.e dcV;
    private g.InterfaceC0493g dcW;
    private g.i dcX;
    private g.d dcY;
    private g.h dcZ;
    private b dda;
    private boolean mPlayerReuseEnable;
    private boolean ddb = false;
    private boolean ddc = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.aBU().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.aBU().b(e.this);
                e.this.a(e.this.dcR);
                e.this.dcR = null;
            } else if (message.what == 3) {
                e.this.b(e.this.dcR);
            } else if (message.what == 4) {
                e.this.c(e.this.dcR);
            } else if (message.what == 5) {
                e.this.lr(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.aCb();
            }
            return true;
        }
    };
    private Handler.Callback ddd = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.dcT != null) {
                    e.this.dcT.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.dcS != null) {
                    e.this.dcS.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.c.d)) {
                    com.baidu.tieba.play.c.d dVar = (com.baidu.tieba.play.c.d) message.obj;
                    if (e.this.cTy != null) {
                        e.this.cTy.onError(e.this, dVar.what, dVar.iAu);
                    }
                    if (e.this.dcU != null) {
                        e.this.dcU.a(e.this, dVar.iAt, dVar.what, dVar.iAu);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.dcV != null) {
                    e.this.dcV.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.dcW != null) {
                    e.this.dcW.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.dcX != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.dcX.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.dcY != null && (message.obj instanceof String)) {
                    e.this.dcY.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.dcZ != null && (message.obj instanceof Long)) {
                e.this.dcZ.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.aBS().aBT(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.ddd);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str, boolean z) {
        if (surfaceTexture != null) {
            this.mPlayerReuseEnable = z;
            b bVar = new b();
            bVar.setUri(uri);
            bVar.setHeaders(map);
            bVar.setSurfaceTexture(surfaceTexture);
            bVar.setHost(str);
            Message obtainMessage = this.mHandler.obtainMessage(1);
            obtainMessage.obj = bVar;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.dda = bVar;
        try {
            this.dcR = d.aBU().createPlayer();
            if (this.dcR != null) {
                aBZ();
            } else {
                aCa();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBZ() throws RemoteException {
        Map<String, String> arM;
        if (this.dcR != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.arL()) && (arM = com.baidu.tbadk.coreExtra.model.f.arM()) != null) {
                for (Map.Entry<String, String> entry : arM.entrySet()) {
                    this.dcR.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.dcR.forceUseSystemMediaPlayer((s.axg() == 0) | this.ddb);
            this.dcR.setListener(new PlayerListener(this.mMainThreadHandler));
            this.dcR.openVideo(this.dda.getUri(), new Surface(this.dda.getSurfaceTexture()), this.dda.getHost(), this.mPlayerReuseEnable);
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
        this.dda = bVar;
        try {
            this.dcR = d.aBU().createPlayer();
            if (this.dcR != null) {
                aBZ();
            } else {
                aCa();
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

    private void aCa() {
        d.aBU().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.dcR = iQuickMediaPlayerService.createPlayer();
                    e.this.aBZ();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.aBU().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCb() {
        lr(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.dcT = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.dcS = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnErrorListener(g.b bVar) {
        this.cTy = bVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.dcU = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.dcV = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0493g interfaceC0493g) {
        this.dcW = interfaceC0493g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.dcX = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.dcY = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.dcZ = hVar;
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
        if (this.dcR != null) {
            try {
                return this.dcR.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.dcR != null) {
            try {
                return this.dcR.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int aCc() {
        if (this.dcR != null) {
            try {
                return this.dcR.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.dcR != null) {
            try {
                return this.dcR.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.dcR != null) {
            try {
                return this.dcR.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.dcR != null) {
            try {
                return this.dcR.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.dcR != null) {
            try {
                return this.dcR.getVideoHeight();
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
    public void lr(int i) {
        if (this.dcR != null) {
            try {
                this.dcR.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.dcR != null) {
            try {
                return this.dcR.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlayerReuse() {
        if (this.dcR != null) {
            try {
                return this.dcR.isPlayerReuse();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i) {
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
        if (this.dcR != null) {
            try {
                this.dcR.setVolume(f, f2);
                this.ddc = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean aCd() {
        return this.ddc;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.dcR != null) {
            try {
                this.dcR.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setSurface(SurfaceTexture surfaceTexture) {
        if (this.dcR != null) {
            try {
                this.dcR.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.dcR != null) {
            try {
                return this.dcR.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public List<String> getMediaIDs() {
        return null;
    }

    @Override // com.baidu.tieba.play.g
    public String getId() {
        return null;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.ddb = z;
        try {
            this.dcR.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.dcR != null) {
            try {
                return this.dcR.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void aBX() {
        if (this.dcU != null) {
            this.dcU.a(this, -300, -14399, -14399);
            TiebaStatic.log(new an("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void axK() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
