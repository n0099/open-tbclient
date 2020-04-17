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
    private static h eFs;
    private static l eFt;
    private boolean cdc;
    private int eFe;
    private boolean eFf;
    private MediaController eFg;
    private g eFh;
    private int eFi;
    private long eFj;
    private boolean eFk;
    private boolean eFl;
    private RelativeLayout eFm;
    private ProgressBar eFn;
    private TextView eFo;
    private a eFp;
    private FrameLayout eFq;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a eFr;
    g.f eFu;
    private g.a eFv;
    private g.b eFw;
    private g.e eFx;
    private g.InterfaceC0630g eFy;
    a.InterfaceC0448a eFz;
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
        this.eFj = -1L;
        this.eFl = true;
        this.eFe = 0;
        this.eFu = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eFp != null) {
                    SwanVideoView.this.eFp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eFp.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eFf) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eFv = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eFf = false;
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onEnd();
                }
            }
        };
        this.eFw = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eFf = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.g(i, i2, null);
                }
                return SwanVideoView.this.eFr != null;
            }
        };
        this.eFx = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eFr != null;
            }
        };
        this.eFy = new g.InterfaceC0630g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onSeekEnd();
                }
            }
        };
        this.eFz = new a.InterfaceC0448a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.biC() == SwanVideoView.this.eFp && SwanVideoView.this.eFh != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eFh, bVar);
                    SwanVideoView.this.eFh.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.biD(), SwanVideoView.this.mUri.getHost());
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar) {
            }
        };
        el(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.eFj = -1L;
        this.eFl = true;
        this.eFe = 0;
        this.eFu = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eFp != null) {
                    SwanVideoView.this.eFp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eFp.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eFf) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eFv = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eFf = false;
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onEnd();
                }
            }
        };
        this.eFw = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eFf = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.g(i, i2, null);
                }
                return SwanVideoView.this.eFr != null;
            }
        };
        this.eFx = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eFr != null;
            }
        };
        this.eFy = new g.InterfaceC0630g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onSeekEnd();
                }
            }
        };
        this.eFz = new a.InterfaceC0448a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.biC() == SwanVideoView.this.eFp && SwanVideoView.this.eFh != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eFh, bVar);
                    SwanVideoView.this.eFh.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.biD(), SwanVideoView.this.mUri.getHost());
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar) {
            }
        };
        el(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.eFj = -1L;
        this.eFl = true;
        this.eFe = 0;
        this.eFu = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eFp != null) {
                    SwanVideoView.this.eFp.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eFp.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eFf) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eFv = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eFf = false;
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onEnd();
                }
            }
        };
        this.eFw = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eFf = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.g(i2, i22, null);
                }
                return SwanVideoView.this.eFr != null;
            }
        };
        this.eFx = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eFr != null;
            }
        };
        this.eFy = new g.InterfaceC0630g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eFr != null) {
                    SwanVideoView.this.eFr.onSeekEnd();
                }
            }
        };
        this.eFz = new a.InterfaceC0448a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.biC() == SwanVideoView.this.eFp && SwanVideoView.this.eFh != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eFh, bVar);
                    SwanVideoView.this.eFh.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.biD(), SwanVideoView.this.mUri.getHost());
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0448a
            public void a(a.b bVar) {
            }
        };
        el(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            eFs = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            eFt = (l) runTask2.getData();
        }
    }

    private void el(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eFq = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eFq.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eFq, layoutParams);
        this.eFg = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eFg.setVisibility(8);
        addView(this.eFg, layoutParams2);
        this.eFg.o(this);
        biH();
        biG();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.eFl) {
                    if (SwanVideoView.this.eFg.getVisibility() != 0) {
                        SwanVideoView.this.eFg.biN();
                    } else {
                        SwanVideoView.this.eFg.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.eFh.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void biG() {
        this.eFm = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eFm.setVisibility(8);
        addView(this.eFm, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eFn = new ProgressBar(getContext());
        this.eFn.setId(16908308);
        this.eFn.setMax(100);
        this.eFn.setProgress(10);
        this.eFn.setSecondaryProgress(100);
        this.eFm.addView(this.eFn, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eFo = new TextView(getContext());
        this.eFo.setTextColor(-1);
        this.eFo.setText(R.string.laoding);
        this.eFo.setGravity(1);
        this.eFm.addView(this.eFo, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.eFr = aVar;
        if (this.eFg != null) {
            this.eFg.setToggleScreenListener(aVar);
        }
    }

    public void dG(boolean z) {
        if (this.eFh != null) {
            float f = z ? 0.0f : 1.0f;
            this.eFh.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.eFg != null) {
                this.eFg.biK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eFm.setVisibility(0);
        } else {
            this.eFm.setVisibility(8);
        }
    }

    private void biH() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eFp != null) {
            if (this.eFh != null) {
            }
            View view = this.eFp.getView();
            this.eFp.b(this.eFz);
            this.eFp.release();
            this.eFp = null;
            this.eFq.removeView(view);
        }
        if (aVar != null) {
            this.eFp = aVar;
            aVar.setAspectRatio(this.eFe);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.eFp.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eFq.addView(view2);
            this.eFp.a(this.eFz);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        biI();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.eFh != null) {
            this.eFh.pause();
            beN();
            this.eFf = false;
        }
    }

    public void biI() {
        if (this.mUri != null) {
            try {
                if (eFs != null) {
                    this.eFh = eFs.beU();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.eFh.forceUseSystemMediaPlayer(true);
                    }
                }
                this.eFh.setOnPreparedListener(this.eFu);
                this.eFh.a(this.eFx);
                this.eFh.setOnCompletionListener(this.eFv);
                this.eFh.setOnErrorListener(this.eFw);
                this.eFh.setOnSeekCompleteListener(this.eFy);
                this.eFi = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.eFf = false;
                this.eFw.onError(this.eFh, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.eFk = z;
        if (this.eFh != null) {
            this.eFh.setLooping(this.eFk);
        }
    }

    public void setMuted(boolean z) {
        if (this.eFh != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.cdc = z;
            if (this.eFg != null && this.eFl) {
                this.eFg.setMute(this.cdc);
            }
        }
    }

    public boolean isMute() {
        return this.cdc;
    }

    public void setVolume(float f) {
        if (this.eFh != null) {
            this.eFh.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.eFl = z;
    }

    public void release() {
        beN();
        this.eFf = false;
        if (this.eFp != null) {
            this.eFp.release();
        }
        if (this.eFg != null) {
            this.eFg.setToggleScreenListener(null);
            this.eFg.o(null);
            this.eFg = null;
        }
        if (this.eFr != null) {
            this.eFr = null;
        }
    }

    private void beN() {
        if (this.eFh != null) {
            this.eFh.release();
            this.eFh = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.eFh != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.eFh.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.eFh.start();
                setCurrentState(3);
            }
            this.eFf = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.eFh.isPlaying()) {
            this.eFh.pause();
            setCurrentState(4);
        }
        this.eFf = false;
    }

    public int getBufferPercentage() {
        if (this.eFh != null) {
            return this.eFi;
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
            return this.eFh.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.eFh.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.eFh.getDuration()) {
                i = this.eFh.getDuration() - 1000;
            }
            this.eFh.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.eFh.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.eFh == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.eFh.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.eFh.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.eFe = 0;
            } else if (i == 2) {
                this.eFe = 1;
            } else {
                this.eFe = 3;
            }
            if (this.eFp != null) {
                this.eFp.setAspectRatio(this.eFe);
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
        if (this.eFp != null) {
            return this.eFp.getBitmap();
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
