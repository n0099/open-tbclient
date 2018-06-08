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
/* loaded from: classes2.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b bhA;
    private g.c bhB;
    private g.e bhC;
    private g.InterfaceC0218g bhD;
    private g.i bhE;
    private g.d bhF;
    private g.h bhG;
    private b bhH;
    private IQuickMediaPlayer bhx;
    private g.a bhy;
    private g.f bhz;
    private Context mContext;
    private boolean bhI = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.OY().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.OY().b(e.this);
                e.this.a(e.this.bhx);
                e.this.bhx = null;
            } else if (message.what == 3) {
                e.this.b(e.this.bhx);
            } else if (message.what == 4) {
                e.this.c(e.this.bhx);
            } else if (message.what == 5) {
                e.this.gh(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.Pe();
            }
            return true;
        }
    };
    private Handler.Callback bhJ = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.bhz != null) {
                    e.this.bhz.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.bhy != null) {
                    e.this.bhy.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.bhA != null) {
                        e.this.bhA.onError(e.this, dVar.what, dVar.gdC);
                    }
                    if (e.this.bhB != null) {
                        e.this.bhB.a(e.this, dVar.gdB, dVar.what, dVar.gdC);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.bhC != null) {
                    e.this.bhC.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.bhD != null) {
                    e.this.bhD.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.bhE != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.bhE.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.bhF != null && (message.obj instanceof String)) {
                    e.this.bhF.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.bhG != null && (message.obj instanceof Long)) {
                e.this.bhG.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.OX().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.bhJ);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
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
        this.bhH = bVar;
        try {
            this.bhx = d.OY().createPlayer();
            if (this.bhx != null) {
                Pc();
            } else {
                Pd();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc() throws RemoteException {
        Map<String, String> EU;
        if (this.bhx != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.ET()) && (EU = com.baidu.tbadk.coreExtra.model.f.EU()) != null) {
                for (Map.Entry<String, String> entry : EU.entrySet()) {
                    this.bhx.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.bhx.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bkP() == 0) | this.bhI);
            this.bhx.setListener(new PlayerListener(this.mMainThreadHandler));
            this.bhx.openVideo(this.bhH.getUri(), new Surface(this.bhH.getSurfaceTexture()), this.bhH.getHost());
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
        this.bhH = bVar;
        try {
            this.bhx = d.OY().createPlayer();
            if (this.bhx != null) {
                Pc();
            } else {
                Pd();
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

    private void Pd() {
        d.OY().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.bhx = iQuickMediaPlayerService.createPlayer();
                    e.this.Pc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.OY().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pe() {
        gh(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.bhz = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.bhy = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.bhB = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.bhC = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0218g interfaceC0218g) {
        this.bhD = interfaceC0218g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.bhE = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.bhF = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.bhG = hVar;
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
        if (this.bhx != null) {
            try {
                return this.bhx.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.bhx != null) {
            try {
                return this.bhx.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int Pf() {
        if (this.bhx != null) {
            try {
                return this.bhx.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.bhx != null) {
            try {
                return this.bhx.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.bhx != null) {
            try {
                return this.bhx.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.bhx != null) {
            try {
                return this.bhx.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.bhx != null) {
            try {
                return this.bhx.getVideoHeight();
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
    public void gh(int i) {
        if (this.bhx != null) {
            try {
                this.bhx.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.bhx != null) {
            try {
                return this.bhx.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i) {
        this.mContext = context;
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
        if (this.bhx != null) {
            try {
                this.bhx.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.bhx != null) {
            try {
                this.bhx.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.bhx != null) {
            try {
                return this.bhx.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public List<String> getMediaIDs() {
        if (this.bhx != null) {
            try {
                return this.bhx.getMediaIDs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.play.g
    public String getId() {
        if (this.bhx != null) {
            try {
                return this.bhx.getId();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.bhI = z;
        try {
            this.bhx.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.bhx != null) {
            try {
                if (this.bhx.isIjkPlayer()) {
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
    public void Pb() {
        if (this.bhB != null) {
            this.bhB.a(this, -300, -14399, -14399);
            TiebaStatic.log(new am("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Lg() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
