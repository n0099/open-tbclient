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
    private com.baidu.swan.apps.media.d.c aDb;
    private boolean asc = true;
    private int cXF;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dfB;
    private b dfC;
    private boolean dfD;
    private boolean dfE;
    private boolean dfF;
    private FrameLayout dfG;
    private v.c dfH;
    private v.b dfI;
    private v.a dfJ;
    private Context mContext;
    private boolean mIsLandscape;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.v
    /* renamed from: dw */
    public a bg(Context context) {
        this.mContext = context;
        aGt();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.c cVar) {
        this.dfH = cVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.b bVar) {
        this.dfI = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.a aVar) {
        this.dfJ = aVar;
    }

    private void e(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aGs().setVideoUrl(this.aDb.mSrc, "");
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(FrameLayout frameLayout) {
        this.dfG = frameLayout;
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
        this.aDb = cVar;
        if (z) {
            gz(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aDb == null) {
            return false;
        }
        return (this.aDb.aDf == cVar.aDf && this.aDb.aDo == cVar.aDo && TextUtils.equals(this.aDb.aDi, cVar.aDi) && this.aDb.aDw == cVar.aDw && this.aDb.aDt == cVar.aDt && this.aDb.aDu == cVar.aDu && this.aDb.aDv == cVar.aDv && this.aDb.mDirection == cVar.mDirection && this.aDb.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(com.baidu.swan.apps.media.d.c cVar) {
        aGs().setMuted(cVar.aDf);
        aGs().setLooping(cVar.mLoop);
    }

    private void gz(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dfB != null && !z && isPlaying()) {
            this.dfB.pausePlay();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(com.baidu.swan.apps.media.d.c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aBc);
        i(cVar);
        this.aDb = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aGo();
        reset();
        g(this.aDb);
        a(this.aDb, false);
        e(this.aDb);
        aGt().cq(cVar.aDg, cVar.aDi);
        aGp();
    }

    public void h(com.baidu.swan.apps.media.d.c cVar) {
        aGt().j(cVar);
        aGr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGm() {
        final Activity activity;
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null || (activity = Md.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ah(activity);
                SwanAppNAViewContainer aGz = a.this.aGt().aGz();
                aGz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aGz);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aGz);
                d.a(a.this.aDb.aBc, a.this.aDb.aDU, true, a.this.aGt());
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
    public boolean aGn() {
        Activity activity;
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null || (activity = Md.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAppNAViewContainer aGz = a.this.aGt().aGz();
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aGz);
                com.baidu.swan.apps.view.container.c.c.a(aGz, ac.ix(aGz.getSlaveId()));
                d.a(a.this.aDb.aBc, a.this.aDb.aDU, false, a.this.aGt());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aDb != null && cVar != null && !TextUtils.isEmpty(this.aDb.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.aDb.mSrc, cVar.mSrc)) {
            this.dfE = true;
        } else {
            this.dfE = false;
        }
    }

    private void aGo() {
        if (aGs() != null) {
            this.dfB.stopPlay();
        }
    }

    private void aGp() {
        aGt().j(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Hp()) {
            aGt().aGx();
            reset();
            g(this.aDb);
            a(this.aDb, false);
            e(this.aDb);
            aGs().cs(this.aDb.mSrc, "");
            this.dfE = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void pause() {
        aGs().pausePlay();
        this.dfD = true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void resume() {
        if (this.dfD && !this.dfE) {
            aGs().bLc();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void seekTo(int i) {
        if (Hp()) {
            if (!this.dfE) {
                aGs().seekTo(i);
            } else {
                this.cXF = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getDuration() {
        return aGs().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getCurrentPosition() {
        return aGs().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isEnd() {
        return this.dfF;
    }

    private void initListener() {
        aGs().setVideoPlayerCallback(new C0281a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGq() {
        if (!this.asc) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isPlaying() {
        return aGs().pB();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean onBackPressed() {
        return isLandscape() && aGn();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void Fl() {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void setFullScreen(boolean z) {
        if (z) {
            aGm();
        } else {
            aGn();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void eG(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(com.baidu.swan.apps.media.d.c cVar) {
    }

    private void aGr() {
        if (aGs() != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dfB.cdO());
            if (this.dfG != null) {
                this.dfG.addView(this.dfB.cdO());
            } else {
                aGt().aGw().addView(this.dfB.cdO());
            }
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aGs() {
        if (this.dfB == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dfB = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) this.mContext, true);
            this.dfB.e(aGt().aGz());
            initListener();
        }
        return this.dfB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aGt() {
        if (this.dfC == null) {
            this.dfC = new b(this.mContext);
        }
        return this.dfC;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void br(boolean z) {
        aGs().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bs(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", IntentConfig.STOP);
        if (this.dfB != null) {
            aGs().aGh();
        }
        reset();
    }

    public void reset() {
        if (this.dfB != null) {
            this.dfB.stopPlay();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dfB.hfu);
            this.dfB = null;
        }
    }

    private boolean Hp() {
        return (this.aDb == null || TextUtils.isEmpty(this.aDb.mSrc) || TextUtils.isEmpty(this.aDb.aBc) || TextUtils.isEmpty(this.aDb.id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGu() {
        if (Hp()) {
            if (this.cXF != 0) {
                aGs().seekTo(this.cXF);
                this.cXF = 0;
            } else if (this.aDb.aDh != 0) {
                this.dfB.seekTo(this.aDb.aDh * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0281a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0281a() {
        }

        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            a.this.dfD = false;
            d.a(a.this.aDb.aBc, a.this.aDb.aDU, "ended", new JSONObject());
            if (a.this.dfJ != null) {
                a.this.dfJ.a(a.this);
            }
            a.this.dfF = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.play.g.b
        public boolean onError(g gVar, int i, int i2) {
            a.this.dfD = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aGt().aGx();
            a.this.aGt().aGy();
            if (a.this.dfI != null) {
                a.this.dfI.a(a.this, i, i2);
            }
            a.this.dfF = false;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
            return true;
        }

        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aGu();
            a.this.aGq();
            if (a.this.dfH != null) {
                a.this.dfH.b(a.this);
            }
            a.this.dfF = false;
            a.this.dfD = false;
            d.a(a.this.aDb.aBc, a.this.aDb.aDU, "play", new JSONObject());
            a.this.aGt().aGy();
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void gA(boolean z) {
            if (z) {
                a.this.aGm();
            } else {
                a.this.aGn();
            }
        }
    }
}
