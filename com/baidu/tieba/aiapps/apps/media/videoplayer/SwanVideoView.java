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
    private static h eeZ;
    private static l efa;
    private boolean bEh;
    private int eeL;
    private boolean eeM;
    private MediaController eeN;
    private g eeO;
    private int eeP;
    private long eeQ;
    private boolean eeR;
    private boolean eeS;
    private RelativeLayout eeT;
    private ProgressBar eeU;
    private TextView eeV;
    private a eeW;
    private FrameLayout eeX;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a eeY;
    g.f efb;
    private g.a efc;
    private g.b efd;
    private g.e efe;
    private g.InterfaceC0590g eff;
    a.InterfaceC0417a efg;
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
        this.eeQ = -1L;
        this.eeS = true;
        this.eeL = 0;
        this.efb = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eeW != null) {
                    SwanVideoView.this.eeW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eeW.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeM) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efc = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeM = false;
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onEnd();
                }
            }
        };
        this.efd = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeM = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.g(i, i2, null);
                }
                return SwanVideoView.this.eeY != null;
            }
        };
        this.efe = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eeY != null;
            }
        };
        this.eff = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onSeekEnd();
                }
            }
        };
        this.efg = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bau() == SwanVideoView.this.eeW && SwanVideoView.this.eeO != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eeO, bVar);
                    SwanVideoView.this.eeO.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.bav(), SwanVideoView.this.mUri.getHost(), false);
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
        this.eeQ = -1L;
        this.eeS = true;
        this.eeL = 0;
        this.efb = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eeW != null) {
                    SwanVideoView.this.eeW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eeW.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeM) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efc = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeM = false;
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onEnd();
                }
            }
        };
        this.efd = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeM = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.g(i, i2, null);
                }
                return SwanVideoView.this.eeY != null;
            }
        };
        this.efe = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eeY != null;
            }
        };
        this.eff = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onSeekEnd();
                }
            }
        };
        this.efg = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bau() == SwanVideoView.this.eeW && SwanVideoView.this.eeO != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eeO, bVar);
                    SwanVideoView.this.eeO.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.bav(), SwanVideoView.this.mUri.getHost(), false);
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
        this.eeQ = -1L;
        this.eeS = true;
        this.eeL = 0;
        this.efb = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eeW != null) {
                    SwanVideoView.this.eeW.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eeW.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeM) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efc = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeM = false;
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onEnd();
                }
            }
        };
        this.efd = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeM = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.g(i2, i22, null);
                }
                return SwanVideoView.this.eeY != null;
            }
        };
        this.efe = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eeY != null;
            }
        };
        this.eff = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eeY != null) {
                    SwanVideoView.this.eeY.onSeekEnd();
                }
            }
        };
        this.efg = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bau() == SwanVideoView.this.eeW && SwanVideoView.this.eeO != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eeO, bVar);
                    SwanVideoView.this.eeO.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.bav(), SwanVideoView.this.mUri.getHost(), false);
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
            eeZ = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            efa = (l) runTask2.getData();
        }
    }

    private void eA(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eeX = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eeX.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eeX, layoutParams);
        this.eeN = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eeN.setVisibility(8);
        addView(this.eeN, layoutParams2);
        this.eeN.o(this);
        baz();
        bay();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.eeS) {
                    if (SwanVideoView.this.eeN.getVisibility() != 0) {
                        SwanVideoView.this.eeN.baF();
                    } else {
                        SwanVideoView.this.eeN.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.eeO.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void bay() {
        this.eeT = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eeT.setVisibility(8);
        addView(this.eeT, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eeU = new ProgressBar(getContext());
        this.eeU.setId(16908308);
        this.eeU.setMax(100);
        this.eeU.setProgress(10);
        this.eeU.setSecondaryProgress(100);
        this.eeT.addView(this.eeU, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eeV = new TextView(getContext());
        this.eeV.setTextColor(-1);
        this.eeV.setText(R.string.laoding);
        this.eeV.setGravity(1);
        this.eeT.addView(this.eeV, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.eeY = aVar;
        if (this.eeN != null) {
            this.eeN.setToggleScreenListener(aVar);
        }
    }

    public void cJ(boolean z) {
        if (this.eeO != null) {
            float f = z ? 0.0f : 1.0f;
            this.eeO.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.eeN != null) {
                this.eeN.baC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eeT.setVisibility(0);
        } else {
            this.eeT.setVisibility(8);
        }
    }

    private void baz() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eeW != null) {
            if (this.eeO != null) {
            }
            View view = this.eeW.getView();
            this.eeW.b(this.efg);
            this.eeW.release();
            this.eeW = null;
            this.eeX.removeView(view);
        }
        if (aVar != null) {
            this.eeW = aVar;
            aVar.setAspectRatio(this.eeL);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.eeW.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eeX.addView(view2);
            this.eeW.a(this.efg);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        baA();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.eeO != null) {
            this.eeO.pause();
            aWC();
            this.eeM = false;
        }
    }

    public void baA() {
        if (this.mUri != null) {
            try {
                if (eeZ != null) {
                    this.eeO = eeZ.aWJ();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.eeO.forceUseSystemMediaPlayer(true);
                    }
                }
                this.eeO.setOnPreparedListener(this.efb);
                this.eeO.a(this.efe);
                this.eeO.setOnCompletionListener(this.efc);
                this.eeO.setOnErrorListener(this.efd);
                this.eeO.setOnSeekCompleteListener(this.eff);
                this.eeP = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.eeM = false;
                this.efd.onError(this.eeO, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.eeR = z;
        if (this.eeO != null) {
            this.eeO.setLooping(this.eeR);
        }
    }

    public void setMuted(boolean z) {
        if (this.eeO != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.bEh = z;
            if (this.eeN != null && this.eeS) {
                this.eeN.setMute(this.bEh);
            }
        }
    }

    public boolean isMute() {
        return this.bEh;
    }

    public void setVolume(float f) {
        if (this.eeO != null) {
            this.eeO.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.eeS = z;
    }

    public void release() {
        aWC();
        this.eeM = false;
        if (this.eeW != null) {
            this.eeW.release();
        }
        if (this.eeN != null) {
            this.eeN.setToggleScreenListener(null);
            this.eeN.o(null);
            this.eeN = null;
        }
        if (this.eeY != null) {
            this.eeY = null;
        }
    }

    private void aWC() {
        if (this.eeO != null) {
            this.eeO.release();
            this.eeO = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.eeO != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.eeO.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.eeO.start();
                setCurrentState(3);
            }
            this.eeM = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.eeO.isPlaying()) {
            this.eeO.pause();
            setCurrentState(4);
        }
        this.eeM = false;
    }

    public int getBufferPercentage() {
        if (this.eeO != null) {
            return this.eeP;
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
            return this.eeO.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.eeO.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.eeO.getDuration()) {
                i = this.eeO.getDuration() - 1000;
            }
            this.eeO.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.eeO.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.eeO == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.eeO.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.eeO.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.eeL = 0;
            } else if (i == 2) {
                this.eeL = 1;
            } else {
                this.eeL = 3;
            }
            if (this.eeW != null) {
                this.eeW.setAspectRatio(this.eeL);
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
        if (this.eeW != null) {
            return this.eeW.getBitmap();
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
