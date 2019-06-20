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
    private static h deN;
    private static l deO;
    private Map<String, String> FN;
    private boolean aCx;
    private int deA;
    private boolean deB;
    private MediaController deC;
    private g deD;
    private int deE;
    private long deF;
    private boolean deG;
    private boolean deH;
    private RelativeLayout deI;
    private ProgressBar deJ;
    private TextView deK;
    private a deL;
    private FrameLayout deM;
    g.f deP;
    private g.a deQ;
    private g.b deR;
    private g.e deS;
    private g.InterfaceC0388g deT;
    a.InterfaceC0286a deU;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a deu;
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
        this.deF = -1L;
        this.deH = true;
        this.deA = 0;
        this.deP = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.onPrepared(SwanVideoView.this.deD);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deL != null) {
                    SwanVideoView.this.deL.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deL.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.deB) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deQ = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.deB = false;
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.onCompletion(SwanVideoView.this.deD);
                }
            }
        };
        this.deR = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.deB = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.deu == null || SwanVideoView.this.deu.onError(SwanVideoView.this.deD, i, i2);
            }
        };
        this.deS = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.deu != null && SwanVideoView.this.deu.onInfo(gVar, i, i2);
            }
        };
        this.deT = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.b(gVar);
                }
            }
        };
        this.deU = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aFo() == SwanVideoView.this.deL && SwanVideoView.this.deD != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deD, bVar);
                    SwanVideoView.this.deD.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FN, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
        this.deF = -1L;
        this.deH = true;
        this.deA = 0;
        this.deP = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.onPrepared(SwanVideoView.this.deD);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deL != null) {
                    SwanVideoView.this.deL.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deL.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.deB) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deQ = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.deB = false;
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.onCompletion(SwanVideoView.this.deD);
                }
            }
        };
        this.deR = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.deB = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.deu == null || SwanVideoView.this.deu.onError(SwanVideoView.this.deD, i, i2);
            }
        };
        this.deS = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.deu != null && SwanVideoView.this.deu.onInfo(gVar, i, i2);
            }
        };
        this.deT = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.b(gVar);
                }
            }
        };
        this.deU = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aFo() == SwanVideoView.this.deL && SwanVideoView.this.deD != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deD, bVar);
                    SwanVideoView.this.deD.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FN, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
        this.deF = -1L;
        this.deH = true;
        this.deA = 0;
        this.deP = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.onPrepared(SwanVideoView.this.deD);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.deL != null) {
                    SwanVideoView.this.deL.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.deL.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.deB) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.deQ = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.deB = false;
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.onCompletion(SwanVideoView.this.deD);
                }
            }
        };
        this.deR = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.deB = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.deu == null || SwanVideoView.this.deu.onError(SwanVideoView.this.deD, i2, i22);
            }
        };
        this.deS = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.deu != null && SwanVideoView.this.deu.onInfo(gVar, i2, i22);
            }
        };
        this.deT = new g.InterfaceC0388g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.deu != null) {
                    SwanVideoView.this.deu.b(gVar);
                }
            }
        };
        this.deU = new a.InterfaceC0286a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0286a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aFo() == SwanVideoView.this.deL && SwanVideoView.this.deD != null) {
                    SwanVideoView.this.a(SwanVideoView.this.deD, bVar);
                    SwanVideoView.this.deD.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FN, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
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
            deN = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask2 != null) {
            deO = (l) runTask2.getData();
        }
    }

    private void dw(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.deM = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.deM.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.deM, layoutParams);
        this.deC = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.deC.setVisibility(8);
        addView(this.deC, layoutParams2);
        this.deC.o(this);
        aFq();
        aFp();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.deH) {
                    if (SwanVideoView.this.deC.getVisibility() != 0) {
                        SwanVideoView.this.deC.aFx();
                    } else {
                        SwanVideoView.this.deC.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.deD.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aFp() {
        this.deI = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.deI.setVisibility(8);
        addView(this.deI, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.deJ = new ProgressBar(getContext());
        this.deJ.setId(16908308);
        this.deJ.setMax(100);
        this.deJ.setProgress(10);
        this.deJ.setSecondaryProgress(100);
        this.deI.addView(this.deJ, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.deK = new TextView(getContext());
        this.deK.setTextColor(-1);
        this.deK.setText(R.string.laoding);
        this.deK.setGravity(1);
        this.deI.addView(this.deK, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.deu = aVar;
        if (this.deC != null) {
            this.deC.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.deC != null) {
                this.deC.aFu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.deI.setVisibility(0);
        } else {
            this.deI.setVisibility(8);
        }
    }

    private void aFq() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.deL != null) {
            if (this.deD != null) {
            }
            View view = this.deL.getView();
            this.deL.b(this.deU);
            this.deL.release();
            this.deL = null;
            this.deM.removeView(view);
        }
        if (aVar != null) {
            this.deL = aVar;
            aVar.setAspectRatio(this.deA);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.deL.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.deM.addView(view2);
            this.deL.a(this.deU);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aFr();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.FN = map;
    }

    private void aFr() {
        if (this.mUri != null) {
            try {
                if (deN != null) {
                    this.deD = deN.aAr();
                }
                this.deD.setOnPreparedListener(this.deP);
                this.deD.a(this.deS);
                this.deD.setOnCompletionListener(this.deQ);
                this.deD.setOnErrorListener(this.deR);
                this.deD.setOnSeekCompleteListener(this.deT);
                this.deE = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.deB = false;
                this.deR.onError(this.deD, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.deG = z;
        if (this.deD != null) {
            this.deD.setLooping(this.deG);
        }
    }

    public void setMuted(boolean z) {
        if (this.deD != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aCx = z;
            if (this.deC != null && this.deH) {
                this.deC.setMute(this.aCx);
            }
        }
    }

    public boolean isMute() {
        return this.aCx;
    }

    public void setVolume(float f) {
        if (this.deD != null) {
            this.deD.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.deH = z;
    }

    public void start() {
        if (this.deD != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.deD.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.deD.start();
                setCurrentState(3);
            }
            this.deB = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.deD.isPlaying()) {
            this.deD.pause();
            setCurrentState(4);
        }
        this.deB = false;
    }

    public int getBufferPercentage() {
        if (this.deD != null) {
            return this.deE;
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
            return this.deD.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.deD.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.deD.getDuration()) {
                i = this.deD.getDuration() + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            }
            this.deD.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.deD.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.deD == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.deD.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.deD.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.deA = 0;
            } else if (i == 2) {
                this.deA = 1;
            } else {
                this.deA = 3;
            }
            if (this.deL != null) {
                this.deL.setAspectRatio(this.deA);
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
        if (this.deL != null) {
            return this.deL.getBitmap();
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
