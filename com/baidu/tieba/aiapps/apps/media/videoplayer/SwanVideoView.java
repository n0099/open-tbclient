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
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes4.dex */
public class SwanVideoView extends FrameLayout {
    private static h drD;
    private static l drE;
    private boolean aWS;
    private TextView drA;
    private a drB;
    private FrameLayout drC;
    g.f drF;
    private g.a drG;
    private g.b drH;
    private g.e drI;
    private g.InterfaceC0498g drJ;
    a.InterfaceC0330a drK;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a drk;
    private int drq;
    private boolean drr;
    private MediaController drs;
    private g drt;
    private int dru;
    private long drv;
    private boolean drw;
    private boolean drx;
    private RelativeLayout dry;
    private ProgressBar drz;
    private Context mAppContext;
    private int mCurrentState;
    private SurfaceTexture mSurfaceTexture;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private Map<String, String> tg;

    public SwanVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.drv = -1L;
        this.drx = true;
        this.drq = 0;
        this.drF = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.onPrepared(SwanVideoView.this.drt);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.drB != null) {
                    SwanVideoView.this.drB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.drB.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.drr) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.drG = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.drr = false;
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.onCompletion(SwanVideoView.this.drt);
                }
            }
        };
        this.drH = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.drr = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.drk == null || SwanVideoView.this.drk.onError(SwanVideoView.this.drt, i, i2);
            }
        };
        this.drI = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.drk != null && SwanVideoView.this.drk.onInfo(gVar, i, i2);
            }
        };
        this.drJ = new g.InterfaceC0498g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.b(gVar);
                }
            }
        };
        this.drK = new a.InterfaceC0330a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aHB() == SwanVideoView.this.drB && SwanVideoView.this.drt != null) {
                    SwanVideoView.this.a(SwanVideoView.this.drt, bVar);
                    SwanVideoView.this.drt.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.tg, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar) {
            }
        };
        dh(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.drv = -1L;
        this.drx = true;
        this.drq = 0;
        this.drF = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.onPrepared(SwanVideoView.this.drt);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.drB != null) {
                    SwanVideoView.this.drB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.drB.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.drr) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.drG = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.drr = false;
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.onCompletion(SwanVideoView.this.drt);
                }
            }
        };
        this.drH = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.drr = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.drk == null || SwanVideoView.this.drk.onError(SwanVideoView.this.drt, i, i2);
            }
        };
        this.drI = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.drk != null && SwanVideoView.this.drk.onInfo(gVar, i, i2);
            }
        };
        this.drJ = new g.InterfaceC0498g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.b(gVar);
                }
            }
        };
        this.drK = new a.InterfaceC0330a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aHB() == SwanVideoView.this.drB && SwanVideoView.this.drt != null) {
                    SwanVideoView.this.a(SwanVideoView.this.drt, bVar);
                    SwanVideoView.this.drt.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.tg, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar) {
            }
        };
        dh(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.drv = -1L;
        this.drx = true;
        this.drq = 0;
        this.drF = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.onPrepared(SwanVideoView.this.drt);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.drB != null) {
                    SwanVideoView.this.drB.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.drB.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.drr) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.drG = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.drr = false;
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.onCompletion(SwanVideoView.this.drt);
                }
            }
        };
        this.drH = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.drr = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.drk == null || SwanVideoView.this.drk.onError(SwanVideoView.this.drt, i2, i22);
            }
        };
        this.drI = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.drk != null && SwanVideoView.this.drk.onInfo(gVar, i2, i22);
            }
        };
        this.drJ = new g.InterfaceC0498g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.drk != null) {
                    SwanVideoView.this.drk.b(gVar);
                }
            }
        };
        this.drK = new a.InterfaceC0330a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aHB() == SwanVideoView.this.drB && SwanVideoView.this.drt != null) {
                    SwanVideoView.this.a(SwanVideoView.this.drt, bVar);
                    SwanVideoView.this.drt.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.tg, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0330a
            public void a(a.b bVar) {
            }
        };
        dh(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            drD = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            drE = (l) runTask2.getData();
        }
    }

    private void dh(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.drC = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.drC.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.drC, layoutParams);
        this.drs = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.drs.setVisibility(8);
        addView(this.drs, layoutParams2);
        this.drs.o(this);
        aHF();
        aHE();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.drx) {
                    if (SwanVideoView.this.drs.getVisibility() != 0) {
                        SwanVideoView.this.drs.aHM();
                    } else {
                        SwanVideoView.this.drs.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.drt.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aHE() {
        this.dry = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dry.setVisibility(8);
        addView(this.dry, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.drz = new ProgressBar(getContext());
        this.drz.setId(16908308);
        this.drz.setMax(100);
        this.drz.setProgress(10);
        this.drz.setSecondaryProgress(100);
        this.dry.addView(this.drz, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.drA = new TextView(getContext());
        this.drA.setTextColor(-1);
        this.drA.setText(R.string.laoding);
        this.drA.setGravity(1);
        this.dry.addView(this.drA, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.drk = aVar;
        if (this.drs != null) {
            this.drs.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.drs != null) {
                this.drs.aHJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dry.setVisibility(0);
        } else {
            this.dry.setVisibility(8);
        }
    }

    private void aHF() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.drB != null) {
            if (this.drt != null) {
            }
            View view = this.drB.getView();
            this.drB.b(this.drK);
            this.drB.release();
            this.drB = null;
            this.drC.removeView(view);
        }
        if (aVar != null) {
            this.drB = aVar;
            aVar.setAspectRatio(this.drq);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.drB.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.drC.addView(view2);
            this.drB.a(this.drK);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aHG();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.tg = map;
    }

    private void aHG() {
        if (this.mUri != null) {
            try {
                if (drD != null) {
                    this.drt = drD.aCg();
                }
                this.drt.setOnPreparedListener(this.drF);
                this.drt.a(this.drI);
                this.drt.setOnCompletionListener(this.drG);
                this.drt.setOnErrorListener(this.drH);
                this.drt.setOnSeekCompleteListener(this.drJ);
                this.dru = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.drr = false;
                this.drH.onError(this.drt, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.drw = z;
        if (this.drt != null) {
            this.drt.setLooping(this.drw);
        }
    }

    public void setMuted(boolean z) {
        if (this.drt != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aWS = z;
            if (this.drs != null && this.drx) {
                this.drs.setMute(this.aWS);
            }
        }
    }

    public boolean isMute() {
        return this.aWS;
    }

    public void setVolume(float f) {
        if (this.drt != null) {
            this.drt.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.drx = z;
    }

    public void start() {
        if (this.drt != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.drt.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.drt.start();
                setCurrentState(3);
            }
            this.drr = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.drt.isPlaying()) {
            this.drt.pause();
            setCurrentState(4);
        }
        this.drr = false;
    }

    public int getBufferPercentage() {
        if (this.drt != null) {
            return this.dru;
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
            return this.drt.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.drt.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.drt.getDuration()) {
                i = this.drt.getDuration() - 1000;
            }
            this.drt.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.drt.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.drt == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.drt.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.drt.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.drq = 0;
            } else if (i == 2) {
                this.drq = 1;
            } else {
                this.drq = 3;
            }
            if (this.drB != null) {
                this.drB.setAspectRatio(this.drq);
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
        if (this.drB != null) {
            return this.drB.getBitmap();
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
