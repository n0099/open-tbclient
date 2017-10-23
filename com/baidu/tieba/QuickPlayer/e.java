package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.g;
import java.util.Map;
/* loaded from: classes.dex */
public class e implements d.a, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private IQuickMediaPlayer aVP;
    private g.a aVQ;
    private g.f aVR;
    private g.b aVS;
    private g.c aVT;
    private g.d aVU;
    private g.InterfaceC0121g aVV;
    private g.e aVW;
    private b aVY;
    private Context mContext;
    private boolean aVZ = false;
    private Handler.Callback aWa = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Ks().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Ks().b(e.this);
                e.this.a(e.this.aVP);
                e.this.aVP = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aVP);
            } else if (message.what == 4) {
                e.this.c(e.this.aVP);
            } else if (message.what == 5) {
                e.this.ga(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.Kv();
            }
            return true;
        }
    };
    private Handler.Callback aWb = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aVR != null) {
                    e.this.aVR.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aVQ != null) {
                    e.this.aVQ.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.c)) {
                    com.baidu.tieba.play.b.c cVar = (com.baidu.tieba.play.b.c) message.obj;
                    if (e.this.aVS != null) {
                        e.this.aVS.onError(e.this, cVar.what, cVar.fyf);
                    }
                    if (e.this.aVT != null) {
                        e.this.aVT.a(e.this, cVar.fye, cVar.what, cVar.fyf);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.aVU != null) {
                    e.this.aVU.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 11) {
                if (e.this.aVW != null) {
                    e.this.aVW.onReleaseFinished();
                }
            } else if (message.what == 12 && e.this.aVV != null) {
                e.this.aVV.a(e.this);
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Kr().getLooper(), this.aWa);
    private Handler aVX = new Handler(Looper.getMainLooper(), this.aWb);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.ha(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.aVY = bVar;
        try {
            this.aVP = d.Ks().createPlayer();
            this.aVP.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bdQ() == 0) | this.aVZ);
            this.aVP.setListener(new PlayerListener(this.aVX));
            this.aVP.openVideo(this.aVY.getUri(), new Surface(this.aVY.getSurfaceTexture()), this.aVY.getHost());
        } catch (Exception e) {
            e.printStackTrace();
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
        this.aVY = bVar;
        try {
            this.aVP = d.Ks().createPlayer();
            this.aVP.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bdQ() == 0) | this.aVZ);
            this.aVP.setListener(new PlayerListener(this.aVX));
            this.aVP.openVideo(this.aVY.getUri(), new Surface(this.aVY.getSurfaceTexture()), this.aVY.getHost());
            if (i == 3) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(7), 1000L);
            } else if (i == 2) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4), 1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv() {
        ga(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.aVR = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.aVQ = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.aVT = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.aVU = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.aVW = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0121g interfaceC0121g) {
        this.aVV = interfaceC0121g;
    }

    @Override // com.baidu.tieba.play.g
    public void start() {
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
        if (this.aVP != null) {
            try {
                return this.aVP.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.aVP != null) {
            try {
                return this.aVP.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.aVP != null) {
            try {
                return this.aVP.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.aVP != null) {
            try {
                return this.aVP.getVideoHeight();
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
    public void ga(int i) {
        if (this.aVP != null) {
            try {
                this.aVP.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.aVP != null) {
            try {
                return this.aVP.isPlaying();
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
        bVar.b(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(10);
        obtainMessage.obj = bVar;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // com.baidu.tieba.play.g
    public void setVolume(float f, float f2) {
        if (this.aVP != null) {
            try {
                this.aVP.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.aVP != null) {
            try {
                this.aVP.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.aVP != null) {
            try {
                return this.aVP.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.aVZ = z;
        try {
            this.aVP.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.aVP != null) {
            try {
                if (this.aVP.isIjkPlayer()) {
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

    @Override // com.baidu.tieba.QuickPlayer.d.a
    public void Ku() {
        if (this.aVT != null) {
            this.aVT.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void GL() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aVX != null) {
            this.aVX.removeCallbacksAndMessages(null);
        }
    }
}
