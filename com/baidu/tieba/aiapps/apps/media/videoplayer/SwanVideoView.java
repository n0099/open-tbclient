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
    private static h dqM;
    private static l dqN;
    private boolean aWA;
    private boolean dqA;
    private MediaController dqB;
    private g dqC;
    private int dqD;
    private long dqE;
    private boolean dqF;
    private boolean dqG;
    private RelativeLayout dqH;
    private ProgressBar dqI;
    private TextView dqJ;
    private a dqK;
    private FrameLayout dqL;
    g.f dqO;
    private g.a dqP;
    private g.b dqQ;
    private g.e dqR;
    private g.InterfaceC0493g dqS;
    a.InterfaceC0325a dqT;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a dqt;
    private int dqz;
    private Context mAppContext;
    private int mCurrentState;
    private SurfaceTexture mSurfaceTexture;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private Map<String, String> sG;

    public SwanVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.dqE = -1L;
        this.dqG = true;
        this.dqz = 0;
        this.dqO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.onPrepared(SwanVideoView.this.dqC);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dqK != null) {
                    SwanVideoView.this.dqK.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dqK.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dqA) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dqP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dqA = false;
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.onCompletion(SwanVideoView.this.dqC);
                }
            }
        };
        this.dqQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dqA = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dqt == null || SwanVideoView.this.dqt.onError(SwanVideoView.this.dqC, i, i2);
            }
        };
        this.dqR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dqt != null && SwanVideoView.this.dqt.onInfo(gVar, i, i2);
            }
        };
        this.dqS = new g.InterfaceC0493g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0493g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.b(gVar);
                }
            }
        };
        this.dqT = new a.InterfaceC0325a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aHz() == SwanVideoView.this.dqK && SwanVideoView.this.dqC != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dqC, bVar);
                    SwanVideoView.this.dqC.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.sG, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar) {
            }
        };
        dh(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.dqE = -1L;
        this.dqG = true;
        this.dqz = 0;
        this.dqO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.onPrepared(SwanVideoView.this.dqC);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dqK != null) {
                    SwanVideoView.this.dqK.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dqK.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dqA) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dqP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dqA = false;
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.onCompletion(SwanVideoView.this.dqC);
                }
            }
        };
        this.dqQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dqA = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dqt == null || SwanVideoView.this.dqt.onError(SwanVideoView.this.dqC, i, i2);
            }
        };
        this.dqR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dqt != null && SwanVideoView.this.dqt.onInfo(gVar, i, i2);
            }
        };
        this.dqS = new g.InterfaceC0493g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0493g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.b(gVar);
                }
            }
        };
        this.dqT = new a.InterfaceC0325a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aHz() == SwanVideoView.this.dqK && SwanVideoView.this.dqC != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dqC, bVar);
                    SwanVideoView.this.dqC.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.sG, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar) {
            }
        };
        dh(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.dqE = -1L;
        this.dqG = true;
        this.dqz = 0;
        this.dqO = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.onPrepared(SwanVideoView.this.dqC);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dqK != null) {
                    SwanVideoView.this.dqK.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dqK.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dqA) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dqP = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dqA = false;
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.onCompletion(SwanVideoView.this.dqC);
                }
            }
        };
        this.dqQ = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dqA = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dqt == null || SwanVideoView.this.dqt.onError(SwanVideoView.this.dqC, i2, i22);
            }
        };
        this.dqR = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.dqt != null && SwanVideoView.this.dqt.onInfo(gVar, i2, i22);
            }
        };
        this.dqS = new g.InterfaceC0493g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0493g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dqt != null) {
                    SwanVideoView.this.dqt.b(gVar);
                }
            }
        };
        this.dqT = new a.InterfaceC0325a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aHz() == SwanVideoView.this.dqK && SwanVideoView.this.dqC != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dqC, bVar);
                    SwanVideoView.this.dqC.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.sG, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0325a
            public void a(a.b bVar) {
            }
        };
        dh(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            dqM = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            dqN = (l) runTask2.getData();
        }
    }

    private void dh(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dqL = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dqL.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dqL, layoutParams);
        this.dqB = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dqB.setVisibility(8);
        addView(this.dqB, layoutParams2);
        this.dqB.o(this);
        aHD();
        aHC();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.dqG) {
                    if (SwanVideoView.this.dqB.getVisibility() != 0) {
                        SwanVideoView.this.dqB.aHK();
                    } else {
                        SwanVideoView.this.dqB.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.dqC.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aHC() {
        this.dqH = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dqH.setVisibility(8);
        addView(this.dqH, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.dqI = new ProgressBar(getContext());
        this.dqI.setId(16908308);
        this.dqI.setMax(100);
        this.dqI.setProgress(10);
        this.dqI.setSecondaryProgress(100);
        this.dqH.addView(this.dqI, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dqJ = new TextView(getContext());
        this.dqJ.setTextColor(-1);
        this.dqJ.setText(R.string.laoding);
        this.dqJ.setGravity(1);
        this.dqH.addView(this.dqJ, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.dqt = aVar;
        if (this.dqB != null) {
            this.dqB.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.dqB != null) {
                this.dqB.aHH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.dqH.setVisibility(0);
        } else {
            this.dqH.setVisibility(8);
        }
    }

    private void aHD() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dqK != null) {
            if (this.dqC != null) {
            }
            View view = this.dqK.getView();
            this.dqK.b(this.dqT);
            this.dqK.release();
            this.dqK = null;
            this.dqL.removeView(view);
        }
        if (aVar != null) {
            this.dqK = aVar;
            aVar.setAspectRatio(this.dqz);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.dqK.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dqL.addView(view2);
            this.dqK.a(this.dqT);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aHE();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.sG = map;
    }

    private void aHE() {
        if (this.mUri != null) {
            try {
                if (dqM != null) {
                    this.dqC = dqM.aCe();
                }
                this.dqC.setOnPreparedListener(this.dqO);
                this.dqC.a(this.dqR);
                this.dqC.setOnCompletionListener(this.dqP);
                this.dqC.setOnErrorListener(this.dqQ);
                this.dqC.setOnSeekCompleteListener(this.dqS);
                this.dqD = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.dqA = false;
                this.dqQ.onError(this.dqC, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.dqF = z;
        if (this.dqC != null) {
            this.dqC.setLooping(this.dqF);
        }
    }

    public void setMuted(boolean z) {
        if (this.dqC != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aWA = z;
            if (this.dqB != null && this.dqG) {
                this.dqB.setMute(this.aWA);
            }
        }
    }

    public boolean isMute() {
        return this.aWA;
    }

    public void setVolume(float f) {
        if (this.dqC != null) {
            this.dqC.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dqG = z;
    }

    public void start() {
        if (this.dqC != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.dqC.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.dqC.start();
                setCurrentState(3);
            }
            this.dqA = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.dqC.isPlaying()) {
            this.dqC.pause();
            setCurrentState(4);
        }
        this.dqA = false;
    }

    public int getBufferPercentage() {
        if (this.dqC != null) {
            return this.dqD;
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
            return this.dqC.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.dqC.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.dqC.getDuration()) {
                i = this.dqC.getDuration() - 1000;
            }
            this.dqC.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.dqC.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.dqC == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.dqC.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.dqC.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.dqz = 0;
            } else if (i == 2) {
                this.dqz = 1;
            } else {
                this.dqz = 3;
            }
            if (this.dqK != null) {
                this.dqK.setAspectRatio(this.dqz);
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
        if (this.dqK != null) {
            return this.dqK.getBitmap();
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
