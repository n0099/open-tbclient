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
    private static h efm;
    private static l efn;
    private boolean bEi;
    private int eeY;
    private boolean eeZ;
    private MediaController efa;
    private g efb;
    private int efc;
    private long efd;
    private boolean efe;
    private boolean eff;
    private RelativeLayout efg;
    private ProgressBar efh;
    private TextView efi;
    private a efj;
    private FrameLayout efk;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a efl;
    g.f efo;
    private g.a efp;
    private g.b efq;
    private g.e efr;
    private g.InterfaceC0590g efs;
    a.InterfaceC0417a eft;
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
        this.efd = -1L;
        this.eff = true;
        this.eeY = 0;
        this.efo = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.efj != null) {
                    SwanVideoView.this.efj.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.efj.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeZ) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efp = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeZ = false;
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onEnd();
                }
            }
        };
        this.efq = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeZ = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.g(i, i2, null);
                }
                return SwanVideoView.this.efl != null;
            }
        };
        this.efr = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.a(SwanVideoView.this);
                }
                return SwanVideoView.this.efl != null;
            }
        };
        this.efs = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onSeekEnd();
                }
            }
        };
        this.eft = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bav() == SwanVideoView.this.efj && SwanVideoView.this.efb != null) {
                    SwanVideoView.this.a(SwanVideoView.this.efb, bVar);
                    SwanVideoView.this.efb.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.baw(), SwanVideoView.this.mUri.getHost(), false);
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
        this.efd = -1L;
        this.eff = true;
        this.eeY = 0;
        this.efo = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.efj != null) {
                    SwanVideoView.this.efj.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.efj.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeZ) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efp = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeZ = false;
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onEnd();
                }
            }
        };
        this.efq = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeZ = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.g(i, i2, null);
                }
                return SwanVideoView.this.efl != null;
            }
        };
        this.efr = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.a(SwanVideoView.this);
                }
                return SwanVideoView.this.efl != null;
            }
        };
        this.efs = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onSeekEnd();
                }
            }
        };
        this.eft = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.bav() == SwanVideoView.this.efj && SwanVideoView.this.efb != null) {
                    SwanVideoView.this.a(SwanVideoView.this.efb, bVar);
                    SwanVideoView.this.efb.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.baw(), SwanVideoView.this.mUri.getHost(), false);
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
        this.efd = -1L;
        this.eff = true;
        this.eeY = 0;
        this.efo = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onPrepared();
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.efj != null) {
                    SwanVideoView.this.efj.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.efj.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.eeZ) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.efp = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.eeZ = false;
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onEnd();
                }
            }
        };
        this.efq = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.eeZ = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.g(i2, i22, null);
                }
                return SwanVideoView.this.efl != null;
            }
        };
        this.efr = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.a(SwanVideoView.this);
                }
                return SwanVideoView.this.efl != null;
            }
        };
        this.efs = new g.InterfaceC0590g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.efl != null) {
                    SwanVideoView.this.efl.onSeekEnd();
                }
            }
        };
        this.eft = new a.InterfaceC0417a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0417a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.bav() == SwanVideoView.this.efj && SwanVideoView.this.efb != null) {
                    SwanVideoView.this.a(SwanVideoView.this.efb, bVar);
                    SwanVideoView.this.efb.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.mHeaders, bVar.baw(), SwanVideoView.this.mUri.getHost(), false);
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
            efm = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask2 != null) {
            efn = (l) runTask2.getData();
        }
    }

    private void eA(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.efk = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.efk.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.efk, layoutParams);
        this.efa = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.efa.setVisibility(8);
        addView(this.efa, layoutParams2);
        this.efa.o(this);
        baA();
        baz();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.eff) {
                    if (SwanVideoView.this.efa.getVisibility() != 0) {
                        SwanVideoView.this.efa.baG();
                    } else {
                        SwanVideoView.this.efa.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.efb.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void baz() {
        this.efg = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.efg.setVisibility(8);
        addView(this.efg, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.efh = new ProgressBar(getContext());
        this.efh.setId(16908308);
        this.efh.setMax(100);
        this.efh.setProgress(10);
        this.efh.setSecondaryProgress(100);
        this.efg.addView(this.efh, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.efi = new TextView(getContext());
        this.efi.setTextColor(-1);
        this.efi.setText(R.string.laoding);
        this.efi.setGravity(1);
        this.efg.addView(this.efi, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.efl = aVar;
        if (this.efa != null) {
            this.efa.setToggleScreenListener(aVar);
        }
    }

    public void cJ(boolean z) {
        if (this.efb != null) {
            float f = z ? 0.0f : 1.0f;
            this.efb.setVolume(f, f);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.efa != null) {
                this.efa.baD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.efg.setVisibility(0);
        } else {
            this.efg.setVisibility(8);
        }
    }

    private void baA() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.efj != null) {
            if (this.efb != null) {
            }
            View view = this.efj.getView();
            this.efj.b(this.eft);
            this.efj.release();
            this.efj = null;
            this.efk.removeView(view);
        }
        if (aVar != null) {
            this.efj = aVar;
            aVar.setAspectRatio(this.eeY);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.efj.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.efk.addView(view2);
            this.efj.a(this.eft);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        baB();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void stopPlayback() {
        if (this.efb != null) {
            this.efb.pause();
            aWD();
            this.eeZ = false;
        }
    }

    public void baB() {
        if (this.mUri != null) {
            try {
                if (efm != null) {
                    this.efb = efm.aWK();
                    if ("https".equals(this.mUri.getScheme())) {
                        this.efb.forceUseSystemMediaPlayer(true);
                    }
                }
                this.efb.setOnPreparedListener(this.efo);
                this.efb.a(this.efr);
                this.efb.setOnCompletionListener(this.efp);
                this.efb.setOnErrorListener(this.efq);
                this.efb.setOnSeekCompleteListener(this.efs);
                this.efc = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.eeZ = false;
                this.efq.onError(this.efb, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.efe = z;
        if (this.efb != null) {
            this.efb.setLooping(this.efe);
        }
    }

    public void setMuted(boolean z) {
        if (this.efb != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.bEi = z;
            if (this.efa != null && this.eff) {
                this.efa.setMute(this.bEi);
            }
        }
    }

    public boolean isMute() {
        return this.bEi;
    }

    public void setVolume(float f) {
        if (this.efb != null) {
            this.efb.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.eff = z;
    }

    public void release() {
        aWD();
        this.eeZ = false;
        if (this.efj != null) {
            this.efj.release();
        }
        if (this.efa != null) {
            this.efa.setToggleScreenListener(null);
            this.efa.o(null);
            this.efa = null;
        }
        if (this.efl != null) {
            this.efl = null;
        }
    }

    private void aWD() {
        if (this.efb != null) {
            this.efb.release();
            this.efb = null;
            setCurrentState(0);
        }
    }

    public void start() {
        if (this.efb != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.efb.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.efb.start();
                setCurrentState(3);
            }
            this.eeZ = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.efb.isPlaying()) {
            this.efb.pause();
            setCurrentState(4);
        }
        this.eeZ = false;
    }

    public int getBufferPercentage() {
        if (this.efb != null) {
            return this.efc;
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
            return this.efb.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.efb.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.efb.getDuration()) {
                i = this.efb.getDuration() - 1000;
            }
            this.efb.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.efb.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.efb == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.efb.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.efb.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.eeY = 0;
            } else if (i == 2) {
                this.eeY = 1;
            } else {
                this.eeY = 3;
            }
            if (this.efj != null) {
                this.efj.setAspectRatio(this.eeY);
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
        if (this.efj != null) {
            return this.efj.getBitmap();
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
