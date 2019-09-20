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
    private com.baidu.swan.apps.media.d.c aDz;
    private boolean asA = true;
    private int cZs;
    private v.b dhA;
    private v.a dhB;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dht;
    private b dhu;
    private boolean dhv;
    private boolean dhw;
    private boolean dhx;
    private FrameLayout dhy;
    private v.c dhz;
    private Context mContext;
    private boolean mIsLandscape;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.v
    /* renamed from: dx */
    public a bg(Context context) {
        this.mContext = context;
        aGZ();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.c cVar) {
        this.dhz = cVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.b bVar) {
        this.dhA = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.a aVar) {
        this.dhB = aVar;
    }

    private void e(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aGY().setVideoUrl(this.aDz.mSrc, "");
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(FrameLayout frameLayout) {
        this.dhy = frameLayout;
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
        this.aDz = cVar;
        if (z) {
            gC(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aDz == null) {
            return false;
        }
        return (this.aDz.aDD == cVar.aDD && this.aDz.aDM == cVar.aDM && TextUtils.equals(this.aDz.aDG, cVar.aDG) && this.aDz.aDU == cVar.aDU && this.aDz.aDR == cVar.aDR && this.aDz.aDS == cVar.aDS && this.aDz.aDT == cVar.aDT && this.aDz.mDirection == cVar.mDirection && this.aDz.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(com.baidu.swan.apps.media.d.c cVar) {
        aGY().setMuted(cVar.aDD);
        aGY().setLooping(cVar.mLoop);
    }

    private void gC(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dht != null && !z && isPlaying()) {
            this.dht.pausePlay();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(com.baidu.swan.apps.media.d.c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aBA);
        i(cVar);
        this.aDz = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aGU();
        reset();
        g(this.aDz);
        a(this.aDz, false);
        e(this.aDz);
        aGZ().cr(cVar.aDE, cVar.aDG);
        aGV();
    }

    public void h(com.baidu.swan.apps.media.d.c cVar) {
        aGZ().j(cVar);
        aGX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGS() {
        final Activity activity;
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null || (activity = Mh.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ah(activity);
                SwanAppNAViewContainer aHf = a.this.aGZ().aHf();
                aHf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aHf);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aHf);
                d.a(a.this.aDz.aBA, a.this.aDz.aEs, true, a.this.aGZ());
            }
        });
        this.mIsLandscape = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGT() {
        Activity activity;
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null || (activity = Mh.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAppNAViewContainer aHf = a.this.aGZ().aHf();
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aHf);
                com.baidu.swan.apps.view.container.c.c.a(aHf, ac.iz(aHf.getSlaveId()));
                d.a(a.this.aDz.aBA, a.this.aDz.aEs, false, a.this.aGZ());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aDz != null && cVar != null && !TextUtils.isEmpty(this.aDz.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.aDz.mSrc, cVar.mSrc)) {
            this.dhw = true;
        } else {
            this.dhw = false;
        }
    }

    private void aGU() {
        if (aGY() != null) {
            this.dht.stopPlay();
        }
    }

    private void aGV() {
        aGZ().j(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Ht()) {
            aGZ().aHd();
            reset();
            g(this.aDz);
            a(this.aDz, false);
            e(this.aDz);
            aGY().ct(this.aDz.mSrc, "");
            this.dhw = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void pause() {
        aGY().pausePlay();
        this.dhv = true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void resume() {
        if (this.dhv && !this.dhw) {
            aGY().bMd();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void seekTo(int i) {
        if (Ht()) {
            if (!this.dhw) {
                aGY().seekTo(i);
            } else {
                this.cZs = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getDuration() {
        return aGY().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getCurrentPosition() {
        return aGY().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isEnd() {
        return this.dhx;
    }

    private void initListener() {
        aGY().setVideoPlayerCallback(new C0296a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGW() {
        if (!this.asA) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isPlaying() {
        return aGY().pC();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean onBackPressed() {
        return isLandscape() && aGT();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void Fp() {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void setFullScreen(boolean z) {
        if (z) {
            aGS();
        } else {
            aGT();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void eI(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(com.baidu.swan.apps.media.d.c cVar) {
    }

    private void aGX() {
        if (aGY() != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dht.ceV());
            if (this.dhy != null) {
                this.dhy.addView(this.dht.ceV());
            } else {
                aGZ().aHc().addView(this.dht.ceV());
            }
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aGY() {
        if (this.dht == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dht = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) this.mContext, true);
            this.dht.e(aGZ().aHf());
            initListener();
        }
        return this.dht;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aGZ() {
        if (this.dhu == null) {
            this.dhu = new b(this.mContext);
        }
        return this.dhu;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void br(boolean z) {
        aGY().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bs(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", IntentConfig.STOP);
        if (this.dht != null) {
            aGY().aGN();
        }
        reset();
    }

    public void reset() {
        if (this.dht != null) {
            this.dht.stopPlay();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dht.hih);
            this.dht = null;
        }
    }

    private boolean Ht() {
        return (this.aDz == null || TextUtils.isEmpty(this.aDz.mSrc) || TextUtils.isEmpty(this.aDz.aBA) || TextUtils.isEmpty(this.aDz.id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHa() {
        if (Ht()) {
            if (this.cZs != 0) {
                aGY().seekTo(this.cZs);
                this.cZs = 0;
            } else if (this.aDz.aDF != 0) {
                this.dht.seekTo(this.aDz.aDF * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0296a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0296a() {
        }

        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            a.this.dhv = false;
            d.a(a.this.aDz.aBA, a.this.aDz.aEs, "ended", new JSONObject());
            if (a.this.dhB != null) {
                a.this.dhB.a(a.this);
            }
            a.this.dhx = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.play.g.b
        public boolean onError(g gVar, int i, int i2) {
            a.this.dhv = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aGZ().aHd();
            a.this.aGZ().aHe();
            if (a.this.dhA != null) {
                a.this.dhA.a(a.this, i, i2);
            }
            a.this.dhx = false;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
            return true;
        }

        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aHa();
            a.this.aGW();
            if (a.this.dhz != null) {
                a.this.dhz.b(a.this);
            }
            a.this.dhx = false;
            a.this.dhv = false;
            d.a(a.this.aDz.aBA, a.this.aDz.aEs, "play", new JSONObject());
            a.this.aGZ().aHe();
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void gD(boolean z) {
            if (z) {
                a.this.aGS();
            } else {
                a.this.aGT();
            }
        }
    }
}
