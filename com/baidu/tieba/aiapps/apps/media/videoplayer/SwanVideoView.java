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
    private static h efC;
    private static l efD;
    private boolean bEt;
    private FrameLayout efA;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a efB;
    g.f efE;
    private g.a efF;
    private g.b efG;
    private g.e efH;
    private g.InterfaceC0591g efI;
    a.InterfaceC0417a efJ;
    private int efo;
    private boolean efp;
    private MediaController efq;
    private g efr;
    private int efs;
    private long eft;
    private boolean efu;
    private boolean efv;
    private RelativeLayout efw;
    private ProgressBar efx;
    private TextView efy;
    private a efz;
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
        this.eft = -1L;
        this.efv = true;
        this.efo = 0;
        this.efE = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.efz != null) {
                    SwanVideoView.this.efz.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.efz.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.efp) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efF = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.efp = false;
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onEnd();
                }
            }
        };
        this.efG = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.efp = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.g(i, i2, null);
                }
                return SwanVideoView.this.efB != null;
            }
        };
        this.efH = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.a(SwanVideoView.this);
                }
                return SwanVideoView.this.efB != null;
            }
        };
        this.efI = new g.InterfaceC0591g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onSeekEnd();
                }
            }
        };
        this.efJ = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.baz() == SwanVideoView.this.efz && SwanVideoView.this.efr != null) {
                    SwanVideoView.this.a(SwanVideoView.this.efr, bVar);
                    SwanVideoView.this.efr.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.baA(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar) {
            }
        };
        ez(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.eft = -1L;
        this.efv = true;
        this.efo = 0;
        this.efE = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.efz != null) {
                    SwanVideoView.this.efz.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.efz.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.efp) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efF = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.efp = false;
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onEnd();
                }
            }
        };
        this.efG = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.efp = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.g(i, i2, null);
                }
                return SwanVideoView.this.efB != null;
            }
        };
        this.efH = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.a(SwanVideoView.this);
                }
                return SwanVideoView.this.efB != null;
            }
        };
        this.efI = new g.InterfaceC0591g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onSeekEnd();
                }
            }
        };
        this.efJ = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.baz() == SwanVideoView.this.efz && SwanVideoView.this.efr != null) {
                    SwanVideoView.this.a(SwanVideoView.this.efr, bVar);
                    SwanVideoView.this.efr.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.baA(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar) {
            }
        };
        ez(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.eft = -1L;
        this.efv = true;
        this.efo = 0;
        this.efE = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.efz != null) {
                    SwanVideoView.this.efz.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.efz.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.efp) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efF = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.efp = false;
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onEnd();
                }
            }
        };
        this.efG = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.efp = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.g(i2, i22, null);
                }
                return SwanVideoView.this.efB != null;
            }
        };
        this.efH = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.a(SwanVideoView.this);
                }
                return SwanVideoView.this.efB != null;
            }
        };
        this.efI = new g.InterfaceC0591g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efB != null) {
                    SwanVideoView.this.efB.onSeekEnd();
                }
            }
        };
        this.efJ = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.baz() == SwanVideoView.this.efz && SwanVideoView.this.efr != null) {
                    SwanVideoView.this.a(SwanVideoView.this.efr, bVar);
                    SwanVideoView.this.efr.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.baA(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar) {
            }
        };
        ez(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            efC = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            efD = (l) runTask2.getData();
        }
    }

    private void ez(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.efA = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.efA.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.efA, layoutParams);
        this.efq = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.efq.setVisibility(8);
        addView(this.efq, layoutParams2);
        this.efq.o(this);
        baE();
        baD();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.efv) {
                    if (SwanVideoView.this.efq.getVisibility() != 0) {
                        SwanVideoView.this.efq.baK();
                    } else {
                        SwanVideoView.this.efq.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.efr.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void baD() {
        this.efw = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.efw.setVisibility(8);
        addView(this.efw, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.efx = new ProgressBar(getContext());
        this.efx.setId(16908308);
        this.efx.setMax(100);
        this.efx.setProgress(10);
        this.efx.setSecondaryProgress(100);
        this.efw.addView(this.efx, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.efy = new TextView(getContext());
        this.efy.setTextColor(-1);
        this.efy.setText(R.string.laoding);
        this.efy.setGravity(1);
        this.efw.addView(this.efy, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.efB = aVar;
        if (this.efq != null) {
            this.efq.setToggleScreenListener(aVar);
        }
    }

    public void cK(boolean z) {
        if (this.efr != null) {
            float f = z ? 0.0f : 1.0f;
            this.efr.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.efq != null) {
                this.efq.baH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.efw.setVisibility(0);
        } else {
            this.efw.setVisibility(8);
        }
    }

    private void baE() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.efz != null) {
            if (this.efr != null) {
            }
            View view = this.efz.getView();
            this.efz.b(this.efJ);
            this.efz.release();
            this.efz = null;
            this.efA.removeView(view);
        }
        if (aVar != null) {
            this.efz = aVar;
            aVar.setAspectRatio(this.efo);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.efz.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.efA.addView(view2);
            this.efz.a(this.efJ);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        baF();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.efr != null) {
            this.efr.pause();
            aWH();
            this.efp = false;
        }
    }

    public void baF() {
        if (this.mUri != null) {
            try {
                if (efC != null) {
                    this.efr = efC.aWO();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.efr.forceUseSystemMediaPlayer(true);
                    }
                }
                this.efr.setOnPreparedListener(this.efE);
                this.efr.a(this.efH);
                this.efr.setOnCompletionListener(this.efF);
                this.efr.setOnErrorListener(this.efG);
                this.efr.setOnSeekCompleteListener(this.efI);
                this.efs = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.efp = false;
                this.efG.onError(this.efr, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.efu = z;
        if (this.efr != null) {
            this.efr.setLooping(this.efu);
        }
    }

    public void setMuted(boolean z) {
        if (this.efr != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.bEt = z;
            if (this.efq != null && this.efv) {
                this.efq.setMute(this.bEt);
            }
        }
    }

    public boolean isMute() {
        return this.bEt;
    }

    public void setVolume(float f) {
        if (this.efr != null) {
            this.efr.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.efv = z;
    }

    public void release() {
        aWH();
        this.efp = false;
        if (this.efz != null) {
            this.efz.release();
        }
        if (this.efq != null) {
            this.efq.setToggleScreenListener(null);
            this.efq.o(null);
            this.efq = null;
        }
        if (this.efB != null) {
            this.efB = null;
        }
    }

    private void aWH() {
        if (this.efr != null) {
            this.efr.release();
            this.efr = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.efr != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.efr.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.efr.start();
                setCurrentState(3);
            }
            this.efp = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.efr.isPlaying()) {
            this.efr.pause();
            setCurrentState(4);
        }
        this.efp = false;
    }

    public int getBufferPercentage() {
        if (this.efr != null) {
            return this.efs;
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
            return this.efr.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.efr.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.efr.getDuration()) {
                i = this.efr.getDuration() - 1000;
            }
            this.efr.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.efr.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.efr == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.efr.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.efr.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.efo = 0;
            } else if (i == 2) {
                this.efo = 1;
            } else {
                this.efo = 3;
            }
            if (this.efz != null) {
                this.efz.setAspectRatio(this.efo);
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
        if (this.efz != null) {
            return this.efz.getBitmap();
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
