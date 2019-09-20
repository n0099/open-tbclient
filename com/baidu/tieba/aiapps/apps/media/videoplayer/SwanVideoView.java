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
    private static h dii;
    private static l dij;
    private Map<String, String> FV;
    private boolean aDD;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a dhP;
    private int dhV;
    private boolean dhW;
    private MediaController dhX;
    private g dhY;
    private int dhZ;
    private long dia;
    private boolean dib;
    private boolean dic;
    private RelativeLayout did;
    private ProgressBar die;
    private TextView dif;
    private a dig;
    private FrameLayout dih;
    g.f dik;
    private g.a dil;
    private g.b dim;
    private g.e din;
    private g.InterfaceC0404g dio;
    a.InterfaceC0298a dip;
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
        this.dia = -1L;
        this.dic = true;
        this.dhV = 0;
        this.dik = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.onPrepared(SwanVideoView.this.dhY);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dig != null) {
                    SwanVideoView.this.dig.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dig.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dhW) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dil = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dhW = false;
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.onCompletion(SwanVideoView.this.dhY);
                }
            }
        };
        this.dim = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dhW = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dhP == null || SwanVideoView.this.dhP.onError(SwanVideoView.this.dhY, i, i2);
            }
        };
        this.din = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dhP != null && SwanVideoView.this.dhP.onInfo(gVar, i, i2);
            }
        };
        this.dio = new g.InterfaceC0404g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.b(gVar);
                }
            }
        };
        this.dip = new a.InterfaceC0298a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aHo() == SwanVideoView.this.dig && SwanVideoView.this.dhY != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dhY, bVar);
                    SwanVideoView.this.dhY.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar) {
            }
        };
        dy(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.dia = -1L;
        this.dic = true;
        this.dhV = 0;
        this.dik = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.onPrepared(SwanVideoView.this.dhY);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dig != null) {
                    SwanVideoView.this.dig.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dig.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dhW) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dil = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dhW = false;
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.onCompletion(SwanVideoView.this.dhY);
                }
            }
        };
        this.dim = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                Log.d("SwanVideoView", "onError: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dhW = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dhP == null || SwanVideoView.this.dhP.onError(SwanVideoView.this.dhY, i, i2);
            }
        };
        this.din = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                return SwanVideoView.this.dhP != null && SwanVideoView.this.dhP.onInfo(gVar, i, i2);
            }
        };
        this.dio = new g.InterfaceC0404g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.b(gVar);
                }
            }
        };
        this.dip = new a.InterfaceC0298a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar, int i, int i2, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar, int i, int i2) {
                if (bVar.aHo() == SwanVideoView.this.dig && SwanVideoView.this.dhY != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dhY, bVar);
                    SwanVideoView.this.dhY.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar) {
            }
        };
        dy(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.dia = -1L;
        this.dic = true;
        this.dhV = 0;
        this.dik = new g.f() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                SwanVideoView.this.setCurrentState(2);
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.onPrepared(SwanVideoView.this.dhY);
                }
                SwanVideoView.this.mVideoWidth = gVar.getVideoWidth();
                SwanVideoView.this.mVideoHeight = gVar.getVideoHeight();
                if (SwanVideoView.this.mVideoWidth != 0 && SwanVideoView.this.mVideoHeight != 0 && SwanVideoView.this.mVideoSarNum != 0 && SwanVideoView.this.mVideoSarDen != 0 && SwanVideoView.this.dig != null) {
                    SwanVideoView.this.dig.setVideoSize(SwanVideoView.this.mVideoWidth, SwanVideoView.this.mVideoHeight);
                    SwanVideoView.this.dig.setVideoSampleAspectRatio(SwanVideoView.this.mVideoSarNum, SwanVideoView.this.mVideoSarDen);
                }
                if (SwanVideoView.this.dhW) {
                    SwanVideoView.this.start();
                }
            }
        };
        this.dil = new g.a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                Log.d("SwanVideoView", "onCompletion");
                SwanVideoView.this.setCacheViewVisibility(false);
                SwanVideoView.this.setCurrentState(5);
                SwanVideoView.this.dhW = false;
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.onCompletion(SwanVideoView.this.dhY);
                }
            }
        };
        this.dim = new g.b() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                Log.d("SwanVideoView", "onError: " + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i22);
                SwanVideoView.this.setCurrentState(-1);
                SwanVideoView.this.dhW = false;
                SwanVideoView.this.setCacheViewVisibility(false);
                return SwanVideoView.this.dhP == null || SwanVideoView.this.dhP.onError(SwanVideoView.this.dhY, i2, i22);
            }
        };
        this.din = new g.e() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                return SwanVideoView.this.dhP != null && SwanVideoView.this.dhP.onInfo(gVar, i2, i22);
            }
        };
        this.dio = new g.InterfaceC0404g() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.6
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                Log.d("SwanVideoView", "onSeekComplete");
                SwanVideoView.this.setCacheViewVisibility(false);
                if (SwanVideoView.this.dhP != null) {
                    SwanVideoView.this.dhP.b(gVar);
                }
            }
        };
        this.dip = new a.InterfaceC0298a() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.7
            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar, int i2, int i22, int i3) {
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar, int i2, int i22) {
                if (bVar.aHo() == SwanVideoView.this.dig && SwanVideoView.this.dhY != null) {
                    SwanVideoView.this.a(SwanVideoView.this.dhY, bVar);
                    SwanVideoView.this.dhY.a(SwanVideoView.this.mAppContext, SwanVideoView.this.mUri, SwanVideoView.this.FV, SwanVideoView.this.mSurfaceTexture, SwanVideoView.this.mUri.getHost(), true);
                }
            }

            @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.InterfaceC0298a
            public void a(a.b bVar) {
            }
        };
        dy(context);
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            dii = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask2 != null) {
            dij = (l) runTask2.getData();
        }
    }

    private void dy(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.dih = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dih.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.dih, layoutParams);
        this.dhX = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.dhX.setVisibility(8);
        addView(this.dhX, layoutParams2);
        this.dhX.o(this);
        aHs();
        aHr();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanVideoView.this.dic) {
                    if (SwanVideoView.this.dhX.getVisibility() != 0) {
                        SwanVideoView.this.dhX.aHz();
                    } else {
                        SwanVideoView.this.dhX.hide();
                    }
                }
            }
        });
    }

    public void setSurface(SurfaceTexture surfaceTexture) {
        this.dhY.setSurface(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    private void aHr() {
        this.did = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.did.setVisibility(8);
        addView(this.did, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.die = new ProgressBar(getContext());
        this.die.setId(16908308);
        this.die.setMax(100);
        this.die.setProgress(10);
        this.die.setSecondaryProgress(100);
        this.did.addView(this.die, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        this.dif = new TextView(getContext());
        this.dif.setTextColor(-1);
        this.dif.setText(R.string.laoding);
        this.dif.setGravity(1);
        this.did.addView(this.dif, layoutParams3);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.dhP = aVar;
        if (this.dhX != null) {
            this.dhX.setToggleScreenListener(aVar);
        }
    }

    public int getCurrentPlayerState() {
        return this.mCurrentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.mCurrentState != i) {
            this.mCurrentState = i;
            if (this.dhX != null) {
                this.dhX.aHw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.did.setVisibility(0);
        } else {
            this.did.setVisibility(8);
        }
    }

    private void aHs() {
        setRenderView(new TextureRenderView(getContext()));
    }

    protected void setRenderView(a aVar) {
        if (this.dig != null) {
            if (this.dhY != null) {
            }
            View view = this.dig.getView();
            this.dig.b(this.dip);
            this.dig.release();
            this.dig = null;
            this.dih.removeView(view);
        }
        if (aVar != null) {
            this.dig = aVar;
            aVar.setAspectRatio(this.dhV);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aVar.setVideoSize(this.mVideoWidth, this.mVideoHeight);
            }
            if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            }
            aVar.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            View view2 = this.dig.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.dih.addView(view2);
            this.dig.a(this.dip);
        }
    }

    public void setVideoPath(String str) {
        this.mUri = Uri.parse(str);
        aHt();
        requestLayout();
        invalidate();
    }

    public void setHeaders(Map<String, String> map) {
        this.FV = map;
    }

    private void aHt() {
        if (this.mUri != null) {
            try {
                if (dii != null) {
                    this.dhY = dii.aBW();
                }
                this.dhY.setOnPreparedListener(this.dik);
                this.dhY.a(this.din);
                this.dhY.setOnCompletionListener(this.dil);
                this.dhY.setOnErrorListener(this.dim);
                this.dhY.setOnSeekCompleteListener(this.dio);
                this.dhZ = 0;
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IllegalArgumentException e) {
                setCurrentState(-1);
                this.dhW = false;
                this.dim.onError(this.dhY, 1, 0);
            }
        }
    }

    public void setLooping(boolean z) {
        this.dib = z;
        if (this.dhY != null) {
            this.dhY.setLooping(this.dib);
        }
    }

    public void setMuted(boolean z) {
        if (this.dhY != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.aDD = z;
            if (this.dhX != null && this.dic) {
                this.dhX.setMute(this.aDD);
            }
        }
    }

    public boolean isMute() {
        return this.aDD;
    }

    public void setVolume(float f) {
        if (this.dhY != null) {
            this.dhY.setVolume(f, f);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.dic = z;
    }

    public void start() {
        if (this.dhY != null) {
            if (this.mCurrentState == -1 || this.mCurrentState == 5) {
                if (this.mCurrentState == 5) {
                    this.dhY.pause();
                }
                setCacheViewVisibility(true);
                setCurrentState(1);
            } else if (isInPlaybackState()) {
                this.dhY.start();
                setCurrentState(3);
            }
            this.dhW = true;
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.dhY.isPlaying()) {
            this.dhY.pause();
            setCurrentState(4);
        }
        this.dhW = false;
    }

    public int getBufferPercentage() {
        if (this.dhY != null) {
            return this.dhZ;
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
            return this.dhY.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.dhY.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= this.dhY.getDuration()) {
                i = this.dhY.getDuration() + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            }
            this.dhY.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.dhY.isPlaying();
    }

    private boolean isInPlaybackState() {
        return (this.dhY == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public int getVideoWidth() {
        return this.dhY.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.dhY.getVideoHeight();
    }

    public void setVideoScalingMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            if (i == 1) {
                this.dhV = 0;
            } else if (i == 2) {
                this.dhV = 1;
            } else {
                this.dhV = 3;
            }
            if (this.dig != null) {
                this.dig.setAspectRatio(this.dhV);
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
        if (this.dig != null) {
            return this.dig.getBitmap();
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
