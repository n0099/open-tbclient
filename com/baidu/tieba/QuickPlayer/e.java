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
    private g.b dMf;
    private IQuickMediaPlayer dVa;
    private g.a dVb;
    private g.f dVc;
    private g.c dVd;
    private g.e dVe;
    private g.InterfaceC0590g dVf;
    private g.i dVg;
    private g.d dVh;
    private g.h dVi;
    private b dVj;
    private boolean mPlayerReuseEnable;
    private boolean dVk = false;
    private boolean dVl = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.aWw().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.aWw().b(e.this);
                e.this.a(e.this.dVa);
                e.this.dVa = null;
            } else if (message.what == 3) {
                e.this.b(e.this.dVa);
            } else if (message.what == 4) {
                e.this.c(e.this.dVa);
            } else if (message.what == 5) {
                e.this.nW(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.aWD();
            }
            return true;
        }
    };
    private Handler.Callback dVm = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.dVc != null) {
                    e.this.dVc.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.dVb != null) {
                    e.this.dVb.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.dMf != null) {
                        e.this.dMf.onError(e.this, dVar.what, dVar.jza);
                    }
                    if (e.this.dVd != null) {
                        e.this.dVd.a(e.this, dVar.jyZ, dVar.what, dVar.jza);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.dVe != null) {
                    e.this.dVe.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.dVf != null) {
                    e.this.dVf.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.dVg != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.dVg.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.dVh != null && (message.obj instanceof String)) {
                    e.this.dVh.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.dVi != null && (message.obj instanceof Long)) {
                e.this.dVi.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.aWv().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.dVm);

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
        this.dVj = bVar;
        try {
            this.dVa = d.aWw().createPlayer();
            if (this.dVa != null) {
                aWB();
            } else {
                aWC();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWB() throws RemoteException {
        Map<String, String> aLZ;
        if (this.dVa != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.aLY()) && (aLZ = com.baidu.tbadk.coreExtra.model.f.aLZ()) != null) {
                for (Map.Entry<String, String> entry : aLZ.entrySet()) {
                    this.dVa.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.dVa.forceUseSystemMediaPlayer((CustomPlayerSwitch.getSwitchStatus() == 0) | this.dVk);
            this.dVa.setListener(new PlayerListener(this.mMainThreadHandler));
            this.dVa.openVideo(this.dVj.getUri(), new Surface(this.dVj.getSurfaceTexture()), this.dVj.getHost(), this.mPlayerReuseEnable);
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
        this.dVj = bVar;
        try {
            this.dVa = d.aWw().createPlayer();
            if (this.dVa != null) {
                aWB();
            } else {
                aWC();
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

    private void aWC() {
        d.aWw().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.dVa = iQuickMediaPlayerService.createPlayer();
                    e.this.aWB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.aWw().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWD() {
        nW(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.dVc = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.dVb = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnErrorListener(g.b bVar) {
        this.dMf = bVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.dVd = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.dVe = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0590g interfaceC0590g) {
        this.dVf = interfaceC0590g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.dVg = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.dVh = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.dVi = hVar;
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
        if (this.dVa != null) {
            try {
                return this.dVa.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.dVa != null) {
            try {
                return this.dVa.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int aWE() {
        if (this.dVa != null) {
            try {
                return this.dVa.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.dVa != null) {
            try {
                return this.dVa.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.dVa != null) {
            try {
                return this.dVa.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.dVa != null) {
            try {
                return this.dVa.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.dVa != null) {
            try {
                return this.dVa.getVideoHeight();
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
    public void nW(int i) {
        if (this.dVa != null) {
            try {
                this.dVa.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.dVa != null) {
            try {
                return this.dVa.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlayerReuse() {
        if (this.dVa != null) {
            try {
                return this.dVa.isPlayerReuse();
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
        if (this.dVa != null) {
            try {
                this.dVa.setVolume(f, f2);
                this.dVl = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean aWF() {
        return this.dVl;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.dVa != null) {
            try {
                this.dVa.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setSurface(SurfaceTexture surfaceTexture) {
        if (this.dVa != null) {
            try {
                this.dVa.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.dVa != null) {
            try {
                return this.dVa.isExistInRemote();
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
        this.dVk = z;
        try {
            this.dVa.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.dVa != null) {
            try {
                return this.dVa.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void aWz() {
        if (this.dVd != null) {
            this.dVd.a(this, -300, -14399, -14399);
            TiebaStatic.log(new an("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void aWG() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
