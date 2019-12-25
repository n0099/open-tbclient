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
/* loaded from: classes9.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c bzj;
    private int dVM;
    private SwanVideoView eae;
    private VideoContainerManager eaf;
    private boolean eag;
    private boolean eah;
    private boolean eai;
    private FrameLayout eaj;
    private l.d eak;
    private l.b eal;
    private l.a eam;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsForeground = true;
    private int ean = 0;

    @Override // com.baidu.swan.apps.w.b.l
    public void Fc() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void Fe() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.w.b.l
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bzj = cVar;
        aXA();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.eak = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.eal = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.eam = aVar;
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
        aXz().setVideoPath(this.bzj.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eaj = frameLayout;
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
        this.bzj = cVar;
        if (z) {
            hu(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.bzj == null) {
            return false;
        }
        return (this.bzj.bzn == cVar.bzn && this.bzj.bzw == cVar.bzw && TextUtils.equals(this.bzj.bzq, cVar.bzq) && this.bzj.bzE == cVar.bzE && this.bzj.bzB == cVar.bzB && this.bzj.bzC == cVar.bzC && this.bzj.bzD == cVar.bzD && this.bzj.mDirection == cVar.mDirection && this.bzj.bvL == cVar.bvL) ? false : true;
    }

    private void g(c cVar) {
        aXz().setMuted(cVar.bzn);
        aXz().setMediaControllerEnabled(cVar.bzw);
        aXz().setLooping(cVar.bvL);
        if (TextUtils.equals(cVar.bzq, "cover")) {
            aXz().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.bzq, "fill")) {
            aXz().setVideoScalingMode(3);
        } else {
            aXz().setVideoScalingMode(1);
        }
    }

    private void hu(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eae != null && !z && isPlaying()) {
            this.eae.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bvC);
        i(cVar);
        this.bzj = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aXv();
        aXw();
        aXA().cF(cVar.bzo, cVar.bzq);
    }

    public void h(c cVar) {
        aXA().j(cVar);
        aXy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXt() {
        final Activity activity;
        e ZS = e.ZS();
        if (ZS == null || (activity = ZS.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ae(activity);
                SwanAppComponentContainerView aXF = a.this.aXA().aXF();
                aXF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bo(aXF);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aXF);
                b.a(a.this.bzj.bvC, a.this.bzj.bdi, true, a.this.aXA());
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
    public boolean aXu() {
        Activity activity;
        e ZS = e.ZS();
        if (ZS == null || (activity = ZS.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bo(a.this.aXA().aXF());
                a.this.aXA().HS();
                b.a(a.this.bzj.bvC, a.this.bzj.bdi, false, a.this.aXA());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.bzj != null && cVar != null && !TextUtils.isEmpty(this.bzj.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.bzj.mSrc, cVar.mSrc)) {
            this.eah = true;
        } else {
            this.eah = false;
        }
    }

    private void aXv() {
        if (this.eae != null) {
            this.eae.stopPlayback();
        }
    }

    private void aXw() {
        aXA().l(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Vt()) {
            aXA().aXD();
            reset();
            aXz().aXP();
            g(this.bzj);
            a(this.bzj, false);
            e(this.bzj);
            aXz().start();
            this.eah = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        aXz().pause();
        this.eag = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.eag && !this.eah) {
            aXz().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (Vt()) {
            if (!this.eah) {
                aXz().seekTo(i);
            } else {
                this.dVM = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return aXz().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return aXz().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.eai;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void d(boolean z, int i) {
        if (z) {
            aXt();
        } else {
            aXu();
        }
    }

    private void initListener() {
        aXz().setVideoPlayerCallback(new C0403a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.eae == null) {
            return false;
        }
        return this.eae.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && aXu();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void Sz() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void hQ(String str) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(c cVar) {
    }

    private void aXy() {
        if (this.eae != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bo(this.eae);
            if (this.eaj != null) {
                this.eaj.addView(this.eae);
            } else {
                aXA().getVideoHolder().addView(this.eae);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView aXz() {
        if (this.eae == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eae = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager aXA() {
        if (this.bzj == null) {
            com.baidu.swan.apps.component.e.a.aj("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eaf == null) {
            this.eaf = new VideoContainerManager(this.mContext, this.bzj);
        }
        return this.eaf;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cx(boolean z) {
        aXz().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cy(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        aXz().release();
    }

    public void reset() {
        if (this.eae != null) {
            this.eae.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bo(this.eae);
            this.eae = null;
        }
    }

    private boolean Vt() {
        return (this.bzj == null || TextUtils.isEmpty(this.bzj.mSrc) || TextUtils.isEmpty(this.bzj.bvC) || TextUtils.isEmpty(this.bzj.bdh)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXB() {
        if (Vt()) {
            if (this.dVM != 0) {
                aXz().seekTo(this.dVM);
                this.dVM = 0;
            } else if (this.bzj.bzp != 0) {
                this.eae.seekTo(this.bzj.bzp * 1000);
                this.bzj.bzp = 0;
            } else if (this.ean != 0) {
                this.eae.seekTo(this.ean);
                this.ean = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0403a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0403a() {
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onEnd() {
            a.this.eag = false;
            b.a(a.this.bzj.bvC, a.this.bzj.bdi, "ended", new JSONObject());
            if (a.this.eam != null) {
                a.this.eam.b(a.this);
            }
            a.this.eai = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void f(int i, int i2, String str) {
            a.this.eag = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aXA().aXD();
            a.this.aXA().aXE();
            b.a(a.this.bzj.bvC, a.this.bzj.bdi, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.nZ(i2));
            if (a.this.eal != null) {
                a.this.eal.a(a.this, i, i2);
            }
            a.this.eai = false;
            int currentPosition = a.this.aXz().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.ean;
            }
            aVar.ean = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aXB();
            a.this.aXx();
            if (a.this.eak != null) {
                a.this.eak.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void hv(boolean z) {
            if (z) {
                a.this.aXt();
            } else {
                a.this.aXu();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition();
            int duration = swanVideoView.getDuration();
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                aX(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            b.a(a.this.bzj.bvC, a.this.bzj.bdi, "waiting", new JSONObject());
        }

        private void aX(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            b.a(a.this.bzj.bvC, a.this.bzj.bdi, "timeupdate", jSONObject);
        }
    }
}
