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
    private static h deM;
    private static l deN;
    private Map<String, String> FO;
    private boolean aCx;
    private boolean deA;
    private MediaController deB;
    private g deC;
    private int deD;
    private long deE;
    private boolean deF;
    private boolean deG;
    private RelativeLayout deH;
    private ProgressBar deI;
    private TextView deJ;
    private a deK;
    private FrameLayout deL;
    g.f deO;
    private g.a deP;
    private g.b deQ;
    private g.e deR;
    private g.InterfaceC0388g deS;
    a.InterfaceC0286a deT;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a det;
    private int dez;
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
        this.deE = -1L;
        this.deG = true;
        this.dez = 0;
        this.deO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.onPrepared(SwanVideoView.this.deC);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deK != null) {
                    SwanVideoView.this.deK.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deK.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.deA) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.deA = false;
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.onCompletion(SwanVideoView.this.deC);
                }
            }
        };
        this.deQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.deA = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.det == null || SwanVideoView.this.det.onError(SwanVideoView.this.deC, i, i2);
            }
        };
        this.deR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.det != null && SwanVideoView.this.det.onInfo(gVar, i, i2);
            }
        };
        this.deS = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.b(gVar);
                }
            }
        };
        this.deT = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aFo() == SwanVideoView.this.deK && SwanVideoView.this.deC != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deC, bVar);
                    SwanVideoView.this.deC.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FO, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar) {
            }
        };
        dw(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.deE = -1L;
        this.deG = true;
        this.dez = 0;
        this.deO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.onPrepared(SwanVideoView.this.deC);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deK != null) {
                    SwanVideoView.this.deK.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deK.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.deA) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.deA = false;
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.onCompletion(SwanVideoView.this.deC);
                }
            }
        };
        this.deQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.deA = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.det == null || SwanVideoView.this.det.onError(SwanVideoView.this.deC, i, i2);
            }
        };
        this.deR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.det != null && SwanVideoView.this.det.onInfo(gVar, i, i2);
            }
        };
        this.deS = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.b(gVar);
                }
            }
        };
        this.deT = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aFo() == SwanVideoView.this.deK && SwanVideoView.this.deC != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deC, bVar);
                    SwanVideoView.this.deC.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FO, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar) {
            }
        };
        dw(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.deE = -1L;
        this.deG = true;
        this.dez = 0;
        this.deO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.onPrepared(SwanVideoView.this.deC);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deK != null) {
                    SwanVideoView.this.deK.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deK.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.deA) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.deA = false;
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.onCompletion(SwanVideoView.this.deC);
                }
            }
        };
        this.deQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.deA = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.det == null || SwanVideoView.this.det.onError(SwanVideoView.this.deC, i2, i22);
            }
        };
        this.deR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.det != null && SwanVideoView.this.det.onInfo(gVar, i2, i22);
            }
        };
        this.deS = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.det != null) {
                    SwanVideoView.this.det.b(gVar);
                }
            }
        };
        this.deT = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aFo() == SwanVideoView.this.deK && SwanVideoView.this.deC != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deC, bVar);
                    SwanVideoView.this.deC.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FO, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar) {
            }
        };
        dw(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            deM = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask2 != null) {
            deN = (l) runTask2.getData();
        }
    }

    private void dw(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.deL = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.deL.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.deL, layoutParams);
        this.deB = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.deB.setVisibility(8);
        addView(this.deB, layoutParams2);
        this.deB.o(this);
        aFq();
        aFp();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.deG) {
                    if (SwanVideoView.this.deB.getVisibility() != 0) {
                        SwanVideoView.this.deB.aFx();
                    } else {
                        SwanVideoView.this.deB.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.deC.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aFp() {
        this.deH = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.deH.setVisibility(8);
        addView(this.deH, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.deI = new ProgressBar(getContext());
        this.deI.setId(16908308);
        this.deI.setMax(100);
        this.deI.setProgress(10);
        this.deI.setSecondaryProgress(100);
        this.deH.addView(this.deI, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.deJ = new TextView(getContext());
        this.deJ.setTextColor(-1);
        this.deJ.setText(R.string.laoding);
        this.deJ.setGravity(1);
        this.deH.addView(this.deJ, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.det = aVar;
        if (this.deB != null) {
            this.deB.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.deB != null) {
                this.deB.aFu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.deH.setVisibility(0);
        } else {
            this.deH.setVisibility(8);
        }
    }

    private void aFq() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.deK != null) {
            if (this.deC != null) {
            }
            View view = this.deK.getView();
            this.deK.b(this.deT);
            this.deK.release();
            this.deK = null;
            this.deL.removeView(view);
        }
        if (aVar != null) {
            this.deK = aVar;
            aVar.setAspectRatio(this.dez);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.deK.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.deL.addView(view2);
            this.deK.a(this.deT);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aFr();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.FO = map;
    }

    private void aFr() {
        if (this.mUri != null) {
            try {
                if (deM != null) {
                    this.deC = deM.aAr();
                }
                this.deC.setOnPreparedListener(this.deO);
                this.deC.a(this.deR);
                this.deC.setOnCompletionListener(this.deP);
                this.deC.setOnErrorListener(this.deQ);
                this.deC.setOnSeekCompleteListener(this.deS);
                this.deD = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.deA = false;
                this.deQ.onError(this.deC, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.deF = z;
        if (this.deC != null) {
            this.deC.setLooping(this.deF);
        }
    }

    public void setMuted(boolean z) {
        if (this.deC != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aCx = z;
            if (this.deB != null && this.deG) {
                this.deB.setMute(this.aCx);
            }
        }
    }

    public boolean isMute() {
        return this.aCx;
    }

    public void setVolume(float f) {
        if (this.deC != null) {
            this.deC.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.deG = z;
    }

    public void start() {
        if (this.deC != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.deC.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.deC.start();
                setCurrentState(3);
            }
            this.deA = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.deC.isPlaying()) {
            this.deC.pause();
            setCurrentState(4);
        }
        this.deA = false;
    }

    public int getBufferPercentage() {
        if (this.deC != null) {
            return this.deD;
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
            return this.deC.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.deC.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.deC.getDuration()) {
                i = this.deC.getDuration() + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            }
            this.deC.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.deC.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.deC == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.deC.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.deC.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.dez = 0;
            } else if (i == 2) {
                this.dez = 1;
            } else {
                this.dez = 3;
            }
            if (this.deK != null) {
                this.deK.setAspectRatio(this.dez);
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
        if (this.deK != null) {
            return this.deK.getBitmap();
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
