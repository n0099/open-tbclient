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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.g;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b bdd;
    private IQuickMediaPlayer bjF;
    private g.a bjG;
    private g.f bjH;
    private g.c bjI;
    private g.e bjJ;
    private g.InterfaceC0219g bjK;
    private g.i bjL;
    private g.d bjM;
    private g.h bjN;
    private b bjO;
    private boolean bjP = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.PB().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.PB().b(e.this);
                e.this.a(e.this.bjF);
                e.this.bjF = null;
            } else if (message.what == 3) {
                e.this.b(e.this.bjF);
            } else if (message.what == 4) {
                e.this.c(e.this.bjF);
            } else if (message.what == 5) {
                e.this.gn(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.PH();
            }
            return true;
        }
    };
    private Handler.Callback bjQ = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bjH != null) {
                    e.this.bjH.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bjG != null) {
                    e.this.bjG.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.bdd != null) {
                        e.this.bdd.onError(e.this, dVar.what, dVar.gie);
                    }
                    if (e.this.bjI != null) {
                        e.this.bjI.a(e.this, dVar.gic, dVar.what, dVar.gie);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.bjJ != null) {
                    e.this.bjJ.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bjK != null) {
                    e.this.bjK.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.bjL != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.bjL.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bjM != null && (message.obj instanceof String)) {
                    e.this.bjM.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bjN != null && (message.obj instanceof Long)) {
                e.this.bjN.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.PA().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.bjQ);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
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
        this.bjO = bVar;
        try {
            this.bjF = d.PB().createPlayer();
            if (this.bjF != null) {
                PF();
            } else {
                PG();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() throws RemoteException {
        Map<String, String> Fi;
        if (this.bjF != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.Fh()) && (Fi = com.baidu.tbadk.coreExtra.model.f.Fi()) != null) {
                for (Map.Entry<String, String> entry : Fi.entrySet()) {
                    this.bjF.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bjF.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bjN() == 0) | this.bjP);
            this.bjF.setListener(new PlayerListener(this.mMainThreadHandler));
            this.bjF.openVideo(this.bjO.getUri(), new Surface(this.bjO.getSurfaceTexture()), this.bjO.getHost());
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
        this.bjO = bVar;
        try {
            this.bjF = d.PB().createPlayer();
            if (this.bjF != null) {
                PF();
            } else {
                PG();
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

    private void PG() {
        d.PB().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.bjF = iQuickMediaPlayerService.createPlayer();
                    e.this.PF();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.PB().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PH() {
        gn(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bjH = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bjG = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bjI = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.bjJ = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0219g interfaceC0219g) {
        this.bjK = interfaceC0219g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.bjL = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bjM = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bjN = hVar;
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
        if (this.bjF != null) {
            try {
                return this.bjF.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.bjF != null) {
            try {
                return this.bjF.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int PI() {
        if (this.bjF != null) {
            try {
                return this.bjF.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.bjF != null) {
            try {
                return this.bjF.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.bjF != null) {
            try {
                return this.bjF.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.bjF != null) {
            try {
                return this.bjF.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.bjF != null) {
            try {
                return this.bjF.getVideoHeight();
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
    public void gn(int i) {
        if (this.bjF != null) {
            try {
                this.bjF.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.bjF != null) {
            try {
                return this.bjF.isPlaying();
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
        if (this.bjF != null) {
            try {
                this.bjF.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.bjF != null) {
            try {
                this.bjF.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.bjF != null) {
            try {
                return this.bjF.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public List<String> getMediaIDs() {
        if (this.bjF != null) {
            try {
                return this.bjF.getMediaIDs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.play.g
    public String getId() {
        if (this.bjF != null) {
            try {
                return this.bjF.getId();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.bjP = z;
        try {
            this.bjF.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.bjF != null) {
            try {
                if (this.bjF.isIjkPlayer()) {
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
    public void PE() {
        if (this.bjI != null) {
            this.bjI.a(this, -300, -14399, -14399);
            TiebaStatic.log(new an("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Lt() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
