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
    private c cde;
    private int eAv;
    private SwanVideoView eEQ;
    private VideoContainerManager eER;
    private boolean eES;
    private boolean eET;
    private FrameLayout eEU;
    private l.d eEV;
    private l.b eEW;
    private l.a eEX;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsPaused;
    private boolean mIsForeground = true;
    private int eEY = 0;

    @Override // com.baidu.swan.apps.w.b.l
    public void PD() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void PF() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.w.b.l
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.cde = cVar;
        bir();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.eEV = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.eEW = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.eEX = aVar;
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
        biq().setVideoPath(this.cde.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eEU = frameLayout;
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
        this.cde = cVar;
        if (z) {
            iF(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.cde == null) {
            return false;
        }
        return (this.cde.cdi == cVar.cdi && this.cde.cdr == cVar.cdr && TextUtils.equals(this.cde.cdm, cVar.cdm) && this.cde.cdz == cVar.cdz && this.cde.cdw == cVar.cdw && this.cde.cdx == cVar.cdx && this.cde.cdy == cVar.cdy && this.cde.mDirection == cVar.mDirection && this.cde.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(c cVar) {
        biq().setMuted(cVar.cdi);
        biq().setMediaControllerEnabled(cVar.cdr);
        biq().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.cdm, "cover")) {
            biq().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.cdm, "fill")) {
            biq().setVideoScalingMode(3);
        } else {
            biq().setVideoScalingMode(1);
        }
    }

    private void iF(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eEQ != null && !z && isPlaying()) {
            this.eEQ.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bYY);
        i(cVar);
        this.cde = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bim();
        bin();
        bir().cY(cVar.cdj, cVar.cdm);
    }

    public void h(c cVar) {
        bir().j(cVar);
        bip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bik() {
        final Activity activity;
        e akM = e.akM();
        if (akM == null || (activity = akM.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ae(activity);
                SwanAppComponentContainerView biw = a.this.bir().biw();
                biw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(biw);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, biw);
                b.a(a.this.cde.bYY, a.this.cde.bGO, true, a.this.bir());
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
    public boolean bil() {
        Activity activity;
        e akM = e.akM();
        if (akM == null || (activity = akM.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(a.this.bir().biw());
                a.this.bir().Sv();
                b.a(a.this.cde.bYY, a.this.cde.bGO, false, a.this.bir());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.cde != null && cVar != null && !TextUtils.isEmpty(this.cde.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.cde.mSrc, cVar.mSrc)) {
            this.eES = true;
        } else {
            this.eES = false;
        }
    }

    private void bim() {
        if (this.eEQ != null) {
            this.eEQ.stopPlayback();
        }
    }

    private void bin() {
        bir().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (ago()) {
            bir().biu();
            reset();
            biq().biG();
            g(this.cde);
            a(this.cde, false);
            e(this.cde);
            biq().start();
            this.eES = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        biq().pause();
        this.mIsPaused = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.mIsPaused && !this.eES) {
            biq().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (ago()) {
            if (!this.eES) {
                biq().seekTo(i);
            } else {
                this.eAv = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return biq().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return biq().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.eET;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void g(boolean z, int i) {
        if (z) {
            bik();
        } else {
            bil();
        }
    }

    private void initListener() {
        biq().setVideoPlayerCallback(new C0468a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bio() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.eEQ == null) {
            return false;
        }
        return this.eEQ.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && bil();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void adc() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void jv(String str) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(c cVar) {
    }

    private void bip() {
        if (this.eEQ != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(this.eEQ);
            if (this.eEU != null) {
                this.eEU.addView(this.eEQ);
            } else {
                bir().getVideoHolder().addView(this.eEQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView biq() {
        if (this.eEQ == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eEQ = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eEQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bir() {
        if (this.cde == null) {
            com.baidu.swan.apps.component.e.a.aC("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eER == null) {
            this.eER = new VideoContainerManager(this.mContext, this.cde);
        }
        return this.eER;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void dG(boolean z) {
        biq().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void dH(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        biq().release();
    }

    public void reset() {
        if (this.eEQ != null) {
            this.eEQ.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bt(this.eEQ);
            this.eEQ = null;
        }
    }

    private boolean ago() {
        return (this.cde == null || TextUtils.isEmpty(this.cde.mSrc) || TextUtils.isEmpty(this.cde.bYY) || TextUtils.isEmpty(this.cde.bGN)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bis() {
        if (ago()) {
            if (this.eAv != 0) {
                biq().seekTo(this.eAv);
                this.eAv = 0;
            } else if (this.cde.cdk != 0) {
                this.eEQ.seekTo(this.cde.cdk * 1000);
                this.cde.cdk = 0;
            } else if (this.eEY != 0) {
                this.eEQ.seekTo(this.eEY);
                this.eEY = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0468a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0468a() {
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onEnd() {
            a.this.mIsPaused = false;
            b.a(a.this.cde.bYY, a.this.cde.bGO, "ended", new JSONObject());
            if (a.this.eEX != null) {
                a.this.eEX.b(a.this);
            }
            a.this.eET = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void g(int i, int i2, String str) {
            a.this.mIsPaused = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bir().biu();
            a.this.bir().biv();
            b.a(a.this.cde.bYY, a.this.cde.bGO, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.oF(i2));
            if (a.this.eEW != null) {
                a.this.eEW.a(a.this, i, i2);
            }
            a.this.eET = false;
            int currentPosition = a.this.biq().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eEY;
            }
            aVar.eEY = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bis();
            a.this.bio();
            if (a.this.eEV != null) {
                a.this.eEV.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void iG(boolean z) {
            if (z) {
                a.this.bik();
            } else {
                a.this.bil();
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
            b.a(a.this.cde.bYY, a.this.cde.bGO, "waiting", new JSONObject());
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
            b.a(a.this.cde.bYY, a.this.cde.bGO, "timeupdate", jSONObject);
        }
    }
}
