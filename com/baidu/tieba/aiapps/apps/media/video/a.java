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
    private int cWi;
    private com.baidu.tieba.aiapps.apps.media.video.view.a ddW;
    private b ddX;
    private boolean ddY;
    private boolean ddZ;
    private boolean dea;
    private FrameLayout deb;
    private v.c dec;
    private v.b ded;
    private v.a dee;
    private Context mContext;
    private boolean mIsLandscape;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.v
    /* renamed from: dv */
    public a bg(Context context) {
        this.mContext = context;
        aFa();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.c cVar) {
        this.dec = cVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.b bVar) {
        this.ded = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.a aVar) {
        this.dee = aVar;
    }

    private void e(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aEZ().setVideoUrl(this.aCt.mSrc, "");
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(FrameLayout frameLayout) {
        this.deb = frameLayout;
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
        aEZ().setMuted(cVar.aCx);
        aEZ().setLooping(cVar.mLoop);
    }

    private void gv(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.ddW != null && !z && isPlaying()) {
            this.ddW.pausePlay();
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
        aEV();
        reset();
        g(this.aCt);
        a(this.aCt, false);
        e(this.aCt);
        aFa().cp(cVar.aCy, cVar.aCA);
        aEW();
    }

    public void h(com.baidu.swan.apps.media.d.c cVar) {
        aFa().j(cVar);
        aEY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aET() {
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
                SwanAppNAViewContainer aFg = a.this.aFa().aFg();
                aFg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(aFg);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aFg);
                d.a(a.this.aCt.aAu, a.this.aCt.aDm, true, a.this.aFa());
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
    public boolean aEU() {
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
                SwanAppNAViewContainer aFg = a.this.aFa().aFg();
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(aFg);
                com.baidu.swan.apps.view.container.c.c.a(aFg, ac.ir(aFg.getSlaveId()));
                d.a(a.this.aCt.aAu, a.this.aCt.aDm, false, a.this.aFa());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aCt != null && cVar != null && !TextUtils.isEmpty(this.aCt.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.aCt.mSrc, cVar.mSrc)) {
            this.ddZ = true;
        } else {
            this.ddZ = false;
        }
    }

    private void aEV() {
        if (aEZ() != null) {
            this.ddW.stopPlay();
        }
    }

    private void aEW() {
        aFa().j(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (GF()) {
            aFa().aFe();
            reset();
            g(this.aCt);
            a(this.aCt, false);
            e(this.aCt);
            aEZ().cr(this.aCt.mSrc, "");
            this.ddZ = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void pause() {
        aEZ().pausePlay();
        this.ddY = true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void resume() {
        if (this.ddY && !this.ddZ) {
            aEZ().bIu();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void seekTo(int i) {
        if (GF()) {
            if (!this.ddZ) {
                aEZ().seekTo(i);
            } else {
                this.cWi = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getDuration() {
        return aEZ().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getCurrentPosition() {
        return aEZ().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isEnd() {
        return this.dea;
    }

    private void initListener() {
        aEZ().setVideoPlayerCallback(new C0284a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEX() {
        if (!this.arz) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isPlaying() {
        return aEZ().pg();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean onBackPressed() {
        return isLandscape() && aEU();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void EC() {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void setFullScreen(boolean z) {
        if (z) {
            aET();
        } else {
            aEU();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void eC(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(com.baidu.swan.apps.media.d.c cVar) {
    }

    private void aEY() {
        if (aEZ() != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(this.ddW.caY());
            if (this.deb != null) {
                this.deb.addView(this.ddW.caY());
            } else {
                aFa().aFd().addView(this.ddW.caY());
            }
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aEZ() {
        if (this.ddW == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.ddW = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) this.mContext, true);
            this.ddW.e(aFa().aFg());
            initListener();
        }
        return this.ddW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aFa() {
        if (this.ddX == null) {
            this.ddX = new b(this.mContext);
        }
        return this.ddX;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bo(boolean z) {
        aEZ().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bp(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", IntentConfig.STOP);
        if (this.ddW != null) {
            aEZ().aEP();
        }
        reset();
    }

    public void reset() {
        if (this.ddW != null) {
            this.ddW.stopPlay();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bp(this.ddW.gZh);
            this.ddW = null;
        }
    }

    private boolean GF() {
        return (this.aCt == null || TextUtils.isEmpty(this.aCt.mSrc) || TextUtils.isEmpty(this.aCt.aAu) || TextUtils.isEmpty(this.aCt.id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFb() {
        if (GF()) {
            if (this.cWi != 0) {
                aEZ().seekTo(this.cWi);
                this.cWi = 0;
            } else if (this.aCt.aCz != 0) {
                this.ddW.seekTo(this.aCt.aCz * 1000);
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
            a.this.ddY = false;
            d.a(a.this.aCt.aAu, a.this.aCt.aDm, "ended", new JSONObject());
            if (a.this.dee != null) {
                a.this.dee.a(a.this);
            }
            a.this.dea = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.play.g.b
        public boolean onError(g gVar, int i, int i2) {
            a.this.ddY = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aFa().aFe();
            a.this.aFa().aFf();
            if (a.this.ded != null) {
                a.this.ded.a(a.this, i, i2);
            }
            a.this.dea = false;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
            return true;
        }

        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aFb();
            a.this.aEX();
            if (a.this.dec != null) {
                a.this.dec.b(a.this);
            }
            a.this.dea = false;
            a.this.ddY = false;
            d.a(a.this.aCt.aAu, a.this.aCt.aDm, "play", new JSONObject());
            a.this.aFa().aFf();
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void gw(boolean z) {
            if (z) {
                a.this.aET();
            } else {
                a.this.aEU();
            }
        }
    }
}
