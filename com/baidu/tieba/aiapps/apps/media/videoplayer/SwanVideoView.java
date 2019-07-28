package com.baidu.tieba.aiapps.apps.media.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.media.videoplayer.a;
import com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController;
import com.baidu.tieba.j.l;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes4.dex */
public class SwanVideoView extends FrameLayout {
    private static h dgq;
    private static l dgr;
    private Map<String, String> FV;
    private boolean aDf;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a dfX;
    private int dgd;
    private boolean dge;
    private MediaController dgf;
    private g dgg;
    private int dgh;
    private long dgi;
    private boolean dgj;
    private boolean dgk;
    private RelativeLayout dgl;
    private ProgressBar dgm;
    private TextView dgn;
    private a dgo;
    private FrameLayout dgp;
    g.f dgs;
    private g.a dgt;
    private g.b dgu;
    private g.e dgv;
    private g.InterfaceC0393g dgw;
    a.InterfaceC0289a dgx;
    private Context mAppContext;
    private int mCurrentState;
    private SurfaceTexture mSurfaceTexture;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;

    public SwanVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.dgi = -1L;
        this.dgk = true;
        this.dgd = 0;
        this.dgs = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.onPrepared(SwanVideoView.this.dgg);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dgo != null) {
                    SwanVideoView.this.dgo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dgo.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dge) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dgt = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dge = false;
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.onCompletion(SwanVideoView.this.dgg);
                }
            }
        };
        this.dgu = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dge = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dfX == null || SwanVideoView.this.dfX.onError(SwanVideoView.this.dgg, i, i2);
            }
        };
        this.dgv = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dfX != null && SwanVideoView.this.dfX.onInfo(gVar, i, i2);
            }
        };
        this.dgw = new g.InterfaceC0393g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.b(gVar);
                }
            }
        };
        this.dgx = new a.InterfaceC0289a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aGI() == SwanVideoView.this.dgo && SwanVideoView.this.dgg != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dgg, bVar);
                    SwanVideoView.this.dgg.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar) {
            }
        };
        dx(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.dgi = -1L;
        this.dgk = true;
        this.dgd = 0;
        this.dgs = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.onPrepared(SwanVideoView.this.dgg);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dgo != null) {
                    SwanVideoView.this.dgo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dgo.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dge) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dgt = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dge = false;
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.onCompletion(SwanVideoView.this.dgg);
                }
            }
        };
        this.dgu = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dge = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dfX == null || SwanVideoView.this.dfX.onError(SwanVideoView.this.dgg, i, i2);
            }
        };
        this.dgv = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dfX != null && SwanVideoView.this.dfX.onInfo(gVar, i, i2);
            }
        };
        this.dgw = new g.InterfaceC0393g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.b(gVar);
                }
            }
        };
        this.dgx = new a.InterfaceC0289a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aGI() == SwanVideoView.this.dgo && SwanVideoView.this.dgg != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dgg, bVar);
                    SwanVideoView.this.dgg.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar) {
            }
        };
        dx(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.dgi = -1L;
        this.dgk = true;
        this.dgd = 0;
        this.dgs = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.onPrepared(SwanVideoView.this.dgg);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dgo != null) {
                    SwanVideoView.this.dgo.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dgo.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dge) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dgt = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dge = false;
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.onCompletion(SwanVideoView.this.dgg);
                }
            }
        };
        this.dgu = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dge = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dfX == null || SwanVideoView.this.dfX.onError(SwanVideoView.this.dgg, i2, i22);
            }
        };
        this.dgv = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.dfX != null && SwanVideoView.this.dfX.onInfo(gVar, i2, i22);
            }
        };
        this.dgw = new g.InterfaceC0393g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dfX != null) {
                    SwanVideoView.this.dfX.b(gVar);
                }
            }
        };
        this.dgx = new a.InterfaceC0289a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aGI() == SwanVideoView.this.dgo && SwanVideoView.this.dgg != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dgg, bVar);
                    SwanVideoView.this.dgg.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar) {
            }
        };
        dx(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            dgq = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask2 != null) {
            dgr = (l) runTask2.getData();
        }
    }

    private void dx(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dgp = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dgp.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dgp, layoutParams);
        this.dgf = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dgf.setVisibility(8);
        addView(this.dgf, layoutParams2);
        this.dgf.o(this);
        aGM();
        aGL();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.dgk) {
                    if (SwanVideoView.this.dgf.getVisibility() != 0) {
                        SwanVideoView.this.dgf.aGT();
                    } else {
                        SwanVideoView.this.dgf.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.dgg.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aGL() {
        this.dgl = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dgl.setVisibility(8);
        addView(this.dgl, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dgm = new ProgressBar(getContext());
        this.dgm.setId(16908308);
        this.dgm.setMax(100);
        this.dgm.setProgress(10);
        this.dgm.setSecondaryProgress(100);
        this.dgl.addView(this.dgm, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dgn = new TextView(getContext());
        this.dgn.setTextColor(-1);
        this.dgn.setText(R.string.laoding);
        this.dgn.setGravity(1);
        this.dgl.addView(this.dgn, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.dfX = aVar;
        if (this.dgf != null) {
            this.dgf.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.dgf != null) {
                this.dgf.aGQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dgl.setVisibility(0);
        } else {
            this.dgl.setVisibility(8);
        }
    }

    private void aGM() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dgo != null) {
            if (this.dgg != null) {
            }
            View view = this.dgo.getView();
            this.dgo.b(this.dgx);
            this.dgo.release();
            this.dgo = null;
            this.dgp.removeView(view);
        }
        if (aVar != null) {
            this.dgo = aVar;
            aVar.setAspectRatio(this.dgd);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.dgo.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dgp.addView(view2);
            this.dgo.a(this.dgx);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aGN();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.FV = map;
    }

    private void aGN() {
        if (this.mUri != null) {
            try {
                if (dgq != null) {
                    this.dgg = dgq.aBG();
                }
                this.dgg.setOnPreparedListener(this.dgs);
                this.dgg.a(this.dgv);
                this.dgg.setOnCompletionListener(this.dgt);
                this.dgg.setOnErrorListener(this.dgu);
                this.dgg.setOnSeekCompleteListener(this.dgw);
                this.dgh = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.dge = false;
                this.dgu.onError(this.dgg, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.dgj = z;
        if (this.dgg != null) {
            this.dgg.setLooping(this.dgj);
        }
    }

    public void setMuted(boolean z) {
        if (this.dgg != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aDf = z;
            if (this.dgf != null && this.dgk) {
                this.dgf.setMute(this.aDf);
            }
        }
    }

    public boolean isMute() {
        return this.aDf;
    }

    public void setVolume(float f) {
        if (this.dgg != null) {
            this.dgg.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dgk = z;
    }

    public void start() {
        if (this.dgg != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.dgg.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.dgg.start();
                setCurrentState(3);
            }
            this.dge = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.dgg.isPlaying()) {
            this.dgg.pause();
            setCurrentState(4);
        }
        this.dge = false;
    }

    public int getBufferPercentage() {
        if (this.dgg != null) {
            return this.dgh;
        }
        return 0;
    }

    public String getCurrentPlayingUrl() {
        if (this.mUri != null) {
            return this.mUri.toString();
        }
        return null;
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return this.dgg.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.dgg.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.dgg.getDuration()) {
                i = this.dgg.getDuration() + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            }
            this.dgg.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.dgg.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.dgg == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.dgg.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.dgg.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.dgd = 0;
            } else if (i == 2) {
                this.dgd = 1;
            } else {
                this.dgd = 3;
            }
            if (this.dgo != null) {
                this.dgo.setAspectRatio(this.dgd);
                return;
            }
            return;
        }
        Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
    }

    public long getDownloadSpeed() {
        return 0L;
    }

    public Bitmap getBitmap() {
        if (this.dgo != null) {
            return this.dgo.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, a.b bVar) {
        if (gVar != null && bVar != null) {
            bVar.a(gVar);
        }
    }
}
