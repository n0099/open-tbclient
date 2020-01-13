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
/* loaded from: classes11.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b dIa;
    private IQuickMediaPlayer dQV;
    private g.a dQW;
    private g.f dQX;
    private g.c dQY;
    private g.e dQZ;
    private g.InterfaceC0582g dRa;
    private g.i dRb;
    private g.d dRc;
    private g.h dRd;
    private b dRe;
    private boolean mPlayerReuseEnable;
    private boolean dRf = false;
    private boolean dRg = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.aUg().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.aUg().b(e.this);
                e.this.a(e.this.dQV);
                e.this.dQV = null;
            } else if (message.what == 3) {
                e.this.b(e.this.dQV);
            } else if (message.what == 4) {
                e.this.c(e.this.dQV);
            } else if (message.what == 5) {
                e.this.nF(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.aUn();
            }
            return true;
        }
    };
    private Handler.Callback dRh = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.dQX != null) {
                    e.this.dQX.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.dQW != null) {
                    e.this.dQW.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.dIa != null) {
                        e.this.dIa.onError(e.this, dVar.what, dVar.jyf);
                    }
                    if (e.this.dQY != null) {
                        e.this.dQY.a(e.this, dVar.jye, dVar.what, dVar.jyf);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.dQZ != null) {
                    e.this.dQZ.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.dRa != null) {
                    e.this.dRa.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.dRb != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.dRb.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.dRc != null && (message.obj instanceof String)) {
                    e.this.dRc.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.dRd != null && (message.obj instanceof Long)) {
                e.this.dRd.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.aUf().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.dRh);

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
        this.dRe = bVar;
        try {
            this.dQV = d.aUg().createPlayer();
            if (this.dQV != null) {
                aUl();
            } else {
                aUm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUl() throws RemoteException {
        Map<String, String> aJF;
        if (this.dQV != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.aJE()) && (aJF = com.baidu.tbadk.coreExtra.model.f.aJF()) != null) {
                for (Map.Entry<String, String> entry : aJF.entrySet()) {
                    this.dQV.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.dQV.forceUseSystemMediaPlayer((CustomPlayerSwitch.getSwitchStatus() == 0) | this.dRf);
            this.dQV.setListener(new PlayerListener(this.mMainThreadHandler));
            this.dQV.openVideo(this.dRe.getUri(), new Surface(this.dRe.getSurfaceTexture()), this.dRe.getHost(), this.mPlayerReuseEnable);
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
        this.dRe = bVar;
        try {
            this.dQV = d.aUg().createPlayer();
            if (this.dQV != null) {
                aUl();
            } else {
                aUm();
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

    private void aUm() {
        d.aUg().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.dQV = iQuickMediaPlayerService.createPlayer();
                    e.this.aUl();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.aUg().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUn() {
        nF(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.dQX = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.dQW = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnErrorListener(g.b bVar) {
        this.dIa = bVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.dQY = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.dQZ = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0582g interfaceC0582g) {
        this.dRa = interfaceC0582g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.dRb = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.dRc = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.dRd = hVar;
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
        if (this.dQV != null) {
            try {
                return this.dQV.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.dQV != null) {
            try {
                return this.dQV.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int aUo() {
        if (this.dQV != null) {
            try {
                return this.dQV.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.dQV != null) {
            try {
                return this.dQV.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.dQV != null) {
            try {
                return this.dQV.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.dQV != null) {
            try {
                return this.dQV.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.dQV != null) {
            try {
                return this.dQV.getVideoHeight();
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
    public void nF(int i) {
        if (this.dQV != null) {
            try {
                this.dQV.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.dQV != null) {
            try {
                return this.dQV.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlayerReuse() {
        if (this.dQV != null) {
            try {
                return this.dQV.isPlayerReuse();
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
        if (this.dQV != null) {
            try {
                this.dQV.setVolume(f, f2);
                this.dRg = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean aUp() {
        return this.dRg;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.dQV != null) {
            try {
                this.dQV.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setSurface(SurfaceTexture surfaceTexture) {
        if (this.dQV != null) {
            try {
                this.dQV.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.dQV != null) {
            try {
                return this.dQV.isExistInRemote();
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
        this.dRf = z;
        try {
            this.dQV.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.dQV != null) {
            try {
                return this.dQV.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void aUj() {
        if (this.dQY != null) {
            this.dQY.a(this, -300, -14399, -14399);
            TiebaStatic.log(new an("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void aUq() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
