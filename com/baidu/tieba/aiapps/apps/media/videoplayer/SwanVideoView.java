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
import com.baidu.tieba.k.l;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.h;
import java.util.Map;
/* loaded from: classes12.dex */
public class SwanVideoView extends FrameLayout {
    private static h eeY;
    private static l eeZ;
    private boolean bEg;
    private int eeK;
    private boolean eeL;
    private MediaController eeM;
    private g eeN;
    private int eeO;
    private long eeP;
    private boolean eeQ;
    private boolean eeR;
    private RelativeLayout eeS;
    private ProgressBar eeT;
    private TextView eeU;
    private a eeV;
    private FrameLayout eeW;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a eeX;
    g.f efa;
    private g.a efb;
    private g.b efc;
    private g.e efd;
    private g.InterfaceC0590g efe;
    a.InterfaceC0417a eff;
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
        this.eeP = -1L;
        this.eeR = true;
        this.eeK = 0;
        this.efa = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eeV != null) {
                    SwanVideoView.this.eeV.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eeV.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeL) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efb = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeL = false;
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onEnd();
                }
            }
        };
        this.efc = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeL = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.g(i, i2, null);
                }
                return SwanVideoView.this.eeX != null;
            }
        };
        this.efd = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eeX != null;
            }
        };
        this.efe = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onSeekEnd();
                }
            }
        };
        this.eff = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bas() == SwanVideoView.this.eeV && SwanVideoView.this.eeN != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eeN, bVar);
                    SwanVideoView.this.eeN.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.bat(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar) {
            }
        };
        eA(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.eeP = -1L;
        this.eeR = true;
        this.eeK = 0;
        this.efa = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eeV != null) {
                    SwanVideoView.this.eeV.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eeV.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeL) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efb = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeL = false;
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onEnd();
                }
            }
        };
        this.efc = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeL = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.g(i, i2, null);
                }
                return SwanVideoView.this.eeX != null;
            }
        };
        this.efd = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eeX != null;
            }
        };
        this.efe = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onSeekEnd();
                }
            }
        };
        this.eff = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bas() == SwanVideoView.this.eeV && SwanVideoView.this.eeN != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eeN, bVar);
                    SwanVideoView.this.eeN.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.bat(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar) {
            }
        };
        eA(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.eeP = -1L;
        this.eeR = true;
        this.eeK = 0;
        this.efa = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eeV != null) {
                    SwanVideoView.this.eeV.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eeV.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeL) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efb = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeL = false;
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onEnd();
                }
            }
        };
        this.efc = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeL = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.g(i2, i22, null);
                }
                return SwanVideoView.this.eeX != null;
            }
        };
        this.efd = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eeX != null;
            }
        };
        this.efe = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeX != null) {
                    SwanVideoView.this.eeX.onSeekEnd();
                }
            }
        };
        this.eff = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bas() == SwanVideoView.this.eeV && SwanVideoView.this.eeN != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eeN, bVar);
                    SwanVideoView.this.eeN.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.bat(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar) {
            }
        };
        eA(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            eeY = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            eeZ = (l) runTask2.getData();
        }
    }

    private void eA(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eeW = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eeW.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eeW, layoutParams);
        this.eeM = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eeM.setVisibility(8);
        addView(this.eeM, layoutParams2);
        this.eeM.o(this);
        bax();
        baw();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.eeR) {
                    if (SwanVideoView.this.eeM.getVisibility() != 0) {
                        SwanVideoView.this.eeM.baD();
                    } else {
                        SwanVideoView.this.eeM.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.eeN.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void baw() {
        this.eeS = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eeS.setVisibility(8);
        addView(this.eeS, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eeT = new ProgressBar(getContext());
        this.eeT.setId(16908308);
        this.eeT.setMax(100);
        this.eeT.setProgress(10);
        this.eeT.setSecondaryProgress(100);
        this.eeS.addView(this.eeT, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eeU = new TextView(getContext());
        this.eeU.setTextColor(-1);
        this.eeU.setText(R.string.laoding);
        this.eeU.setGravity(1);
        this.eeS.addView(this.eeU, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.eeX = aVar;
        if (this.eeM != null) {
            this.eeM.setToggleScreenListener(aVar);
        }
    }

    public void cJ(boolean z) {
        if (this.eeN != null) {
            float f = z ? 0.0f : 1.0f;
            this.eeN.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.eeM != null) {
                this.eeM.baA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eeS.setVisibility(0);
        } else {
            this.eeS.setVisibility(8);
        }
    }

    private void bax() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eeV != null) {
            if (this.eeN != null) {
            }
            View view = this.eeV.getView();
            this.eeV.b(this.eff);
            this.eeV.release();
            this.eeV = null;
            this.eeW.removeView(view);
        }
        if (aVar != null) {
            this.eeV = aVar;
            aVar.setAspectRatio(this.eeK);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.eeV.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eeW.addView(view2);
            this.eeV.a(this.eff);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        bay();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.eeN != null) {
            this.eeN.pause();
            aWA();
            this.eeL = false;
        }
    }

    public void bay() {
        if (this.mUri != null) {
            try {
                if (eeY != null) {
                    this.eeN = eeY.aWH();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.eeN.forceUseSystemMediaPlayer(true);
                    }
                }
                this.eeN.setOnPreparedListener(this.efa);
                this.eeN.a(this.efd);
                this.eeN.setOnCompletionListener(this.efb);
                this.eeN.setOnErrorListener(this.efc);
                this.eeN.setOnSeekCompleteListener(this.efe);
                this.eeO = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.eeL = false;
                this.efc.onError(this.eeN, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.eeQ = z;
        if (this.eeN != null) {
            this.eeN.setLooping(this.eeQ);
        }
    }

    public void setMuted(boolean z) {
        if (this.eeN != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.bEg = z;
            if (this.eeM != null && this.eeR) {
                this.eeM.setMute(this.bEg);
            }
        }
    }

    public boolean isMute() {
        return this.bEg;
    }

    public void setVolume(float f) {
        if (this.eeN != null) {
            this.eeN.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.eeR = z;
    }

    public void release() {
        aWA();
        this.eeL = false;
        if (this.eeV != null) {
            this.eeV.release();
        }
        if (this.eeM != null) {
            this.eeM.setToggleScreenListener(null);
            this.eeM.o(null);
            this.eeM = null;
        }
        if (this.eeX != null) {
            this.eeX = null;
        }
    }

    private void aWA() {
        if (this.eeN != null) {
            this.eeN.release();
            this.eeN = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.eeN != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.eeN.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.eeN.start();
                setCurrentState(3);
            }
            this.eeL = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.eeN.isPlaying()) {
            this.eeN.pause();
            setCurrentState(4);
        }
        this.eeL = false;
    }

    public int getBufferPercentage() {
        if (this.eeN != null) {
            return this.eeO;
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
            return this.eeN.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.eeN.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.eeN.getDuration()) {
                i = this.eeN.getDuration() - 1000;
            }
            this.eeN.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.eeN.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.eeN == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.eeN.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.eeN.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.eeK = 0;
            } else if (i == 2) {
                this.eeK = 1;
            } else {
                this.eeK = 3;
            }
            if (this.eeV != null) {
                this.eeV.setAspectRatio(this.eeK);
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
        if (this.eeV != null) {
            return this.eeV.getBitmap();
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
