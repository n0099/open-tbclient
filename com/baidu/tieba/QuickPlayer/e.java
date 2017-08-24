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
    private IQuickMediaPlayer aUM;
    private f.a aUN;
    private f.d aUO;
    private f.b aUP;
    private f.c aUQ;
    private b aUS;
    private Context mContext;
    private Handler.Callback aUT = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                e.this.a(e.this.aUM);
                e.this.aUM = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aUM);
            } else if (message.what == 4) {
                e.this.c(e.this.aUM);
            } else if (message.what == 5) {
                e.this.fM(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.Ka();
            }
            return true;
        }
    };
    private Handler.Callback aUU = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aUO != null) {
                    e.this.aUO.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aUN != null) {
                    e.this.aUN.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (e.this.aUP == null || !e.this.aUP.onError(e.this, message.arg1, message.arg2)) {
                }
            } else if (message.what == 9 && e.this.aUQ != null) {
                e.this.aUQ.a(e.this, message.arg1, message.arg2);
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.JX().getLooper(), this.aUT);
    private Handler aUR = new Handler(Looper.getMainLooper(), this.aUU);

    @Override // com.baidu.tieba.play.f
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.hh(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.aUS = bVar;
        try {
            this.aUM = d.JY().createPlayer();
            this.aUM.forceUseSystemMediaPlayer(CustomPlayerSwitchStatic.bfZ() == 0);
            this.aUM.setListener(new PlayerListener(this.aUR));
            this.aUM.openVideo(this.aUS.getUri(), new Surface(this.aUS.getSurfaceTexture()), this.aUS.getHost());
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
        this.aUS = bVar;
        try {
            this.aUM = d.JY().createPlayer();
            this.aUM.forceUseSystemMediaPlayer(CustomPlayerSwitchStatic.bfZ() == 0);
            this.aUM.setListener(new PlayerListener(this.aUR));
            this.aUM.openVideo(this.aUS.getUri(), new Surface(this.aUS.getSurfaceTexture()), this.aUS.getHost());
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
    public void Ka() {
        fM(getDuration());
    }

    @Override // com.baidu.tieba.play.f
    public void setOnPreparedListener(f.d dVar) {
        this.aUO = dVar;
    }

    @Override // com.baidu.tieba.play.f
    public void setOnCompletionListener(f.a aVar) {
        this.aUN = aVar;
    }

    @Override // com.baidu.tieba.play.f
    public void setOnErrorListener(f.b bVar) {
        this.aUP = bVar;
    }

    @Override // com.baidu.tieba.play.f
    public void a(f.c cVar) {
        this.aUQ = cVar;
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
        if (this.aUM != null) {
            try {
                return this.aUM.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.aUM != null) {
            try {
                return this.aUM.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getVideoWidth() {
        if (this.aUM != null) {
            try {
                return this.aUM.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getVideoHeight() {
        if (this.aUM != null) {
            try {
                return this.aUM.getVideoHeight();
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
    public void fM(int i) {
        if (this.aUM != null) {
            try {
                this.aUM.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.aUM != null) {
            try {
                return this.aUM.isPlaying();
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
        if (this.aUM != null) {
            try {
                this.aUM.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public void setLooping(boolean z) {
        if (this.aUM != null) {
            try {
                this.aUM.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isExistInRemote() {
        if (this.aUM != null) {
            try {
                return this.aUM.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
