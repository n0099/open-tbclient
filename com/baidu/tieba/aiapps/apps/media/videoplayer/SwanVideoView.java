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
    private static h dgx;
    private static l dgy;
    private Map<String, String> FV;
    private boolean aDf;
    private g.a dgA;
    private g.b dgB;
    private g.e dgC;
    private g.InterfaceC0393g dgD;
    a.InterfaceC0289a dgE;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a dge;
    private int dgk;
    private boolean dgl;
    private MediaController dgm;
    private g dgn;
    private int dgo;
    private long dgp;
    private boolean dgq;
    private boolean dgr;
    private RelativeLayout dgs;
    private ProgressBar dgt;
    private TextView dgu;
    private a dgv;
    private FrameLayout dgw;
    g.f dgz;
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
        this.dgp = -1L;
        this.dgr = true;
        this.dgk = 0;
        this.dgz = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.onPrepared(SwanVideoView.this.dgn);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dgv != null) {
                    SwanVideoView.this.dgv.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dgv.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dgl) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dgA = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dgl = false;
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.onCompletion(SwanVideoView.this.dgn);
                }
            }
        };
        this.dgB = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dgl = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dge == null || SwanVideoView.this.dge.onError(SwanVideoView.this.dgn, i, i2);
            }
        };
        this.dgC = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dge != null && SwanVideoView.this.dge.onInfo(gVar, i, i2);
            }
        };
        this.dgD = new g.InterfaceC0393g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.b(gVar);
                }
            }
        };
        this.dgE = new a.InterfaceC0289a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aGK() == SwanVideoView.this.dgv && SwanVideoView.this.dgn != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dgn, bVar);
                    SwanVideoView.this.dgn.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
        this.dgp = -1L;
        this.dgr = true;
        this.dgk = 0;
        this.dgz = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.onPrepared(SwanVideoView.this.dgn);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dgv != null) {
                    SwanVideoView.this.dgv.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dgv.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dgl) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dgA = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dgl = false;
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.onCompletion(SwanVideoView.this.dgn);
                }
            }
        };
        this.dgB = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dgl = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dge == null || SwanVideoView.this.dge.onError(SwanVideoView.this.dgn, i, i2);
            }
        };
        this.dgC = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dge != null && SwanVideoView.this.dge.onInfo(gVar, i, i2);
            }
        };
        this.dgD = new g.InterfaceC0393g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.b(gVar);
                }
            }
        };
        this.dgE = new a.InterfaceC0289a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aGK() == SwanVideoView.this.dgv && SwanVideoView.this.dgn != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dgn, bVar);
                    SwanVideoView.this.dgn.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
        this.dgp = -1L;
        this.dgr = true;
        this.dgk = 0;
        this.dgz = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.onPrepared(SwanVideoView.this.dgn);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dgv != null) {
                    SwanVideoView.this.dgv.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dgv.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dgl) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dgA = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dgl = false;
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.onCompletion(SwanVideoView.this.dgn);
                }
            }
        };
        this.dgB = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dgl = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dge == null || SwanVideoView.this.dge.onError(SwanVideoView.this.dgn, i2, i22);
            }
        };
        this.dgC = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.dge != null && SwanVideoView.this.dge.onInfo(gVar, i2, i22);
            }
        };
        this.dgD = new g.InterfaceC0393g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dge != null) {
                    SwanVideoView.this.dge.b(gVar);
                }
            }
        };
        this.dgE = new a.InterfaceC0289a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0289a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aGK() == SwanVideoView.this.dgv && SwanVideoView.this.dgn != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dgn, bVar);
                    SwanVideoView.this.dgn.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
            dgx = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask2 != null) {
            dgy = (l) runTask2.getData();
        }
    }

    private void dx(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dgw = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dgw.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dgw, layoutParams);
        this.dgm = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dgm.setVisibility(8);
        addView(this.dgm, layoutParams2);
        this.dgm.o(this);
        aGO();
        aGN();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.dgr) {
                    if (SwanVideoView.this.dgm.getVisibility() != 0) {
                        SwanVideoView.this.dgm.aGV();
                    } else {
                        SwanVideoView.this.dgm.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.dgn.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aGN() {
        this.dgs = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dgs.setVisibility(8);
        addView(this.dgs, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dgt = new ProgressBar(getContext());
        this.dgt.setId(16908308);
        this.dgt.setMax(100);
        this.dgt.setProgress(10);
        this.dgt.setSecondaryProgress(100);
        this.dgs.addView(this.dgt, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dgu = new TextView(getContext());
        this.dgu.setTextColor(-1);
        this.dgu.setText(R.string.laoding);
        this.dgu.setGravity(1);
        this.dgs.addView(this.dgu, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.dge = aVar;
        if (this.dgm != null) {
            this.dgm.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.dgm != null) {
                this.dgm.aGS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dgs.setVisibility(0);
        } else {
            this.dgs.setVisibility(8);
        }
    }

    private void aGO() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dgv != null) {
            if (this.dgn != null) {
            }
            View view = this.dgv.getView();
            this.dgv.b(this.dgE);
            this.dgv.release();
            this.dgv = null;
            this.dgw.removeView(view);
        }
        if (aVar != null) {
            this.dgv = aVar;
            aVar.setAspectRatio(this.dgk);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.dgv.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dgw.addView(view2);
            this.dgv.a(this.dgE);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aGP();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.FV = map;
    }

    private void aGP() {
        if (this.mUri != null) {
            try {
                if (dgx != null) {
                    this.dgn = dgx.aBI();
                }
                this.dgn.setOnPreparedListener(this.dgz);
                this.dgn.a(this.dgC);
                this.dgn.setOnCompletionListener(this.dgA);
                this.dgn.setOnErrorListener(this.dgB);
                this.dgn.setOnSeekCompleteListener(this.dgD);
                this.dgo = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.dgl = false;
                this.dgB.onError(this.dgn, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.dgq = z;
        if (this.dgn != null) {
            this.dgn.setLooping(this.dgq);
        }
    }

    public void setMuted(boolean z) {
        if (this.dgn != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aDf = z;
            if (this.dgm != null && this.dgr) {
                this.dgm.setMute(this.aDf);
            }
        }
    }

    public boolean isMute() {
        return this.aDf;
    }

    public void setVolume(float f) {
        if (this.dgn != null) {
            this.dgn.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dgr = z;
    }

    public void start() {
        if (this.dgn != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.dgn.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.dgn.start();
                setCurrentState(3);
            }
            this.dgl = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.dgn.isPlaying()) {
            this.dgn.pause();
            setCurrentState(4);
        }
        this.dgl = false;
    }

    public int getBufferPercentage() {
        if (this.dgn != null) {
            return this.dgo;
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
            return this.dgn.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.dgn.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.dgn.getDuration()) {
                i = this.dgn.getDuration() + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            }
            this.dgn.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.dgn.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.dgn == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.dgn.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.dgn.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.dgk = 0;
            } else if (i == 2) {
                this.dgk = 1;
            } else {
                this.dgk = 3;
            }
            if (this.dgv != null) {
                this.dgv.setAspectRatio(this.dgk);
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
        if (this.dgv != null) {
            return this.dgv.getBitmap();
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
