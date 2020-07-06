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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.g;
import java.util.List;
import java.util.Map;
/* loaded from: classes13.dex */
public class e implements d.b, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private g.b eLe;
    private IQuickMediaPlayer eUH;
    private g.a eUI;
    private g.f eUJ;
    private g.c eUK;
    private g.e eUL;
    private g.InterfaceC0721g eUM;
    private g.i eUN;
    private g.d eUO;
    private g.h eUP;
    private b eUQ;
    private boolean eUR = false;
    private boolean eUS = true;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.bnw().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.bnw().b(e.this);
                e.this.a(e.this.eUH);
                e.this.eUH = null;
            } else if (message.what == 3) {
                e.this.b(e.this.eUH);
            } else if (message.what == 4) {
                e.this.c(e.this.eUH);
            } else if (message.what == 5) {
                e.this.pt(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.bnC();
            }
            return true;
        }
    };
    private Handler.Callback eUT = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.eUJ != null) {
                    e.this.eUJ.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.eUI != null) {
                    e.this.eUI.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.eLe != null) {
                        e.this.eLe.onError(e.this, dVar.what, dVar.kXV);
                    }
                    if (e.this.eUK != null) {
                        e.this.eUK.a(e.this, dVar.kXU, dVar.what, dVar.kXV);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.eUL != null) {
                    e.this.eUL.onInfo(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.eUM != null) {
                    e.this.eUM.b(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.eUN != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.eUN.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.eUO != null && (message.obj instanceof String)) {
                    e.this.eUO.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.eUP != null && (message.obj instanceof Long)) {
                e.this.eUP.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.bnv().getLooper(), this.mHandlerCallback);
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper(), this.eUT);

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
        this.eUQ = bVar;
        try {
            this.eUH = d.bnw().createPlayer();
            if (this.eUH != null) {
                bnA();
            } else {
                bnB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnA() throws RemoteException {
        Map<String, String> bcO;
        if (this.eUH != null) {
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.bcN()) && (bcO = com.baidu.tbadk.coreExtra.model.f.bcO()) != null) {
                for (Map.Entry<String, String> entry : bcO.entrySet()) {
                    this.eUH.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.eUH.forceUseSystemMediaPlayer((CustomPlayerSwitch.getSwitchStatus() == 0) | this.eUR);
            this.eUH.setListener(new PlayerListener(this.mMainThreadHandler));
            this.eUH.openVideo(this.eUQ.getUri(), new Surface(this.eUQ.getSurfaceTexture()), this.eUQ.getHost());
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
        this.eUQ = bVar;
        try {
            this.eUH = d.bnw().createPlayer();
            if (this.eUH != null) {
                bnA();
            } else {
                bnB();
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

    private void bnB() {
        d.bnw().a(new d.a() { // from class: com.baidu.tieba.QuickPlayer.e.2
            @Override // com.baidu.tieba.QuickPlayer.d.a
            public void a(IQuickMediaPlayerService iQuickMediaPlayerService) {
                try {
                    e.this.eUH = iQuickMediaPlayerService.createPlayer();
                    e.this.bnA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.bnw().a((d.a) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnC() {
        pt(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.eUJ = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.eUI = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.eUK = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.eUL = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0721g interfaceC0721g) {
        this.eUM = interfaceC0721g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.eUN = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.eUO = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.eUP = hVar;
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
        if (this.eUH != null) {
            try {
                return this.eUH.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.eUH != null) {
            try {
                return this.eUH.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int bnD() {
        if (this.eUH != null) {
            try {
                return this.eUH.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.eUH != null) {
            try {
                return this.eUH.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.eUH != null) {
            try {
                return this.eUH.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.eUH != null) {
            try {
                return this.eUH.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.eUH != null) {
            try {
                return this.eUH.getVideoHeight();
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
    public void pt(int i) {
        if (this.eUH != null) {
            try {
                this.eUH.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.eUH != null) {
            try {
                return this.eUH.isPlaying();
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
        if (this.eUH != null) {
            try {
                this.eUH.setVolume(f, f2);
                this.eUS = f == 0.0f && f2 == 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean bnE() {
        return this.eUS;
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.eUH != null) {
            try {
                this.eUH.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void d(SurfaceTexture surfaceTexture) {
        if (this.eUH != null) {
            try {
                this.eUH.setSurface(new Surface(surfaceTexture));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.eUH != null) {
            try {
                return this.eUH.isExistInRemote();
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
        this.eUR = z;
        try {
            this.eUH.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.eUH != null) {
            try {
                return this.eUH.isIjkPlayer() ? -200 : -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.b
    public void bnz() {
        if (this.eUK != null) {
            this.eUK.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ao("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void bnF() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeCallbacksAndMessages(null);
        }
    }
}
