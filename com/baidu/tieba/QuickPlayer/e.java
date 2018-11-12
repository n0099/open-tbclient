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
    private g.b bly;
    private IQuickMediaPlayer buk;
    private g.a bul;
    private g.f bum;
    private g.c bun;
    private g.e buo;
    private g.InterfaceC0287g bup;
    private g.i buq;
    private g.d bur;
    private g.h bus;
    private b but;
    private boolean mPlayerReuseEnable;
    private boolean buu = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Tz().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Tz().b(e.this);
                e.this.a(e.this.buk);
                e.this.buk = null;
            } else if (message.what == 3) {
                e.this.b(e.this.buk);
            } else if (message.what == 4) {
                e.this.c(e.this.buk);
            } else if (message.what == 5) {
                e.this.hi(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.TG();
            }
            return true;
        }
    };
    private Handler.Callback buv = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bum != null) {
                    e.this.bum.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bul != null) {
                    e.this.bul.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.bly != null) {
                        e.this.bly.onError(e.this, dVar.what, dVar.gyy);
                    }
                    if (e.this.bun != null) {
                        e.this.bun.a(e.this, dVar.gyx, dVar.what, dVar.gyy);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.buo != null) {
                    e.this.buo.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bup != null) {
                    e.this.bup.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.buq != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.buq.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bur != null && (message.obj instanceof String)) {
                    e.this.bur.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bus != null && (message.obj instanceof Long)) {
                e.this.bus.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Ty().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.buv);

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
        this.but = bVar;
        try {
            this.buk = d.Tz().createPlayer();
            if (this.buk != null) {
                TE();
            } else {
                TF();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TE() throws RemoteException {
        Map<String, String> IL;
        if (this.buk != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.IK()) && (IL = com.baidu.tbadk.coreExtra.model.f.IL()) != null) {
                for (Map.Entry<String, String> entry : IL.entrySet()) {
                    this.buk.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.buk.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.boR() == 0) | this.buu);
            this.buk.setListener(new PlayerListener(this.mMainThreadHandler));
            this.buk.openVideo(this.but.getUri(), new Surface(this.but.getSurfaceTexture()), this.but.getHost(), this.mPlayerReuseEnable);
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
        this.but = bVar;
        try {
            this.buk = d.Tz().createPlayer();
            if (this.buk != null) {
                TE();
            } else {
                TF();
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

    private void TF() {
        d.Tz().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.buk = iQuickMediaPlayerService.createPlayer();
                    e.this.TE();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.Tz().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TG() {
        hi(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bum = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bul = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bun = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.buo = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0287g interfaceC0287g) {
        this.bup = interfaceC0287g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.buq = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bur = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bus = hVar;
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
        if (this.buk != null) {
            try {
                return this.buk.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.buk != null) {
            try {
                return this.buk.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int TH() {
        if (this.buk != null) {
            try {
                return this.buk.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.buk != null) {
            try {
                return this.buk.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.buk != null) {
            try {
                return this.buk.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.buk != null) {
            try {
                return this.buk.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.buk != null) {
            try {
                return this.buk.getVideoHeight();
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
    public void hi(int i) {
        if (this.buk != null) {
            try {
                this.buk.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.buk != null) {
            try {
                return this.buk.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlayerReuse() {
        if (this.buk != null) {
            try {
                return this.buk.isPlayerReuse();
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
        if (this.buk != null) {
            try {
                this.buk.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.buk != null) {
            try {
                this.buk.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void c(SurfaceTexture surfaceTexture) {
        if (this.buk != null) {
            try {
                this.buk.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.buk != null) {
            try {
                return this.buk.isExistInRemote();
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
        this.buu = z;
        try {
            this.buk.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.buk != null) {
            try {
                return this.buk.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return ReportLevel.USER;
            }
        }
        return ReportLevel.USER;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void TC() {
        if (this.bun != null) {
            this.bun.a(this, ReportLevel.USER, -14399, -14399);
            TiebaStatic.log(new am("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void OW() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
