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
    private static h eFx;
    private static l eFy;
    private boolean cdi;
    private g.a eFA;
    private g.b eFB;
    private g.e eFC;
    private g.InterfaceC0651g eFD;
    a.InterfaceC0469a eFE;
    private int eFj;
    private boolean eFk;
    private MediaController eFl;
    private g eFm;
    private int eFn;
    private long eFo;
    private boolean eFp;
    private boolean eFq;
    private RelativeLayout eFr;
    private ProgressBar eFs;
    private TextView eFt;
    private a eFu;
    private FrameLayout eFv;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a eFw;
    g.f eFz;
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
        this.eFo = -1L;
        this.eFq = true;
        this.eFj = 0;
        this.eFz = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eFu != null) {
                    SwanVideoView.this.eFu.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eFu.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eFk) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eFA = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eFk = false;
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onEnd();
                }
            }
        };
        this.eFB = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eFk = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.g(i, i2, null);
                }
                return SwanVideoView.this.eFw != null;
            }
        };
        this.eFC = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eFw != null;
            }
        };
        this.eFD = new g.InterfaceC0651g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onSeekEnd();
                }
            }
        };
        this.eFE = new a.InterfaceC0469a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.biA() == SwanVideoView.this.eFu && SwanVideoView.this.eFm != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eFm, bVar);
                    SwanVideoView.this.eFm.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.biB(), SwanVideoView.this.mUri.getHost());
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar) {
            }
        };
        dZ(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.eFo = -1L;
        this.eFq = true;
        this.eFj = 0;
        this.eFz = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eFu != null) {
                    SwanVideoView.this.eFu.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eFu.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eFk) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eFA = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eFk = false;
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onEnd();
                }
            }
        };
        this.eFB = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eFk = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.g(i, i2, null);
                }
                return SwanVideoView.this.eFw != null;
            }
        };
        this.eFC = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eFw != null;
            }
        };
        this.eFD = new g.InterfaceC0651g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onSeekEnd();
                }
            }
        };
        this.eFE = new a.InterfaceC0469a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.biA() == SwanVideoView.this.eFu && SwanVideoView.this.eFm != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eFm, bVar);
                    SwanVideoView.this.eFm.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.biB(), SwanVideoView.this.mUri.getHost());
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar) {
            }
        };
        dZ(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.eFo = -1L;
        this.eFq = true;
        this.eFj = 0;
        this.eFz = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eFu != null) {
                    SwanVideoView.this.eFu.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eFu.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eFk) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eFA = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eFk = false;
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onEnd();
                }
            }
        };
        this.eFB = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eFk = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.g(i2, i22, null);
                }
                return SwanVideoView.this.eFw != null;
            }
        };
        this.eFC = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eFw != null;
            }
        };
        this.eFD = new g.InterfaceC0651g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFw != null) {
                    SwanVideoView.this.eFw.onSeekEnd();
                }
            }
        };
        this.eFE = new a.InterfaceC0469a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.biA() == SwanVideoView.this.eFu && SwanVideoView.this.eFm != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eFm, bVar);
                    SwanVideoView.this.eFm.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.biB(), SwanVideoView.this.mUri.getHost());
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0469a
            public void a(a.b bVar) {
            }
        };
        dZ(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            eFx = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            eFy = (l) runTask2.getData();
        }
    }

    private void dZ(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eFv = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eFv.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eFv, layoutParams);
        this.eFl = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eFl.setVisibility(8);
        addView(this.eFl, layoutParams2);
        this.eFl.o(this);
        biF();
        biE();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.eFq) {
                    if (SwanVideoView.this.eFl.getVisibility() != 0) {
                        SwanVideoView.this.eFl.biL();
                    } else {
                        SwanVideoView.this.eFl.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.eFm.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void biE() {
        this.eFr = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eFr.setVisibility(8);
        addView(this.eFr, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eFs = new ProgressBar(getContext());
        this.eFs.setId(16908308);
        this.eFs.setMax(100);
        this.eFs.setProgress(10);
        this.eFs.setSecondaryProgress(100);
        this.eFr.addView(this.eFs, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eFt = new TextView(getContext());
        this.eFt.setTextColor(-1);
        this.eFt.setText(R.string.laoding);
        this.eFt.setGravity(1);
        this.eFr.addView(this.eFt, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.eFw = aVar;
        if (this.eFl != null) {
            this.eFl.setToggleScreenListener(aVar);
        }
    }

    public void dG(boolean z) {
        if (this.eFm != null) {
            float f = z ? 0.0f : 1.0f;
            this.eFm.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.eFl != null) {
                this.eFl.biI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eFr.setVisibility(0);
        } else {
            this.eFr.setVisibility(8);
        }
    }

    private void biF() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eFu != null) {
            if (this.eFm != null) {
            }
            View view = this.eFu.getView();
            this.eFu.b(this.eFE);
            this.eFu.release();
            this.eFu = null;
            this.eFv.removeView(view);
        }
        if (aVar != null) {
            this.eFu = aVar;
            aVar.setAspectRatio(this.eFj);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.eFu.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eFv.addView(view2);
            this.eFu.a(this.eFE);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        biG();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.eFm != null) {
            this.eFm.pause();
            beL();
            this.eFk = false;
        }
    }

    public void biG() {
        if (this.mUri != null) {
            try {
                if (eFx != null) {
                    this.eFm = eFx.beS();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.eFm.forceUseSystemMediaPlayer(true);
                    }
                }
                this.eFm.setOnPreparedListener(this.eFz);
                this.eFm.a(this.eFC);
                this.eFm.setOnCompletionListener(this.eFA);
                this.eFm.setOnErrorListener(this.eFB);
                this.eFm.setOnSeekCompleteListener(this.eFD);
                this.eFn = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.eFk = false;
                this.eFB.onError(this.eFm, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.eFp = z;
        if (this.eFm != null) {
            this.eFm.setLooping(this.eFp);
        }
    }

    public void setMuted(boolean z) {
        if (this.eFm != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cdi = z;
            if (this.eFl != null && this.eFq) {
                this.eFl.setMute(this.cdi);
            }
        }
    }

    public boolean isMute() {
        return this.cdi;
    }

    public void setVolume(float f) {
        if (this.eFm != null) {
            this.eFm.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.eFq = z;
    }

    public void release() {
        beL();
        this.eFk = false;
        if (this.eFu != null) {
            this.eFu.release();
        }
        if (this.eFl != null) {
            this.eFl.setToggleScreenListener(null);
            this.eFl.o(null);
            this.eFl = null;
        }
        if (this.eFw != null) {
            this.eFw = null;
        }
    }

    private void beL() {
        if (this.eFm != null) {
            this.eFm.release();
            this.eFm = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.eFm != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.eFm.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.eFm.start();
                setCurrentState(3);
            }
            this.eFk = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.eFm.isPlaying()) {
            this.eFm.pause();
            setCurrentState(4);
        }
        this.eFk = false;
    }

    public int getBufferPercentage() {
        if (this.eFm != null) {
            return this.eFn;
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
            return this.eFm.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.eFm.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.eFm.getDuration()) {
                i = this.eFm.getDuration() - 1000;
            }
            this.eFm.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.eFm.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.eFm == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.eFm.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.eFm.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.eFj = 0;
            } else if (i == 2) {
                this.eFj = 1;
            } else {
                this.eFj = 3;
            }
            if (this.eFu != null) {
                this.eFu.setAspectRatio(this.eFj);
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
        if (this.eFu != null) {
            return this.eFu.getBitmap();
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
