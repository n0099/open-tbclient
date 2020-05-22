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
    private g.b eBk;
    private IQuickMediaPlayer eKk;
    private g.a eKl;
    private g.f eKm;
    private g.c eKn;
    private g.e eKo;
    private g.InterfaceC0704g eKp;
    private g.i eKq;
    private g.d eKr;
    private g.h eKs;
    private b eKt;
    private boolean eKu = false;
    private boolean eKv = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.bkU().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.bkU().b(e.this);
                e.this.a(e.this.eKk);
                e.this.eKk = null;
            } else if (message.what == 3) {
                e.this.b(e.this.eKk);
            } else if (message.what == 4) {
                e.this.c(e.this.eKk);
            } else if (message.what == 5) {
                e.this.oS(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.bla();
            }
            return true;
        }
    };
    private Handler.Callback eKw = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.eKm != null) {
                    e.this.eKm.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.eKl != null) {
                    e.this.eKl.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.eBk != null) {
                        e.this.eBk.onError(e.this, dVar.what, dVar.kCR);
                    }
                    if (e.this.eKn != null) {
                        e.this.eKn.a(e.this, dVar.kCQ, dVar.what, dVar.kCR);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.eKo != null) {
                    e.this.eKo.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.eKp != null) {
                    e.this.eKp.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.eKq != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.eKq.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.eKr != null && (message.obj instanceof String)) {
                    e.this.eKr.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.eKs != null && (message.obj instanceof Long)) {
                e.this.eKs.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.bkT().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.eKw);

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
        this.eKt = bVar;
        try {
            this.eKk = d.bkU().createPlayer();
            if (this.eKk != null) {
                bkY();
            } else {
                bkZ();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() throws RemoteException {
        Map<String, String> baL;
        if (this.eKk != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.baK()) && (baL = com.baidu.tbadk.coreExtra.model.f.baL()) != null) {
                for (Map.Entry<String, String> entry : baL.entrySet()) {
                    this.eKk.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.eKk.forceUseSystemMediaPlayer((CustomPlayerSwitch.getSwitchStatus() == 0) | this.eKu);
            this.eKk.setListener(new PlayerListener(this.mMainThreadHandler));
            this.eKk.openVideo(this.eKt.getUri(), new Surface(this.eKt.getSurfaceTexture()), this.eKt.getHost());
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
        this.eKt = bVar;
        try {
            this.eKk = d.bkU().createPlayer();
            if (this.eKk != null) {
                bkY();
            } else {
                bkZ();
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

    private void bkZ() {
        d.bkU().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.eKk = iQuickMediaPlayerService.createPlayer();
                    e.this.bkY();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.bkU().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bla() {
        oS(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.eKm = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.eKl = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.eKn = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.eKo = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0704g interfaceC0704g) {
        this.eKp = interfaceC0704g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.eKq = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.eKr = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.eKs = hVar;
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
        if (this.eKk != null) {
            try {
                return this.eKk.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.eKk != null) {
            try {
                return this.eKk.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int blb() {
        if (this.eKk != null) {
            try {
                return this.eKk.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.eKk != null) {
            try {
                return this.eKk.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.eKk != null) {
            try {
                return this.eKk.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.eKk != null) {
            try {
                return this.eKk.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.eKk != null) {
            try {
                return this.eKk.getVideoHeight();
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
    public void oS(int i) {
        if (this.eKk != null) {
            try {
                this.eKk.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.eKk != null) {
            try {
                return this.eKk.isPlaying();
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
        if (this.eKk != null) {
            try {
                this.eKk.setVolume(f, f2);
                this.eKv = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean blc() {
        return this.eKv;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.eKk != null) {
            try {
                this.eKk.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void d(SurfaceTexture surfaceTexture) {
        if (this.eKk != null) {
            try {
                this.eKk.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.eKk != null) {
            try {
                return this.eKk.isExistInRemote();
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
        this.eKu = z;
        try {
            this.eKk.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.eKk != null) {
            try {
                return this.eKk.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void bkX() {
        if (this.eKn != null) {
            this.eKn.a(this, -300, -14399, -14399);
            TiebaStatic.log(new an("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void bld() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
