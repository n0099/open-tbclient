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
/* loaded from: classes10.dex */
public class SwanVideoView extends FrameLayout {
    private static h eaV;
    private static l eaW;
    private boolean bAa;
    private int eaH;
    private boolean eaI;
    private MediaController eaJ;
    private g eaK;
    private int eaL;
    private long eaM;
    private boolean eaN;
    private boolean eaO;
    private RelativeLayout eaP;
    private ProgressBar eaQ;
    private TextView eaR;
    private a eaS;
    private FrameLayout eaT;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a eaU;
    g.f eaX;
    private g.a eaY;
    private g.b eaZ;
    private g.e eba;
    private g.InterfaceC0582g ebb;
    a.InterfaceC0406a ebc;
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
        this.eaM = -1L;
        this.eaO = true;
        this.eaH = 0;
        this.eaX = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eaS != null) {
                    SwanVideoView.this.eaS.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eaS.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eaI) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eaI = false;
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onEnd();
                }
            }
        };
        this.eaZ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eaI = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.g(i, i2, null);
                }
                return SwanVideoView.this.eaU != null;
            }
        };
        this.eba = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eaU != null;
            }
        };
        this.ebb = new g.InterfaceC0582g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onSeekEnd();
                }
            }
        };
        this.ebc = new a.InterfaceC0406a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aYd() == SwanVideoView.this.eaS && SwanVideoView.this.eaK != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eaK, bVar);
                    SwanVideoView.this.eaK.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.aYe(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar) {
            }
        };
        ex(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.eaM = -1L;
        this.eaO = true;
        this.eaH = 0;
        this.eaX = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eaS != null) {
                    SwanVideoView.this.eaS.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eaS.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eaI) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eaI = false;
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onEnd();
                }
            }
        };
        this.eaZ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eaI = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.g(i, i2, null);
                }
                return SwanVideoView.this.eaU != null;
            }
        };
        this.eba = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eaU != null;
            }
        };
        this.ebb = new g.InterfaceC0582g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onSeekEnd();
                }
            }
        };
        this.ebc = new a.InterfaceC0406a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aYd() == SwanVideoView.this.eaS && SwanVideoView.this.eaK != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eaK, bVar);
                    SwanVideoView.this.eaK.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.aYe(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar) {
            }
        };
        ex(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.eaM = -1L;
        this.eaO = true;
        this.eaH = 0;
        this.eaX = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.eaS != null) {
                    SwanVideoView.this.eaS.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.eaS.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eaI) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eaI = false;
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onEnd();
                }
            }
        };
        this.eaZ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eaI = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.g(i2, i22, null);
                }
                return SwanVideoView.this.eaU != null;
            }
        };
        this.eba = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.a(SwanVideoView.this);
                }
                return SwanVideoView.this.eaU != null;
            }
        };
        this.ebb = new g.InterfaceC0582g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.eaU != null) {
                    SwanVideoView.this.eaU.onSeekEnd();
                }
            }
        };
        this.ebc = new a.InterfaceC0406a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aYd() == SwanVideoView.this.eaS && SwanVideoView.this.eaK != null) {
                    SwanVideoView.this.a(SwanVideoView.this.eaK, bVar);
                    SwanVideoView.this.eaK.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.aYe(), SwanVideoView.this.mUri.getHost(), false);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0406a
            public void a(a.b bVar) {
            }
        };
        ex(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            eaV = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            eaW = (l) runTask2.getData();
        }
    }

    private void ex(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.eaT = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eaT.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.eaT, layoutParams);
        this.eaJ = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.eaJ.setVisibility(8);
        addView(this.eaJ, layoutParams2);
        this.eaJ.o(this);
        aYi();
        aYh();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.eaO) {
                    if (SwanVideoView.this.eaJ.getVisibility() != 0) {
                        SwanVideoView.this.eaJ.aYo();
                    } else {
                        SwanVideoView.this.eaJ.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.eaK.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aYh() {
        this.eaP = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eaP.setVisibility(8);
        addView(this.eaP, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.eaQ = new ProgressBar(getContext());
        this.eaQ.setId(16908308);
        this.eaQ.setMax(100);
        this.eaQ.setProgress(10);
        this.eaQ.setSecondaryProgress(100);
        this.eaP.addView(this.eaQ, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.eaR = new TextView(getContext());
        this.eaR.setTextColor(-1);
        this.eaR.setText(R.string.laoding);
        this.eaR.setGravity(1);
        this.eaP.addView(this.eaR, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.eaU = aVar;
        if (this.eaJ != null) {
            this.eaJ.setToggleScreenListener(aVar);
        }
    }

    public void cC(boolean z) {
        if (this.eaK != null) {
            float f = z ? 0.0f : 1.0f;
            this.eaK.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.eaJ != null) {
                this.eaJ.aYl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.eaP.setVisibility(0);
        } else {
            this.eaP.setVisibility(8);
        }
    }

    private void aYi() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.eaS != null) {
            if (this.eaK != null) {
            }
            View view = this.eaS.getView();
            this.eaS.b(this.ebc);
            this.eaS.release();
            this.eaS = null;
            this.eaT.removeView(view);
        }
        if (aVar != null) {
            this.eaS = aVar;
            aVar.setAspectRatio(this.eaH);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.eaS.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.eaT.addView(view2);
            this.eaS.a(this.ebc);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aYj();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.eaK != null) {
            this.eaK.pause();
            aUk();
            this.eaI = false;
        }
    }

    public void aYj() {
        if (this.mUri != null) {
            try {
                if (eaV != null) {
                    this.eaK = eaV.aUr();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.eaK.forceUseSystemMediaPlayer(true);
                    }
                }
                this.eaK.setOnPreparedListener(this.eaX);
                this.eaK.a(this.eba);
                this.eaK.setOnCompletionListener(this.eaY);
                this.eaK.setOnErrorListener(this.eaZ);
                this.eaK.setOnSeekCompleteListener(this.ebb);
                this.eaL = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.eaI = false;
                this.eaZ.onError(this.eaK, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.eaN = z;
        if (this.eaK != null) {
            this.eaK.setLooping(this.eaN);
        }
    }

    public void setMuted(boolean z) {
        if (this.eaK != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.bAa = z;
            if (this.eaJ != null && this.eaO) {
                this.eaJ.setMute(this.bAa);
            }
        }
    }

    public boolean isMute() {
        return this.bAa;
    }

    public void setVolume(float f) {
        if (this.eaK != null) {
            this.eaK.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.eaO = z;
    }

    public void release() {
        aUk();
        this.eaI = false;
        if (this.eaS != null) {
            this.eaS.release();
        }
        if (this.eaJ != null) {
            this.eaJ.setToggleScreenListener(null);
            this.eaJ.o(null);
            this.eaJ = null;
        }
        if (this.eaU != null) {
            this.eaU = null;
        }
    }

    private void aUk() {
        if (this.eaK != null) {
            this.eaK.release();
            this.eaK = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.eaK != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.eaK.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.eaK.start();
                setCurrentState(3);
            }
            this.eaI = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.eaK.isPlaying()) {
            this.eaK.pause();
            setCurrentState(4);
        }
        this.eaI = false;
    }

    public int getBufferPercentage() {
        if (this.eaK != null) {
            return this.eaL;
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
            return this.eaK.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.eaK.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.eaK.getDuration()) {
                i = this.eaK.getDuration() - 1000;
            }
            this.eaK.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.eaK.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.eaK == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.eaK.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.eaK.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.eaH = 0;
            } else if (i == 2) {
                this.eaH = 1;
            } else {
                this.eaH = 3;
            }
            if (this.eaS != null) {
                this.eaS.setAspectRatio(this.eaH);
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
        if (this.eaS != null) {
            return this.eaS.getBitmap();
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
