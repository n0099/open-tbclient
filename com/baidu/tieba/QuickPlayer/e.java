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
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.g;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b cAp;
    private IQuickMediaPlayer cJH;
    private g.a cJI;
    private g.f cJJ;
    private g.c cJK;
    private g.e cJL;
    private g.InterfaceC0295g cJM;
    private g.i cJN;
    private g.d cJO;
    private g.h cJP;
    private b cJQ;
    private boolean mPlayerReuseEnable;
    private boolean cJR = false;
    private boolean cJS = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.avd().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.avd().b(e.this);
                e.this.a(e.this.cJH);
                e.this.cJH = null;
            } else if (message.what == 3) {
                e.this.b(e.this.cJH);
            } else if (message.what == 4) {
                e.this.c(e.this.cJH);
            } else if (message.what == 5) {
                e.this.ln(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.avk();
            }
            return true;
        }
    };
    private Handler.Callback cJT = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.cJJ != null) {
                    e.this.cJJ.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.cJI != null) {
                    e.this.cJI.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.cAp != null) {
                        e.this.cAp.onError(e.this, dVar.what, dVar.iaL);
                    }
                    if (e.this.cJK != null) {
                        e.this.cJK.a(e.this, dVar.iaK, dVar.what, dVar.iaL);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.cJL != null) {
                    e.this.cJL.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.cJM != null) {
                    e.this.cJM.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.cJN != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.cJN.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.cJO != null && (message.obj instanceof String)) {
                    e.this.cJO.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.cJP != null && (message.obj instanceof Long)) {
                e.this.cJP.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.avc().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.cJT);

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
        this.cJQ = bVar;
        try {
            this.cJH = d.avd().createPlayer();
            if (this.cJH != null) {
                avi();
            } else {
                avj();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avi() throws RemoteException {
        Map<String, String> ajD;
        if (this.cJH != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.ajC()) && (ajD = com.baidu.tbadk.coreExtra.model.f.ajD()) != null) {
                for (Map.Entry<String, String> entry : ajD.entrySet()) {
                    this.cJH.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.cJH.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bSA() == 0) | this.cJR);
            this.cJH.setListener(new PlayerListener(this.mMainThreadHandler));
            this.cJH.openVideo(this.cJQ.getUri(), new Surface(this.cJQ.getSurfaceTexture()), this.cJQ.getHost(), this.mPlayerReuseEnable);
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
        this.cJQ = bVar;
        try {
            this.cJH = d.avd().createPlayer();
            if (this.cJH != null) {
                avi();
            } else {
                avj();
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

    private void avj() {
        d.avd().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.cJH = iQuickMediaPlayerService.createPlayer();
                    e.this.avi();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.avd().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avk() {
        ln(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.cJJ = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.cJI = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.cJK = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.cJL = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0295g interfaceC0295g) {
        this.cJM = interfaceC0295g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.cJN = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.cJO = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.cJP = hVar;
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
        if (this.cJH != null) {
            try {
                return this.cJH.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.cJH != null) {
            try {
                return this.cJH.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int avl() {
        if (this.cJH != null) {
            try {
                return this.cJH.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.cJH != null) {
            try {
                return this.cJH.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.cJH != null) {
            try {
                return this.cJH.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.cJH != null) {
            try {
                return this.cJH.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.cJH != null) {
            try {
                return this.cJH.getVideoHeight();
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
    public void ln(int i) {
        if (this.cJH != null) {
            try {
                this.cJH.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.cJH != null) {
            try {
                return this.cJH.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlayerReuse() {
        if (this.cJH != null) {
            try {
                return this.cJH.isPlayerReuse();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public boolean isNewPlayer() {
        if (this.cJH != null) {
            try {
                return this.cJH.isNewPlayer();
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
        if (this.cJH != null) {
            try {
                this.cJH.setVolume(f, f2);
                this.cJS = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean avm() {
        return this.cJS;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.cJH != null) {
            try {
                this.cJH.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void c(SurfaceTexture surfaceTexture) {
        if (this.cJH != null) {
            try {
                this.cJH.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.cJH != null) {
            try {
                return this.cJH.isExistInRemote();
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
        this.cJR = z;
        try {
            this.cJH.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.cJH != null) {
            try {
                if (this.cJH.isIjkPlayer()) {
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
    public void avg() {
        if (this.cJK != null) {
            this.cJK.a(this, -300, -14399, -14399);
            TiebaStatic.log(new am("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void aql() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
