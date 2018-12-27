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
import com.baidu.searchbox.ng.ai.apps.trace.ReportLevel;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.g;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b boZ;
    private IQuickMediaPlayer bxK;
    private g.a bxL;
    private g.f bxM;
    private g.c bxN;
    private g.e bxO;
    private g.InterfaceC0298g bxP;
    private g.i bxQ;
    private g.d bxR;
    private g.h bxS;
    private b bxT;
    private boolean mPlayerReuseEnable;
    private boolean bxU = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.UH().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.UH().b(e.this);
                e.this.a(e.this.bxK);
                e.this.bxK = null;
            } else if (message.what == 3) {
                e.this.b(e.this.bxK);
            } else if (message.what == 4) {
                e.this.c(e.this.bxK);
            } else if (message.what == 5) {
                e.this.hx(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.UO();
            }
            return true;
        }
    };
    private Handler.Callback bxV = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bxM != null) {
                    e.this.bxM.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bxL != null) {
                    e.this.bxL.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.boZ != null) {
                        e.this.boZ.onError(e.this, dVar.what, dVar.gIf);
                    }
                    if (e.this.bxN != null) {
                        e.this.bxN.a(e.this, dVar.gIe, dVar.what, dVar.gIf);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.bxO != null) {
                    e.this.bxO.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bxP != null) {
                    e.this.bxP.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.bxQ != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.bxQ.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bxR != null && (message.obj instanceof String)) {
                    e.this.bxR.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bxS != null && (message.obj instanceof Long)) {
                e.this.bxS.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.UG().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.bxV);

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
        this.bxT = bVar;
        try {
            this.bxK = d.UH().createPlayer();
            if (this.bxK != null) {
                UM();
            } else {
                UN();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UM() throws RemoteException {
        Map<String, String> JQ;
        if (this.bxK != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.JP()) && (JQ = com.baidu.tbadk.coreExtra.model.f.JQ()) != null) {
                for (Map.Entry<String, String> entry : JQ.entrySet()) {
                    this.bxK.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bxK.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.brv() == 0) | this.bxU);
            this.bxK.setListener(new PlayerListener(this.mMainThreadHandler));
            this.bxK.openVideo(this.bxT.getUri(), new Surface(this.bxT.getSurfaceTexture()), this.bxT.getHost(), this.mPlayerReuseEnable);
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
        this.bxT = bVar;
        try {
            this.bxK = d.UH().createPlayer();
            if (this.bxK != null) {
                UM();
            } else {
                UN();
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

    private void UN() {
        d.UH().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.bxK = iQuickMediaPlayerService.createPlayer();
                    e.this.UM();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.UH().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO() {
        hx(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bxM = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bxL = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bxN = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.bxO = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0298g interfaceC0298g) {
        this.bxP = interfaceC0298g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.bxQ = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bxR = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bxS = hVar;
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
        if (this.bxK != null) {
            try {
                return this.bxK.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.bxK != null) {
            try {
                return this.bxK.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int UP() {
        if (this.bxK != null) {
            try {
                return this.bxK.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.bxK != null) {
            try {
                return this.bxK.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.bxK != null) {
            try {
                return this.bxK.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.bxK != null) {
            try {
                return this.bxK.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.bxK != null) {
            try {
                return this.bxK.getVideoHeight();
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
    public void hx(int i) {
        if (this.bxK != null) {
            try {
                this.bxK.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.bxK != null) {
            try {
                return this.bxK.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlayerReuse() {
        if (this.bxK != null) {
            try {
                return this.bxK.isPlayerReuse();
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
        if (this.bxK != null) {
            try {
                this.bxK.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.bxK != null) {
            try {
                this.bxK.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void c(SurfaceTexture surfaceTexture) {
        if (this.bxK != null) {
            try {
                this.bxK.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.bxK != null) {
            try {
                return this.bxK.isExistInRemote();
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
        this.bxU = z;
        try {
            this.bxK.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.bxK != null) {
            try {
                return this.bxK.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return ReportLevel.USER;
            }
        }
        return ReportLevel.USER;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void UK() {
        if (this.bxN != null) {
            this.bxN.a(this, ReportLevel.USER, -14399, -14399);
            TiebaStatic.log(new am("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Qe() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
