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
    private static h deL;
    private static l deM;
    private Map<String, String> FO;
    private boolean aCx;
    private MediaController deA;
    private g deB;
    private int deC;
    private long deD;
    private boolean deE;
    private boolean deF;
    private RelativeLayout deG;
    private ProgressBar deH;
    private TextView deI;
    private a deJ;
    private FrameLayout deK;
    g.f deN;
    private g.a deO;
    private g.b deP;
    private g.e deQ;
    private g.InterfaceC0388g deR;
    a.InterfaceC0286a deS;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a der;
    private int dey;
    private boolean dez;
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
        this.deD = -1L;
        this.deF = true;
        this.dey = 0;
        this.deN = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.onPrepared(SwanVideoView.this.deB);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deJ != null) {
                    SwanVideoView.this.deJ.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deJ.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dez) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deO = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dez = false;
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.onCompletion(SwanVideoView.this.deB);
                }
            }
        };
        this.deP = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dez = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.der == null || SwanVideoView.this.der.onError(SwanVideoView.this.deB, i, i2);
            }
        };
        this.deQ = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.der != null && SwanVideoView.this.der.onInfo(gVar, i, i2);
            }
        };
        this.deR = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.b(gVar);
                }
            }
        };
        this.deS = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aFl() == SwanVideoView.this.deJ && SwanVideoView.this.deB != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deB, bVar);
                    SwanVideoView.this.deB.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FO, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
        this.deD = -1L;
        this.deF = true;
        this.dey = 0;
        this.deN = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.onPrepared(SwanVideoView.this.deB);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deJ != null) {
                    SwanVideoView.this.deJ.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deJ.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dez) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deO = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dez = false;
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.onCompletion(SwanVideoView.this.deB);
                }
            }
        };
        this.deP = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dez = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.der == null || SwanVideoView.this.der.onError(SwanVideoView.this.deB, i, i2);
            }
        };
        this.deQ = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.der != null && SwanVideoView.this.der.onInfo(gVar, i, i2);
            }
        };
        this.deR = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.b(gVar);
                }
            }
        };
        this.deS = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aFl() == SwanVideoView.this.deJ && SwanVideoView.this.deB != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deB, bVar);
                    SwanVideoView.this.deB.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FO, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
        this.deD = -1L;
        this.deF = true;
        this.dey = 0;
        this.deN = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.onPrepared(SwanVideoView.this.deB);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deJ != null) {
                    SwanVideoView.this.deJ.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deJ.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dez) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deO = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dez = false;
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.onCompletion(SwanVideoView.this.deB);
                }
            }
        };
        this.deP = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dez = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.der == null || SwanVideoView.this.der.onError(SwanVideoView.this.deB, i2, i22);
            }
        };
        this.deQ = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.der != null && SwanVideoView.this.der.onInfo(gVar, i2, i22);
            }
        };
        this.deR = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.der != null) {
                    SwanVideoView.this.der.b(gVar);
                }
            }
        };
        this.deS = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aFl() == SwanVideoView.this.deJ && SwanVideoView.this.deB != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deB, bVar);
                    SwanVideoView.this.deB.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FO, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
            deL = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask2 != null) {
            deM = (l) runTask2.getData();
        }
    }

    private void dw(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.deK = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.deK.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.deK, layoutParams);
        this.deA = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.deA.setVisibility(8);
        addView(this.deA, layoutParams2);
        this.deA.o(this);
        aFn();
        aFm();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.deF) {
                    if (SwanVideoView.this.deA.getVisibility() != 0) {
                        SwanVideoView.this.deA.aFu();
                    } else {
                        SwanVideoView.this.deA.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.deB.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aFm() {
        this.deG = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.deG.setVisibility(8);
        addView(this.deG, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.deH = new ProgressBar(getContext());
        this.deH.setId(16908308);
        this.deH.setMax(100);
        this.deH.setProgress(10);
        this.deH.setSecondaryProgress(100);
        this.deG.addView(this.deH, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.deI = new TextView(getContext());
        this.deI.setTextColor(-1);
        this.deI.setText(R.string.laoding);
        this.deI.setGravity(1);
        this.deG.addView(this.deI, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.der = aVar;
        if (this.deA != null) {
            this.deA.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.deA != null) {
                this.deA.aFr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.deG.setVisibility(0);
        } else {
            this.deG.setVisibility(8);
        }
    }

    private void aFn() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.deJ != null) {
            if (this.deB != null) {
            }
            View view = this.deJ.getView();
            this.deJ.b(this.deS);
            this.deJ.release();
            this.deJ = null;
            this.deK.removeView(view);
        }
        if (aVar != null) {
            this.deJ = aVar;
            aVar.setAspectRatio(this.dey);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.deJ.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.deK.addView(view2);
            this.deJ.a(this.deS);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aFo();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.FO = map;
    }

    private void aFo() {
        if (this.mUri != null) {
            try {
                if (deL != null) {
                    this.deB = deL.aAo();
                }
                this.deB.setOnPreparedListener(this.deN);
                this.deB.a(this.deQ);
                this.deB.setOnCompletionListener(this.deO);
                this.deB.setOnErrorListener(this.deP);
                this.deB.setOnSeekCompleteListener(this.deR);
                this.deC = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.dez = false;
                this.deP.onError(this.deB, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.deE = z;
        if (this.deB != null) {
            this.deB.setLooping(this.deE);
        }
    }

    public void setMuted(boolean z) {
        if (this.deB != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aCx = z;
            if (this.deA != null && this.deF) {
                this.deA.setMute(this.aCx);
            }
        }
    }

    public boolean isMute() {
        return this.aCx;
    }

    public void setVolume(float f) {
        if (this.deB != null) {
            this.deB.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.deF = z;
    }

    public void start() {
        if (this.deB != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.deB.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.deB.start();
                setCurrentState(3);
            }
            this.dez = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.deB.isPlaying()) {
            this.deB.pause();
            setCurrentState(4);
        }
        this.dez = false;
    }

    public int getBufferPercentage() {
        if (this.deB != null) {
            return this.deC;
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
            return this.deB.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.deB.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.deB.getDuration()) {
                i = this.deB.getDuration() + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            }
            this.deB.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.deB.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.deB == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.deB.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.deB.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.dey = 0;
            } else if (i == 2) {
                this.dey = 1;
            } else {
                this.dey = 3;
            }
            if (this.deJ != null) {
                this.deJ.setAspectRatio(this.dey);
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
        if (this.deJ != null) {
            return this.deJ.getBitmap();
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
