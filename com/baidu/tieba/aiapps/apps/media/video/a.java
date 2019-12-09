package com.baidu.tieba.aiapps.apps.media.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.u.b.v;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tieba.play.g;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements v {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aLy = true;
    private com.baidu.swan.apps.media.d.c aWw;
    private int dhZ;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dpX;
    private b dpY;
    private boolean dpZ;
    private boolean dqa;
    private boolean dqb;
    private FrameLayout dqc;
    private v.c dqd;
    private v.b dqe;
    private v.a dqf;
    private Context mContext;
    private boolean mIsLandscape;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.v
    /* renamed from: dg */
    public a bi(Context context) {
        this.mContext = context;
        aHk();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.c cVar) {
        this.dqd = cVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.b bVar) {
        this.dqe = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.a aVar) {
        this.dqf = aVar;
    }

    private void e(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aHj().setVideoUrl(this.aWw.mSrc, "");
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(FrameLayout frameLayout) {
        this.dqc = frameLayout;
    }

    private boolean isLandscape() {
        return this.mIsLandscape;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(com.baidu.swan.apps.media.d.c cVar, boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        com.baidu.swan.apps.console.c.d("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (f(cVar)) {
            g(cVar);
        }
        this.aWw = cVar;
        if (z) {
            gr(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aWw == null) {
            return false;
        }
        return (this.aWw.aWA == cVar.aWA && this.aWw.aWJ == cVar.aWJ && TextUtils.equals(this.aWw.aWD, cVar.aWD) && this.aWw.aWR == cVar.aWR && this.aWw.aWO == cVar.aWO && this.aWw.aWP == cVar.aWP && this.aWw.aWQ == cVar.aWQ && this.aWw.mDirection == cVar.mDirection && this.aWw.aUG == cVar.aUG) ? false : true;
    }

    private void g(com.baidu.swan.apps.media.d.c cVar) {
        aHj().setMuted(cVar.aWA);
        aHj().setLooping(cVar.aUG);
    }

    private void gr(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dpX != null && !z && isPlaying()) {
            this.dpX.pausePlay();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(com.baidu.swan.apps.media.d.c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aUw);
        i(cVar);
        this.aWw = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aHf();
        reset();
        g(this.aWw);
        a(this.aWw, false);
        e(this.aWw);
        aHk().ck(cVar.aWB, cVar.aWD);
        aHg();
    }

    public void h(com.baidu.swan.apps.media.d.c cVar) {
        aHk().j(cVar);
        aHi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHd() {
        final Activity activity;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null || (activity = Ra.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.Z(activity);
                SwanAppNAViewContainer aHq = a.this.aHk().aHq();
                aHq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aHq);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aHq);
                d.a(a.this.aWw.aUw, a.this.aWw.aXp, true, a.this.aHk());
            }
        });
        this.mIsLandscape = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHe() {
        Activity activity;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null || (activity = Ra.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAppNAViewContainer aHq = a.this.aHk().aHq();
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aHq);
                com.baidu.swan.apps.view.container.c.c.a(aHq, ac.jc(aHq.getSlaveId()));
                d.a(a.this.aWw.aUw, a.this.aWw.aXp, false, a.this.aHk());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aWw != null && cVar != null && !TextUtils.isEmpty(this.aWw.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.aWw.mSrc, cVar.mSrc)) {
            this.dqa = true;
        } else {
            this.dqa = false;
        }
    }

    private void aHf() {
        if (aHj() != null) {
            this.dpX.stopPlay();
        }
    }

    private void aHg() {
        aHk().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Mo()) {
            aHk().aHo();
            reset();
            g(this.aWw);
            a(this.aWw, false);
            e(this.aWw);
            aHj().cm(this.aWw.mSrc, "");
            this.dqa = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void pause() {
        aHj().pausePlay();
        this.dpZ = true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void resume() {
        if (this.dpZ && !this.dqa) {
            aHj().bIK();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void seekTo(int i) {
        if (Mo()) {
            if (!this.dqa) {
                aHj().seekTo(i);
            } else {
                this.dhZ = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getDuration() {
        return aHj().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getCurrentPosition() {
        return aHj().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isEnd() {
        return this.dqb;
    }

    private void initListener() {
        aHj().setVideoPlayerCallback(new C0323a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHh() {
        if (!this.aLy) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isPlaying() {
        return aHj().kx();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean onBackPressed() {
        return isLandscape() && aHe();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void Kk() {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void setFullScreen(boolean z) {
        if (z) {
            aHd();
        } else {
            aHe();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void fp(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(com.baidu.swan.apps.media.d.c cVar) {
    }

    private void aHi() {
        if (aHj() != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dpX.cbV());
            if (this.dqc != null) {
                this.dqc.addView(this.dpX.cbV());
            } else {
                aHk().aHn().addView(this.dpX.cbV());
            }
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aHj() {
        if (this.dpX == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dpX = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) this.mContext, true);
            this.dpX.e(aHk().aHq());
            initListener();
        }
        return this.dpX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aHk() {
        if (this.dpY == null) {
            this.dpY = new b(this.mContext);
        }
        return this.dpY;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bJ(boolean z) {
        aHj().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bK(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        if (this.dpX != null) {
            aHj().aGY();
        }
        reset();
    }

    public void reset() {
        if (this.dpX != null) {
            this.dpX.stopPlay();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dpX.hfu);
            this.dpX = null;
        }
    }

    private boolean Mo() {
        return (this.aWw == null || TextUtils.isEmpty(this.aWw.mSrc) || TextUtils.isEmpty(this.aWw.aUw) || TextUtils.isEmpty(this.aWw.id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHl() {
        if (Mo()) {
            if (this.dhZ != 0) {
                aHj().seekTo(this.dhZ);
                this.dhZ = 0;
            } else if (this.aWw.aWC != 0) {
                this.dpX.seekTo(this.aWw.aWC * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0323a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0323a() {
        }

        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            a.this.dpZ = false;
            d.a(a.this.aWw.aUw, a.this.aWw.aXp, "ended", new JSONObject());
            if (a.this.dqf != null) {
                a.this.dqf.a(a.this);
            }
            a.this.dqb = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.play.g.b
        public boolean onError(g gVar, int i, int i2) {
            a.this.dpZ = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aHk().aHo();
            a.this.aHk().aHp();
            if (a.this.dqe != null) {
                a.this.dqe.a(a.this, i, i2);
            }
            a.this.dqb = false;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
            return true;
        }

        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aHl();
            a.this.aHh();
            if (a.this.dqd != null) {
                a.this.dqd.b(a.this);
            }
            a.this.dqb = false;
            a.this.dpZ = false;
            d.a(a.this.aWw.aUw, a.this.aWw.aXp, "play", new JSONObject());
            a.this.aHk().aHp();
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void gs(boolean z) {
            if (z) {
                a.this.aHd();
            } else {
                a.this.aHe();
            }
        }
    }
}
