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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.play.g;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements v {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.d.c aCt;
    private boolean arz = true;
    private int cWh;
    private com.baidu.tieba.aiapps.apps.media.video.view.a ddV;
    private b ddW;
    private boolean ddX;
    private boolean ddY;
    private boolean ddZ;
    private FrameLayout dea;
    private v.c deb;
    private v.b dec;
    private v.a ded;
    private Context mContext;
    private boolean mIsLandscape;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.v
    /* renamed from: dv */
    public a bg(Context context) {
        this.mContext = context;
        aEX();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.c cVar) {
        this.deb = cVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.b bVar) {
        this.dec = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.a aVar) {
        this.ded = aVar;
    }

    private void e(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aEW().setVideoUrl(this.aCt.mSrc, "");
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(FrameLayout frameLayout) {
        this.dea = frameLayout;
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
        this.aCt = cVar;
        if (z) {
            gv(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aCt == null) {
            return false;
        }
        return (this.aCt.aCx == cVar.aCx && this.aCt.aCG == cVar.aCG && TextUtils.equals(this.aCt.aCA, cVar.aCA) && this.aCt.aCO == cVar.aCO && this.aCt.aCL == cVar.aCL && this.aCt.aCM == cVar.aCM && this.aCt.aCN == cVar.aCN && this.aCt.mDirection == cVar.mDirection && this.aCt.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(com.baidu.swan.apps.media.d.c cVar) {
        aEW().setMuted(cVar.aCx);
        aEW().setLooping(cVar.mLoop);
    }

    private void gv(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.ddV != null && !z && isPlaying()) {
            this.ddV.pausePlay();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(com.baidu.swan.apps.media.d.c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aAu);
        i(cVar);
        this.aCt = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aES();
        reset();
        g(this.aCt);
        a(this.aCt, false);
        e(this.aCt);
        aEX().cp(cVar.aCy, cVar.aCA);
        aET();
    }

    public void h(com.baidu.swan.apps.media.d.c cVar) {
        aEX().j(cVar);
        aEV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEQ() {
        final Activity activity;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null || (activity = Lq.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ae(activity);
                SwanAppNAViewContainer aFd = a.this.aEX().aFd();
                aFd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(aFd);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aFd);
                d.a(a.this.aCt.aAu, a.this.aCt.aDm, true, a.this.aEX());
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
    public boolean aER() {
        Activity activity;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null || (activity = Lq.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAppNAViewContainer aFd = a.this.aEX().aFd();
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(aFd);
                com.baidu.swan.apps.view.container.c.c.a(aFd, ac.ir(aFd.getSlaveId()));
                d.a(a.this.aCt.aAu, a.this.aCt.aDm, false, a.this.aEX());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aCt != null && cVar != null && !TextUtils.isEmpty(this.aCt.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.aCt.mSrc, cVar.mSrc)) {
            this.ddY = true;
        } else {
            this.ddY = false;
        }
    }

    private void aES() {
        if (aEW() != null) {
            this.ddV.stopPlay();
        }
    }

    private void aET() {
        aEX().j(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (GF()) {
            aEX().aFb();
            reset();
            g(this.aCt);
            a(this.aCt, false);
            e(this.aCt);
            aEW().cr(this.aCt.mSrc, "");
            this.ddY = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void pause() {
        aEW().pausePlay();
        this.ddX = true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void resume() {
        if (this.ddX && !this.ddY) {
            aEW().bIr();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void seekTo(int i) {
        if (GF()) {
            if (!this.ddY) {
                aEW().seekTo(i);
            } else {
                this.cWh = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getDuration() {
        return aEW().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getCurrentPosition() {
        return aEW().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isEnd() {
        return this.ddZ;
    }

    private void initListener() {
        aEW().setVideoPlayerCallback(new C0284a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEU() {
        if (!this.arz) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isPlaying() {
        return aEW().pg();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean onBackPressed() {
        return isLandscape() && aER();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void EC() {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void setFullScreen(boolean z) {
        if (z) {
            aEQ();
        } else {
            aER();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void eC(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(com.baidu.swan.apps.media.d.c cVar) {
    }

    private void aEV() {
        if (aEW() != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(this.ddV.caV());
            if (this.dea != null) {
                this.dea.addView(this.ddV.caV());
            } else {
                aEX().aFa().addView(this.ddV.caV());
            }
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aEW() {
        if (this.ddV == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.ddV = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) this.mContext, true);
            this.ddV.e(aEX().aFd());
            initListener();
        }
        return this.ddV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aEX() {
        if (this.ddW == null) {
            this.ddW = new b(this.mContext);
        }
        return this.ddW;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bo(boolean z) {
        aEW().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bp(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", IntentConfig.STOP);
        if (this.ddV != null) {
            aEW().aEM();
        }
        reset();
    }

    public void reset() {
        if (this.ddV != null) {
            this.ddV.stopPlay();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(this.ddV.gZe);
            this.ddV = null;
        }
    }

    private boolean GF() {
        return (this.aCt == null || TextUtils.isEmpty(this.aCt.mSrc) || TextUtils.isEmpty(this.aCt.aAu) || TextUtils.isEmpty(this.aCt.id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEY() {
        if (GF()) {
            if (this.cWh != 0) {
                aEW().seekTo(this.cWh);
                this.cWh = 0;
            } else if (this.aCt.aCz != 0) {
                this.ddV.seekTo(this.aCt.aCz * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0284a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0284a() {
        }

        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            a.this.ddX = false;
            d.a(a.this.aCt.aAu, a.this.aCt.aDm, "ended", new JSONObject());
            if (a.this.ded != null) {
                a.this.ded.a(a.this);
            }
            a.this.ddZ = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.play.g.b
        public boolean onError(g gVar, int i, int i2) {
            a.this.ddX = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aEX().aFb();
            a.this.aEX().aFc();
            if (a.this.dec != null) {
                a.this.dec.a(a.this, i, i2);
            }
            a.this.ddZ = false;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
            return true;
        }

        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aEY();
            a.this.aEU();
            if (a.this.deb != null) {
                a.this.deb.b(a.this);
            }
            a.this.ddZ = false;
            a.this.ddX = false;
            d.a(a.this.aCt.aAu, a.this.aCt.aDm, "play", new JSONObject());
            a.this.aEX().aFc();
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void gw(boolean z) {
            if (z) {
                a.this.aEQ();
            } else {
                a.this.aER();
            }
        }
    }
}
