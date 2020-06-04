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
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.g;
import java.util.List;
import java.util.Map;
/* loaded from: classes13.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b eBv;
    private g.InterfaceC0705g eKA;
    private g.i eKB;
    private g.d eKC;
    private g.h eKD;
    private b eKE;
    private IQuickMediaPlayer eKv;
    private g.a eKw;
    private g.f eKx;
    private g.c eKy;
    private g.e eKz;
    private boolean eKF = false;
    private boolean eKG = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.bkW().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.bkW().b(e.this);
                e.this.a(e.this.eKv);
                e.this.eKv = null;
            } else if (message.what == 3) {
                e.this.b(e.this.eKv);
            } else if (message.what == 4) {
                e.this.c(e.this.eKv);
            } else if (message.what == 5) {
                e.this.oU(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.blc();
            }
            return true;
        }
    };
    private Handler.Callback eKH = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.eKx != null) {
                    e.this.eKx.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.eKw != null) {
                    e.this.eKw.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.eBv != null) {
                        e.this.eBv.onError(e.this, dVar.what, dVar.kDZ);
                    }
                    if (e.this.eKy != null) {
                        e.this.eKy.a(e.this, dVar.kDY, dVar.what, dVar.kDZ);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.eKz != null) {
                    e.this.eKz.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.eKA != null) {
                    e.this.eKA.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.eKB != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.eKB.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.eKC != null && (message.obj instanceof String)) {
                    e.this.eKC.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.eKD != null && (message.obj instanceof Long)) {
                e.this.eKD.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.bkV().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.eKH);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        if (surfaceTexture != null) {
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
        this.eKE = bVar;
        try {
            this.eKv = d.bkW().createPlayer();
            if (this.eKv != null) {
                bla();
            } else {
                blb();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bla() throws RemoteException {
        Map<String, String> baM;
        if (this.eKv != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.baL()) && (baM = com.baidu.tbadk.coreExtra.model.f.baM()) != null) {
                for (Map.Entry<String, String> entry : baM.entrySet()) {
                    this.eKv.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.eKv.forceUseSystemMediaPlayer((CustomPlayerSwitch.getSwitchStatus() == 0) | this.eKF);
            this.eKv.setListener(new PlayerListener(this.mMainThreadHandler));
            this.eKv.openVideo(this.eKE.getUri(), new Surface(this.eKE.getSurfaceTexture()), this.eKE.getHost());
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
        this.eKE = bVar;
        try {
            this.eKv = d.bkW().createPlayer();
            if (this.eKv != null) {
                bla();
            } else {
                blb();
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

    private void blb() {
        d.bkW().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.eKv = iQuickMediaPlayerService.createPlayer();
                    e.this.bla();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.bkW().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blc() {
        oU(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.eKx = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.eKw = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.eKy = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.eKz = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0705g interfaceC0705g) {
        this.eKA = interfaceC0705g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.eKB = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.eKC = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.eKD = hVar;
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
                if (this.mMainThreadHandler != null) {
                    Message obtainMessage = this.mMainThreadHandler.obtainMessage(8);
                    obtainMessage.obj = new com.baidu.tieba.play.b.d(getPlayerType(), -24399, -24399);
                    this.mMainThreadHandler.sendMessage(obtainMessage);
                }
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
        if (this.eKv != null) {
            try {
                return this.eKv.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.eKv != null) {
            try {
                return this.eKv.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int bld() {
        if (this.eKv != null) {
            try {
                return this.eKv.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.eKv != null) {
            try {
                return this.eKv.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.eKv != null) {
            try {
                return this.eKv.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.eKv != null) {
            try {
                return this.eKv.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.eKv != null) {
            try {
                return this.eKv.getVideoHeight();
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
    public void oU(int i) {
        if (this.eKv != null) {
            try {
                this.eKv.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.eKv != null) {
            try {
                return this.eKv.isPlaying();
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
        if (this.eKv != null) {
            try {
                this.eKv.setVolume(f, f2);
                this.eKG = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean ble() {
        return this.eKG;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.eKv != null) {
            try {
                this.eKv.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void d(SurfaceTexture surfaceTexture) {
        if (this.eKv != null) {
            try {
                this.eKv.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.eKv != null) {
            try {
                return this.eKv.isExistInRemote();
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
        this.eKF = z;
        try {
            this.eKv.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.eKv != null) {
            try {
                return this.eKv.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void bkZ() {
        if (this.eKy != null) {
            this.eKy.a(this, -300, -14399, -14399);
            TiebaStatic.log(new an("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void blf() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
