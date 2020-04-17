package com.baidu.tieba.aiapps.apps.media.video;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.media.c.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.w.b.l;
import com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c ccY;
    private int eAq;
    private SwanVideoView eEL;
    private VideoContainerManager eEM;
    private boolean eEN;
    private boolean eEO;
    private FrameLayout eEP;
    private l.d eEQ;
    private l.b eER;
    private l.a eES;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eET = 0;

    @Override // com.baidu.swan.apps.w.b.l
    public void PE() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void PG() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.w.b.l
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.ccY = cVar;
        bit();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.eEQ = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.eER = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.eES = aVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.f fVar) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.c cVar) {
    }

    private void e(c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        bis().setVideoPath(this.ccY.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eEP = frameLayout;
    }

    private boolean isLandscape() {
        return this.mIsLandscape;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar, boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        com.baidu.swan.apps.console.c.d("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (f(cVar)) {
            g(cVar);
        }
        this.ccY = cVar;
        if (z) {
            iF(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.ccY == null) {
            return false;
        }
        return (this.ccY.cdc == cVar.cdc && this.ccY.cdk == cVar.cdk && TextUtils.equals(this.ccY.cdf, cVar.cdf) && this.ccY.cdt == cVar.cdt && this.ccY.cdq == cVar.cdq && this.ccY.cdr == cVar.cdr && this.ccY.cds == cVar.cds && this.ccY.mDirection == cVar.mDirection && this.ccY.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(c cVar) {
        bis().setMuted(cVar.cdc);
        bis().setMediaControllerEnabled(cVar.cdk);
        bis().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cdf, "cover")) {
            bis().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cdf, "fill")) {
            bis().setVideoScalingMode(3);
        } else {
            bis().setVideoScalingMode(1);
        }
    }

    private void iF(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eEL != null && !z && isPlaying()) {
            this.eEL.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bYS);
        i(cVar);
        this.ccY = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bio();
        bip();
        bit().cY(cVar.cdd, cVar.cdf);
    }

    public void h(c cVar) {
        bit().j(cVar);
        bir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bim() {
        final Activity activity;
        e akN = e.akN();
        if (akN == null || (activity = akN.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ae(activity);
                SwanAppComponentContainerView biy = a.this.bit().biy();
                biy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(biy);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, biy);
                b.a(a.this.ccY.bYS, a.this.ccY.bGJ, true, a.this.bit());
            }
        });
        this.mIsLandscape = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bin() {
        Activity activity;
        e akN = e.akN();
        if (akN == null || (activity = akN.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(a.this.bit().biy());
                a.this.bit().Sw();
                b.a(a.this.ccY.bYS, a.this.ccY.bGJ, false, a.this.bit());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.ccY != null && cVar != null && !TextUtils.isEmpty(this.ccY.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.ccY.mSrc, cVar.mSrc)) {
            this.eEN = true;
        } else {
            this.eEN = false;
        }
    }

    private void bio() {
        if (this.eEL != null) {
            this.eEL.stopPlayback();
        }
    }

    private void bip() {
        bit().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (agp()) {
            bit().biw();
            reset();
            bis().biI();
            g(this.ccY);
            a(this.ccY, false);
            e(this.ccY);
            bis().start();
            this.eEN = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        bis().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.mIsPaused && !this.eEN) {
            bis().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (agp()) {
            if (!this.eEN) {
                bis().seekTo(i);
            } else {
                this.eAq = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return bis().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return bis().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.eEO;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void g(boolean z, int i) {
        if (z) {
            bim();
        } else {
            bin();
        }
    }

    private void initListener() {
        bis().setVideoPlayerCallback(new C0447a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biq() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.eEL == null) {
            return false;
        }
        return this.eEL.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && bin();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void add() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void jv(String str) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(c cVar) {
    }

    private void bir() {
        if (this.eEL != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(this.eEL);
            if (this.eEP != null) {
                this.eEP.addView(this.eEL);
            } else {
                bit().getVideoHolder().addView(this.eEL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bis() {
        if (this.eEL == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eEL = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bit() {
        if (this.ccY == null) {
            com.baidu.swan.apps.component.e.a.aC("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eEM == null) {
            this.eEM = new VideoContainerManager(this.mContext, this.ccY);
        }
        return this.eEM;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void dG(boolean z) {
        bis().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void dH(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bis().release();
    }

    public void reset() {
        if (this.eEL != null) {
            this.eEL.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(this.eEL);
            this.eEL = null;
        }
    }

    private boolean agp() {
        return (this.ccY == null || TextUtils.isEmpty(this.ccY.mSrc) || TextUtils.isEmpty(this.ccY.bYS) || TextUtils.isEmpty(this.ccY.bGI)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biu() {
        if (agp()) {
            if (this.eAq != 0) {
                bis().seekTo(this.eAq);
                this.eAq = 0;
            } else if (this.ccY.cde != 0) {
                this.eEL.seekTo(this.ccY.cde * 1000);
                this.ccY.cde = 0;
            } else if (this.eET != 0) {
                this.eEL.seekTo(this.eET);
                this.eET = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0447a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0447a() {
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            b.a(a.this.ccY.bYS, a.this.ccY.bGJ, "ended", new JSONObject());
            if (a.this.eES != null) {
                a.this.eES.b(a.this);
            }
            a.this.eEO = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void g(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bit().biw();
            a.this.bit().bix();
            b.a(a.this.ccY.bYS, a.this.ccY.bGJ, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.oF(i2));
            if (a.this.eER != null) {
                a.this.eER.a(a.this, i, i2);
            }
            a.this.eEO = false;
            int currentPosition = a.this.bis().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eET;
            }
            aVar.eET = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.biu();
            a.this.biq();
            if (a.this.eEQ != null) {
                a.this.eEQ.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void iG(boolean z) {
            if (z) {
                a.this.bim();
            } else {
                a.this.bin();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition();
            int duration = swanVideoView.getDuration();
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                bg(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            b.a(a.this.ccY.bYS, a.this.ccY.bGJ, "waiting", new JSONObject());
        }

        private void bg(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            b.a(a.this.ccY.bYS, a.this.ccY.bGJ, "timeupdate", jSONObject);
        }
    }
}
