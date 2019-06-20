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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.t.s;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.g;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b cIy;
    private IQuickMediaPlayer cRS;
    private g.a cRT;
    private g.f cRU;
    private g.c cRV;
    private g.e cRW;
    private g.InterfaceC0388g cRX;
    private g.i cRY;
    private g.d cRZ;
    private g.h cSa;
    private b cSb;
    private boolean mPlayerReuseEnable;
    private boolean cSc = false;
    private boolean cSd = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.aAh().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.aAh().b(e.this);
                e.this.a(e.this.cRS);
                e.this.cRS = null;
            } else if (message.what == 3) {
                e.this.b(e.this.cRS);
            } else if (message.what == 4) {
                e.this.c(e.this.cRS);
            } else if (message.what == 5) {
                e.this.mb(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.aAo();
            }
            return true;
        }
    };
    private Handler.Callback cSe = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.cRU != null) {
                    e.this.cRU.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.cRT != null) {
                    e.this.cRT.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.cIy != null) {
                        e.this.cIy.onError(e.this, dVar.what, dVar.itc);
                    }
                    if (e.this.cRV != null) {
                        e.this.cRV.a(e.this, dVar.itb, dVar.what, dVar.itc);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.cRW != null) {
                    e.this.cRW.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.cRX != null) {
                    e.this.cRX.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.cRY != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.cRY.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.cRZ != null && (message.obj instanceof String)) {
                    e.this.cRZ.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.cSa != null && (message.obj instanceof Long)) {
                e.this.cSa.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.aAg().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.cSe);

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
        this.cSb = bVar;
        try {
            this.cRS = d.aAh().createPlayer();
            if (this.cRS != null) {
                aAm();
            } else {
                aAn();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAm() throws RemoteException {
        Map<String, String> aoA;
        if (this.cRS != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.aoz()) && (aoA = com.baidu.tbadk.coreExtra.model.f.aoA()) != null) {
                for (Map.Entry<String, String> entry : aoA.entrySet()) {
                    this.cRS.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.cRS.forceUseSystemMediaPlayer((s.auG() == 0) | this.cSc);
            this.cRS.setListener(new PlayerListener(this.mMainThreadHandler));
            this.cRS.openVideo(this.cSb.getUri(), new Surface(this.cSb.getSurfaceTexture()), this.cSb.getHost(), this.mPlayerReuseEnable);
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
        this.cSb = bVar;
        try {
            this.cRS = d.aAh().createPlayer();
            if (this.cRS != null) {
                aAm();
            } else {
                aAn();
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

    private void aAn() {
        d.aAh().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.cRS = iQuickMediaPlayerService.createPlayer();
                    e.this.aAm();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.aAh().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAo() {
        mb(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.cRU = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.cRT = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnErrorListener(g.b bVar) {
        this.cIy = bVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.cRV = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.cRW = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0388g interfaceC0388g) {
        this.cRX = interfaceC0388g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.cRY = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.cRZ = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.cSa = hVar;
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
        if (this.cRS != null) {
            try {
                return this.cRS.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.cRS != null) {
            try {
                return this.cRS.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int aAp() {
        if (this.cRS != null) {
            try {
                return this.cRS.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.cRS != null) {
            try {
                return this.cRS.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.cRS != null) {
            try {
                return this.cRS.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.cRS != null) {
            try {
                return this.cRS.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.cRS != null) {
            try {
                return this.cRS.getVideoHeight();
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
    public void mb(int i) {
        if (this.cRS != null) {
            try {
                this.cRS.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.cRS != null) {
            try {
                return this.cRS.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlayerReuse() {
        if (this.cRS != null) {
            try {
                return this.cRS.isPlayerReuse();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isNewPlayer() {
        if (this.cRS != null) {
            try {
                return this.cRS.isNewPlayer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
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
        if (this.cRS != null) {
            try {
                this.cRS.setVolume(f, f2);
                this.cSd = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean aAq() {
        return this.cSd;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.cRS != null) {
            try {
                this.cRS.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setSurface(SurfaceTexture surfaceTexture) {
        if (this.cRS != null) {
            try {
                this.cRS.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.cRS != null) {
            try {
                return this.cRS.isExistInRemote();
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
        this.cSc = z;
        try {
            this.cRS.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.cRS != null) {
            try {
                if (this.cRS.isIjkPlayer()) {
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
    public void aAk() {
        if (this.cRV != null) {
            this.cRV.a(this, -300, -14399, -14399);
            TiebaStatic.log(new am("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void avm() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
