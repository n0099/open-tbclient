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
    private c bEe;
    private int ean;
    private SwanVideoView eeE;
    private VideoContainerManager eeF;
    private boolean eeG;
    private boolean eeH;
    private boolean eeI;
    private FrameLayout eeJ;
    private l.d eeK;
    private l.b eeL;
    private l.a eeM;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsForeground = true;
    private int eeN = 0;

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
        this.bEe = cVar;
        bam();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.eeK = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.eeL = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.eeM = aVar;
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
        bal().setVideoPath(this.bEe.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eeJ = frameLayout;
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
        this.bEe = cVar;
        if (z) {
            hG(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.bEe == null) {
            return false;
        }
        return (this.bEe.bEi == cVar.bEi && this.bEe.bEr == cVar.bEr && TextUtils.equals(this.bEe.bEl, cVar.bEl) && this.bEe.bEz == cVar.bEz && this.bEe.bEw == cVar.bEw && this.bEe.bEx == cVar.bEx && this.bEe.bEy == cVar.bEy && this.bEe.mDirection == cVar.mDirection && this.bEe.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(c cVar) {
        bal().setMuted(cVar.bEi);
        bal().setMediaControllerEnabled(cVar.bEr);
        bal().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.bEl, "cover")) {
            bal().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.bEl, "fill")) {
            bal().setVideoScalingMode(3);
        } else {
            bal().setVideoScalingMode(1);
        }
    }

    private void hG(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eeE != null && !z && isPlaying()) {
            this.eeE.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAA);
        i(cVar);
        this.bEe = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bah();
        bai();
        bam().cO(cVar.bEj, cVar.bEl);
    }

    public void h(c cVar) {
        bam().j(cVar);
        bak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baf() {
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
                a.this.ai(activity);
                SwanAppComponentContainerView bar = a.this.bam().bar();
                bar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(bar);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, bar);
                b.a(a.this.bEe.bAA, a.this.bEe.bin, true, a.this.bam());
            }
        });
        this.mIsLandscape = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bag() {
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
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(a.this.bam().bar());
                a.this.bam().KF();
                b.a(a.this.bEe.bAA, a.this.bEe.bin, false, a.this.bam());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.bEe != null && cVar != null && !TextUtils.isEmpty(this.bEe.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.bEe.mSrc, cVar.mSrc)) {
            this.eeH = true;
        } else {
            this.eeH = false;
        }
    }

    private void bah() {
        if (this.eeE != null) {
            this.eeE.stopPlayback();
        }
    }

    private void bai() {
        bam().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Yg()) {
            bam().bap();
            reset();
            bal().baB();
            g(this.bEe);
            a(this.bEe, false);
            e(this.bEe);
            bal().start();
            this.eeH = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        bal().pause();
        this.eeG = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.eeG && !this.eeH) {
            bal().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (Yg()) {
            if (!this.eeH) {
                bal().seekTo(i);
            } else {
                this.ean = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return bal().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return bal().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.eeI;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void f(boolean z, int i) {
        if (z) {
            baf();
        } else {
            bag();
        }
    }

    private void initListener() {
        bal().setVideoPlayerCallback(new C0416a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baj() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.eeE == null) {
            return false;
        }
        return this.eeE.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && bag();
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

    private void bak() {
        if (this.eeE != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eeE);
            if (this.eeJ != null) {
                this.eeJ.addView(this.eeE);
            } else {
                bam().getVideoHolder().addView(this.eeE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bal() {
        if (this.eeE == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eeE = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eeE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager bam() {
        if (this.bEe == null) {
            com.baidu.swan.apps.component.e.a.au("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eeF == null) {
            this.eeF = new VideoContainerManager(this.mContext, this.bEe);
        }
        return this.eeF;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cJ(boolean z) {
        bal().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cK(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bal().release();
    }

    public void reset() {
        if (this.eeE != null) {
            this.eeE.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eeE);
            this.eeE = null;
        }
    }

    private boolean Yg() {
        return (this.bEe == null || TextUtils.isEmpty(this.bEe.mSrc) || TextUtils.isEmpty(this.bEe.bAA) || TextUtils.isEmpty(this.bEe.bim)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ban() {
        if (Yg()) {
            if (this.ean != 0) {
                bal().seekTo(this.ean);
                this.ean = 0;
            } else if (this.bEe.bEk != 0) {
                this.eeE.seekTo(this.bEe.bEk * 1000);
                this.bEe.bEk = 0;
            } else if (this.eeN != 0) {
                this.eeE.seekTo(this.eeN);
                this.eeN = 0;
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
            a.this.eeG = false;
            b.a(a.this.bEe.bAA, a.this.bEe.bin, "ended", new JSONObject());
            if (a.this.eeM != null) {
                a.this.eeM.b(a.this);
            }
            a.this.eeI = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void g(int i, int i2, String str) {
            a.this.eeG = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.bam().bap();
            a.this.bam().baq();
            b.a(a.this.bEe.bAA, a.this.bEe.bin, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.oq(i2));
            if (a.this.eeL != null) {
                a.this.eeL.a(a.this, i, i2);
            }
            a.this.eeI = false;
            int currentPosition = a.this.bal().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eeN;
            }
            aVar.eeN = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.ban();
            a.this.baj();
            if (a.this.eeK != null) {
                a.this.eeK.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void hH(boolean z) {
            if (z) {
                a.this.baf();
            } else {
                a.this.bag();
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
            b.a(a.this.bEe.bAA, a.this.bEe.bin, "waiting", new JSONObject());
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
            b.a(a.this.bEe.bAA, a.this.bEe.bin, "timeupdate", jSONObject);
        }
    }
}
