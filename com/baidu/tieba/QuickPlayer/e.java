package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.f;
import java.util.Map;
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.play.f {
    private static final String TAG = e.class.getSimpleName();
    private f.d aTA;
    private f.b aTB;
    private f.c aTC;
    private b aTE;
    private IQuickMediaPlayer aTy;
    private f.a aTz;
    private Context mContext;
    private Handler.Callback aTF = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                e.this.a(e.this.aTy);
                e.this.aTy = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aTy);
            } else if (message.what == 4) {
                e.this.c(e.this.aTy);
            } else if (message.what == 5) {
                e.this.fK(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.JU();
            }
            return true;
        }
    };
    private Handler.Callback aTG = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aTA != null) {
                    e.this.aTA.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aTz != null) {
                    e.this.aTz.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (e.this.aTB == null || !e.this.aTB.onError(e.this, message.arg1, message.arg2)) {
                }
            } else if (message.what == 9 && e.this.aTC != null) {
                e.this.aTC.a(e.this, message.arg1, message.arg2);
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.JR().getLooper(), this.aTF);
    private Handler aTD = new Handler(Looper.getMainLooper(), this.aTG);

    @Override // com.baidu.tieba.play.f
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.gZ(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.aTE = bVar;
        try {
            this.aTy = d.JS().createPlayer();
            this.aTy.forceUseSystemMediaPlayer(CustomPlayerSwitchStatic.bfo() == 0);
            this.aTy.setListener(new PlayerListener(this.aTD));
            this.aTy.openVideo(this.aTE.getUri(), new Surface(this.aTE.getSurfaceTexture()), this.aTE.getHost());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.f
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
        this.aTE = bVar;
        try {
            this.aTy = d.JS().createPlayer();
            this.aTy.forceUseSystemMediaPlayer(CustomPlayerSwitchStatic.bfo() == 0);
            this.aTy.setListener(new PlayerListener(this.aTD));
            this.aTy.openVideo(this.aTE.getUri(), new Surface(this.aTE.getSurfaceTexture()), this.aTE.getHost());
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
    public void JU() {
        fK(getDuration());
    }

    @Override // com.baidu.tieba.play.f
    public void setOnPreparedListener(f.d dVar) {
        this.aTA = dVar;
    }

    @Override // com.baidu.tieba.play.f
    public void setOnCompletionListener(f.a aVar) {
        this.aTz = aVar;
    }

    @Override // com.baidu.tieba.play.f
    public void setOnErrorListener(f.b bVar) {
        this.aTB = bVar;
    }

    @Override // com.baidu.tieba.play.f
    public void a(f.c cVar) {
        this.aTC = cVar;
    }

    @Override // com.baidu.tieba.play.f
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

    @Override // com.baidu.tieba.play.f
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

    @Override // com.baidu.tieba.play.f
    public int getDuration() {
        if (this.aTy != null) {
            try {
                return this.aTy.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.aTy != null) {
            try {
                return this.aTy.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getVideoWidth() {
        if (this.aTy != null) {
            try {
                return this.aTy.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getVideoHeight() {
        if (this.aTy != null) {
            try {
                return this.aTy.getVideoHeight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public void seekTo(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(int i) {
        if (this.aTy != null) {
            try {
                this.aTy.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.aTy != null) {
            try {
                return this.aTy.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.f
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

    @Override // com.baidu.tieba.play.f
    public void setVolume(float f, float f2) {
        if (this.aTy != null) {
            try {
                this.aTy.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public void setLooping(boolean z) {
        if (this.aTy != null) {
            try {
                this.aTy.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isExistInRemote() {
        if (this.aTy != null) {
            try {
                return this.aTy.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
