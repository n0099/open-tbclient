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
    private c bEd;
    private int eaa;
    private SwanVideoView eer;
    private VideoContainerManager ees;
    private boolean eet;
    private boolean eeu;
    private boolean eev;
    private FrameLayout eew;
    private l.d eex;
    private l.b eey;
    private l.a eez;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsForeground = true;
    private int eeA = 0;

    @Override // com.baidu.swan.apps.w.b.l
    public void HP() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void HR() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.w.b.l
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEd = cVar;
        bal();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.eex = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.eey = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.eez = aVar;
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
        bak().setVideoPath(this.bEd.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eew = frameLayout;
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
        this.bEd = cVar;
        if (z) {
            hG(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.bEd == null) {
            return false;
        }
        return (this.bEd.bEh == cVar.bEh && this.bEd.bEq == cVar.bEq && TextUtils.equals(this.bEd.bEk, cVar.bEk) && this.bEd.bEy == cVar.bEy && this.bEd.bEv == cVar.bEv && this.bEd.bEw == cVar.bEw && this.bEd.bEx == cVar.bEx && this.bEd.mDirection == cVar.mDirection && this.bEd.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(c cVar) {
        bak().setMuted(cVar.bEh);
        bak().setMediaControllerEnabled(cVar.bEq);
        bak().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.bEk, "cover")) {
            bak().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.bEk, "fill")) {
            bak().setVideoScalingMode(3);
        } else {
            bak().setVideoScalingMode(1);
        }
    }

    private void hG(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eer != null && !z && isPlaying()) {
            this.eer.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAz);
        i(cVar);
        this.bEd = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bag();
        bah();
        bal().cO(cVar.bEi, cVar.bEk);
    }

    public void h(c cVar) {
        bal().j(cVar);
        baj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bae() {
        final Activity activity;
        e acF = e.acF();
        if (acF == null || (activity = acF.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ag(activity);
                SwanAppComponentContainerView baq = a.this.bal().baq();
                baq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(baq);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, baq);
                b.a(a.this.bEd.bAz, a.this.bEd.bim, true, a.this.bal());
            }
        });
        this.mIsLandscape = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baf() {
        Activity activity;
        e acF = e.acF();
        if (acF == null || (activity = acF.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(a.this.bal().baq());
                a.this.bal().KF();
                b.a(a.this.bEd.bAz, a.this.bEd.bim, false, a.this.bal());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.bEd != null && cVar != null && !TextUtils.isEmpty(this.bEd.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.bEd.mSrc, cVar.mSrc)) {
            this.eeu = true;
        } else {
            this.eeu = false;
        }
    }

    private void bag() {
        if (this.eer != null) {
            this.eer.stopPlayback();
        }
    }

    private void bah() {
        bal().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Yg()) {
            bal().bao();
            reset();
            bak().baA();
            g(this.bEd);
            a(this.bEd, false);
            e(this.bEd);
            bak().start();
            this.eeu = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        bak().pause();
        this.eet = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.eet && !this.eeu) {
            bak().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (Yg()) {
            if (!this.eeu) {
                bak().seekTo(i);
            } else {
                this.eaa = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return bak().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return bak().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.eev;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void f(boolean z, int i) {
        if (z) {
            bae();
        } else {
            baf();
        }
    }

    private void initListener() {
        bak().setVideoPlayerCallback(new C0416a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.eer == null) {
            return false;
        }
        return this.eer.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && baf();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void Vl() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void ij(String str) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(c cVar) {
    }

    private void baj() {
        if (this.eer != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eer);
            if (this.eew != null) {
                this.eew.addView(this.eer);
            } else {
                bal().getVideoHolder().addView(this.eer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bak() {
        if (this.eer == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eer = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bal() {
        if (this.bEd == null) {
            com.baidu.swan.apps.component.e.a.au("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.ees == null) {
            this.ees = new VideoContainerManager(this.mContext, this.bEd);
        }
        return this.ees;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cJ(boolean z) {
        bak().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cK(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bak().release();
    }

    public void reset() {
        if (this.eer != null) {
            this.eer.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eer);
            this.eer = null;
        }
    }

    private boolean Yg() {
        return (this.bEd == null || TextUtils.isEmpty(this.bEd.mSrc) || TextUtils.isEmpty(this.bEd.bAz) || TextUtils.isEmpty(this.bEd.bil)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bam() {
        if (Yg()) {
            if (this.eaa != 0) {
                bak().seekTo(this.eaa);
                this.eaa = 0;
            } else if (this.bEd.bEj != 0) {
                this.eer.seekTo(this.bEd.bEj * 1000);
                this.bEd.bEj = 0;
            } else if (this.eeA != 0) {
                this.eer.seekTo(this.eeA);
                this.eeA = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0416a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0416a() {
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onEnd() {
            a.this.eet = false;
            b.a(a.this.bEd.bAz, a.this.bEd.bim, "ended", new JSONObject());
            if (a.this.eez != null) {
                a.this.eez.b(a.this);
            }
            a.this.eev = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void g(int i, int i2, String str) {
            a.this.eet = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bal().bao();
            a.this.bal().bap();
            b.a(a.this.bEd.bAz, a.this.bEd.bim, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.oq(i2));
            if (a.this.eey != null) {
                a.this.eey.a(a.this, i, i2);
            }
            a.this.eev = false;
            int currentPosition = a.this.bak().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eeA;
            }
            aVar.eeA = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bam();
            a.this.bai();
            if (a.this.eex != null) {
                a.this.eex.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void hH(boolean z) {
            if (z) {
                a.this.bae();
            } else {
                a.this.baf();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition();
            int duration = swanVideoView.getDuration();
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                bb(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            b.a(a.this.bEd.bAz, a.this.bEd.bim, "waiting", new JSONObject());
        }

        private void bb(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            b.a(a.this.bEd.bAz, a.this.bEd.bim, "timeupdate", jSONObject);
        }
    }
}
