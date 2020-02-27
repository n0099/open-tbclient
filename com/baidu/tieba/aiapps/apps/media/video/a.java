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
    private c bEc;
    private int dZZ;
    private SwanVideoView eeq;
    private VideoContainerManager eer;
    private boolean ees;
    private boolean eet;
    private boolean eeu;
    private FrameLayout eev;
    private l.d eew;
    private l.b eex;
    private l.a eey;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsForeground = true;
    private int eez = 0;

    @Override // com.baidu.swan.apps.w.b.l
    public void HN() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void HP() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.w.b.l
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEc = cVar;
        baj();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.eew = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.eex = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.eey = aVar;
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
        bai().setVideoPath(this.bEc.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eev = frameLayout;
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
        this.bEc = cVar;
        if (z) {
            hG(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.bEc == null) {
            return false;
        }
        return (this.bEc.bEg == cVar.bEg && this.bEc.bEp == cVar.bEp && TextUtils.equals(this.bEc.bEj, cVar.bEj) && this.bEc.bEx == cVar.bEx && this.bEc.bEu == cVar.bEu && this.bEc.bEv == cVar.bEv && this.bEc.bEw == cVar.bEw && this.bEc.mDirection == cVar.mDirection && this.bEc.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(c cVar) {
        bai().setMuted(cVar.bEg);
        bai().setMediaControllerEnabled(cVar.bEp);
        bai().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.bEj, "cover")) {
            bai().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.bEj, "fill")) {
            bai().setVideoScalingMode(3);
        } else {
            bai().setVideoScalingMode(1);
        }
    }

    private void hG(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eeq != null && !z && isPlaying()) {
            this.eeq.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAy);
        i(cVar);
        this.bEc = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bae();
        baf();
        baj().cO(cVar.bEh, cVar.bEj);
    }

    public void h(c cVar) {
        baj().j(cVar);
        bah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bac() {
        final Activity activity;
        e acD = e.acD();
        if (acD == null || (activity = acD.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ag(activity);
                SwanAppComponentContainerView bao = a.this.baj().bao();
                bao.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(bao);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, bao);
                b.a(a.this.bEc.bAy, a.this.bEc.bil, true, a.this.baj());
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
    public boolean bad() {
        Activity activity;
        e acD = e.acD();
        if (acD == null || (activity = acD.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(a.this.baj().bao());
                a.this.baj().KD();
                b.a(a.this.bEc.bAy, a.this.bEc.bil, false, a.this.baj());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.bEc != null && cVar != null && !TextUtils.isEmpty(this.bEc.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.bEc.mSrc, cVar.mSrc)) {
            this.eet = true;
        } else {
            this.eet = false;
        }
    }

    private void bae() {
        if (this.eeq != null) {
            this.eeq.stopPlayback();
        }
    }

    private void baf() {
        baj().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Ye()) {
            baj().bam();
            reset();
            bai().bay();
            g(this.bEc);
            a(this.bEc, false);
            e(this.bEc);
            bai().start();
            this.eet = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        bai().pause();
        this.ees = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.ees && !this.eet) {
            bai().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (Ye()) {
            if (!this.eet) {
                bai().seekTo(i);
            } else {
                this.dZZ = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return bai().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return bai().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.eeu;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void f(boolean z, int i) {
        if (z) {
            bac();
        } else {
            bad();
        }
    }

    private void initListener() {
        bai().setVideoPlayerCallback(new C0416a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bag() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.eeq == null) {
            return false;
        }
        return this.eeq.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && bad();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void Vj() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void ij(String str) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(c cVar) {
    }

    private void bah() {
        if (this.eeq != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eeq);
            if (this.eev != null) {
                this.eev.addView(this.eeq);
            } else {
                baj().getVideoHolder().addView(this.eeq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bai() {
        if (this.eeq == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eeq = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eeq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager baj() {
        if (this.bEc == null) {
            com.baidu.swan.apps.component.e.a.au("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eer == null) {
            this.eer = new VideoContainerManager(this.mContext, this.bEc);
        }
        return this.eer;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cJ(boolean z) {
        bai().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cK(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bai().release();
    }

    public void reset() {
        if (this.eeq != null) {
            this.eeq.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eeq);
            this.eeq = null;
        }
    }

    private boolean Ye() {
        return (this.bEc == null || TextUtils.isEmpty(this.bEc.mSrc) || TextUtils.isEmpty(this.bEc.bAy) || TextUtils.isEmpty(this.bEc.bik)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bak() {
        if (Ye()) {
            if (this.dZZ != 0) {
                bai().seekTo(this.dZZ);
                this.dZZ = 0;
            } else if (this.bEc.bEi != 0) {
                this.eeq.seekTo(this.bEc.bEi * 1000);
                this.bEc.bEi = 0;
            } else if (this.eez != 0) {
                this.eeq.seekTo(this.eez);
                this.eez = 0;
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
            a.this.ees = false;
            b.a(a.this.bEc.bAy, a.this.bEc.bil, "ended", new JSONObject());
            if (a.this.eey != null) {
                a.this.eey.b(a.this);
            }
            a.this.eeu = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void g(int i, int i2, String str) {
            a.this.ees = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.baj().bam();
            a.this.baj().ban();
            b.a(a.this.bEc.bAy, a.this.bEc.bil, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.oq(i2));
            if (a.this.eex != null) {
                a.this.eex.a(a.this, i, i2);
            }
            a.this.eeu = false;
            int currentPosition = a.this.bai().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eez;
            }
            aVar.eez = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bak();
            a.this.bag();
            if (a.this.eew != null) {
                a.this.eew.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void hH(boolean z) {
            if (z) {
                a.this.bac();
            } else {
                a.this.bad();
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
            b.a(a.this.bEc.bAy, a.this.bEc.bil, "waiting", new JSONObject());
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
            b.a(a.this.bEc.bAy, a.this.bEc.bil, "timeupdate", jSONObject);
        }
    }
}
