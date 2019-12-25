package com.baidu.tieba.aiapps.apps.media.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.net.Uri;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.media.videoplayer.a;
import com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController;
import com.baidu.tieba.j.l;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.h;
import java.util.Map;
/* loaded from: classes9.dex */
public class SwanVideoView extends FrameLayout {
    private static h eaM;
    private static l eaN;
    private boolean bzn;
    private MediaController eaA;
    private g eaB;
    private int eaC;
    private long eaD;
    private boolean eaE;
    private boolean eaF;
    private RelativeLayout eaG;
    private ProgressBar eaH;
    private TextView eaI;
    private a eaJ;
    private FrameLayout eaK;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a eaL;
    g.f eaO;
    private g.a eaP;
    private g.b eaQ;
    private g.e eaR;
    private g.InterfaceC0577g eaS;
    a.InterfaceC0404a eaT;
    private int eay;
    private boolean eaz;
    private Context mAppContext;
    private int mCurrentState;
    private Map<String, String> mHeaders;
    private SurfaceTexture mSurfaceTexture;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;

    public SwanVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.eaD = -1L;
        this.eaF = true;
        this.eay = 0;
        this.eaO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eaJ != null) {
                    SwanVideoView.this.eaJ.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eaJ.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eaz) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eaP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eaz = false;
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onEnd();
                }
            }
        };
        this.eaQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eaz = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.f(i, i2, null);
                }
                return SwanVideoView.this.eaL != null;
            }
        };
        this.eaR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eaL != null;
            }
        };
        this.eaS = new g.InterfaceC0577g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onSeekEnd();
                }
            }
        };
        this.eaT = new a.InterfaceC0404a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aXJ() == SwanVideoView.this.eaJ && SwanVideoView.this.eaB != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eaB, bVar);
                    SwanVideoView.this.eaB.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.aXK(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar) {
            }
        };
        ex(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.eaD = -1L;
        this.eaF = true;
        this.eay = 0;
        this.eaO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eaJ != null) {
                    SwanVideoView.this.eaJ.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eaJ.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eaz) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eaP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eaz = false;
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onEnd();
                }
            }
        };
        this.eaQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eaz = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.f(i, i2, null);
                }
                return SwanVideoView.this.eaL != null;
            }
        };
        this.eaR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eaL != null;
            }
        };
        this.eaS = new g.InterfaceC0577g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onSeekEnd();
                }
            }
        };
        this.eaT = new a.InterfaceC0404a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aXJ() == SwanVideoView.this.eaJ && SwanVideoView.this.eaB != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eaB, bVar);
                    SwanVideoView.this.eaB.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.aXK(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar) {
            }
        };
        ex(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.eaD = -1L;
        this.eaF = true;
        this.eay = 0;
        this.eaO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eaJ != null) {
                    SwanVideoView.this.eaJ.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eaJ.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eaz) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eaP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eaz = false;
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onEnd();
                }
            }
        };
        this.eaQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eaz = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.f(i2, i22, null);
                }
                return SwanVideoView.this.eaL != null;
            }
        };
        this.eaR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eaL != null;
            }
        };
        this.eaS = new g.InterfaceC0577g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaL != null) {
                    SwanVideoView.this.eaL.onSeekEnd();
                }
            }
        };
        this.eaT = new a.InterfaceC0404a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aXJ() == SwanVideoView.this.eaJ && SwanVideoView.this.eaB != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eaB, bVar);
                    SwanVideoView.this.eaB.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.aXK(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0404a
            public void a(a.b bVar) {
            }
        };
        ex(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            eaM = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            eaN = (l) runTask2.getData();
        }
    }

    private void ex(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eaK = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eaK.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eaK, layoutParams);
        this.eaA = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eaA.setVisibility(8);
        addView(this.eaA, layoutParams2);
        this.eaA.o(this);
        aXO();
        aXN();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.eaF) {
                    if (SwanVideoView.this.eaA.getVisibility() != 0) {
                        SwanVideoView.this.eaA.aXU();
                    } else {
                        SwanVideoView.this.eaA.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.eaB.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aXN() {
        this.eaG = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eaG.setVisibility(8);
        addView(this.eaG, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eaH = new ProgressBar(getContext());
        this.eaH.setId(16908308);
        this.eaH.setMax(100);
        this.eaH.setProgress(10);
        this.eaH.setSecondaryProgress(100);
        this.eaG.addView(this.eaH, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eaI = new TextView(getContext());
        this.eaI.setTextColor(-1);
        this.eaI.setText(R.string.laoding);
        this.eaI.setGravity(1);
        this.eaG.addView(this.eaI, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.eaL = aVar;
        if (this.eaA != null) {
            this.eaA.setToggleScreenListener(aVar);
        }
    }

    public void cx(boolean z) {
        if (this.eaB != null) {
            float f = z ? 0.0f : 1.0f;
            this.eaB.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.eaA != null) {
                this.eaA.aXR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eaG.setVisibility(0);
        } else {
            this.eaG.setVisibility(8);
        }
    }

    private void aXO() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eaJ != null) {
            if (this.eaB != null) {
            }
            View view = this.eaJ.getView();
            this.eaJ.b(this.eaT);
            this.eaJ.release();
            this.eaJ = null;
            this.eaK.removeView(view);
        }
        if (aVar != null) {
            this.eaJ = aVar;
            aVar.setAspectRatio(this.eay);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.eaJ.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eaK.addView(view2);
            this.eaJ.a(this.eaT);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aXP();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.eaB != null) {
            this.eaB.pause();
            aTQ();
            this.eaz = false;
        }
    }

    public void aXP() {
        if (this.mUri != null) {
            try {
                if (eaM != null) {
                    this.eaB = eaM.aTX();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.eaB.forceUseSystemMediaPlayer(true);
                    }
                }
                this.eaB.setOnPreparedListener(this.eaO);
                this.eaB.a(this.eaR);
                this.eaB.setOnCompletionListener(this.eaP);
                this.eaB.setOnErrorListener(this.eaQ);
                this.eaB.setOnSeekCompleteListener(this.eaS);
                this.eaC = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.eaz = false;
                this.eaQ.onError(this.eaB, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.eaE = z;
        if (this.eaB != null) {
            this.eaB.setLooping(this.eaE);
        }
    }

    public void setMuted(boolean z) {
        if (this.eaB != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.bzn = z;
            if (this.eaA != null && this.eaF) {
                this.eaA.setMute(this.bzn);
            }
        }
    }

    public boolean isMute() {
        return this.bzn;
    }

    public void setVolume(float f) {
        if (this.eaB != null) {
            this.eaB.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.eaF = z;
    }

    public void release() {
        aTQ();
        this.eaz = false;
        if (this.eaJ != null) {
            this.eaJ.release();
        }
        if (this.eaA != null) {
            this.eaA.setToggleScreenListener(null);
            this.eaA.o(null);
            this.eaA = null;
        }
        if (this.eaL != null) {
            this.eaL = null;
        }
    }

    private void aTQ() {
        if (this.eaB != null) {
            this.eaB.release();
            this.eaB = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.eaB != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.eaB.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.eaB.start();
                setCurrentState(3);
            }
            this.eaz = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.eaB.isPlaying()) {
            this.eaB.pause();
            setCurrentState(4);
        }
        this.eaz = false;
    }

    public int getBufferPercentage() {
        if (this.eaB != null) {
            return this.eaC;
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
            return this.eaB.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.eaB.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.eaB.getDuration()) {
                i = this.eaB.getDuration() - 1000;
            }
            this.eaB.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.eaB.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.eaB == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.eaB.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.eaB.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.eay = 0;
            } else if (i == 2) {
                this.eay = 1;
            } else {
                this.eay = 3;
            }
            if (this.eaJ != null) {
                this.eaJ.setAspectRatio(this.eay);
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
        if (this.eaJ != null) {
            return this.eaJ.getBitmap();
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
