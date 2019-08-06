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
    private int cXM;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dfI;
    private b dfJ;
    private boolean dfK;
    private boolean dfL;
    private boolean dfM;
    private FrameLayout dfN;
    private v.c dfO;
    private v.b dfP;
    private v.a dfQ;
    private Context mContext;
    private boolean mIsLandscape;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.v
    /* renamed from: dw */
    public a bg(Context context) {
        this.mContext = context;
        aGv();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.c cVar) {
        this.dfO = cVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.b bVar) {
        this.dfP = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.a aVar) {
        this.dfQ = aVar;
    }

    private void e(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aGu().setVideoUrl(this.aDb.mSrc, "");
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(FrameLayout frameLayout) {
        this.dfN = frameLayout;
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
        aGu().setMuted(cVar.aDf);
        aGu().setLooping(cVar.mLoop);
    }

    private void gz(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dfI != null && !z && isPlaying()) {
            this.dfI.pausePlay();
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
        aGq();
        reset();
        g(this.aDb);
        a(this.aDb, false);
        e(this.aDb);
        aGv().cq(cVar.aDg, cVar.aDi);
        aGr();
    }

    public void h(com.baidu.swan.apps.media.d.c cVar) {
        aGv().j(cVar);
        aGt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGo() {
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
                SwanAppNAViewContainer aGB = a.this.aGv().aGB();
                aGB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aGB);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aGB);
                d.a(a.this.aDb.aBc, a.this.aDb.aDU, true, a.this.aGv());
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
    public boolean aGp() {
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
                SwanAppNAViewContainer aGB = a.this.aGv().aGB();
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aGB);
                com.baidu.swan.apps.view.container.c.c.a(aGB, ac.ix(aGB.getSlaveId()));
                d.a(a.this.aDb.aBc, a.this.aDb.aDU, false, a.this.aGv());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aDb != null && cVar != null && !TextUtils.isEmpty(this.aDb.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.aDb.mSrc, cVar.mSrc)) {
            this.dfL = true;
        } else {
            this.dfL = false;
        }
    }

    private void aGq() {
        if (aGu() != null) {
            this.dfI.stopPlay();
        }
    }

    private void aGr() {
        aGv().j(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Hp()) {
            aGv().aGz();
            reset();
            g(this.aDb);
            a(this.aDb, false);
            e(this.aDb);
            aGu().cs(this.aDb.mSrc, "");
            this.dfL = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void pause() {
        aGu().pausePlay();
        this.dfK = true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void resume() {
        if (this.dfK && !this.dfL) {
            aGu().bLq();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void seekTo(int i) {
        if (Hp()) {
            if (!this.dfL) {
                aGu().seekTo(i);
            } else {
                this.cXM = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getDuration() {
        return aGu().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getCurrentPosition() {
        return aGu().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isEnd() {
        return this.dfM;
    }

    private void initListener() {
        aGu().setVideoPlayerCallback(new C0287a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGs() {
        if (!this.asc) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isPlaying() {
        return aGu().pB();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean onBackPressed() {
        return isLandscape() && aGp();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void Fl() {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void setFullScreen(boolean z) {
        if (z) {
            aGo();
        } else {
            aGp();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void eG(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(com.baidu.swan.apps.media.d.c cVar) {
    }

    private void aGt() {
        if (aGu() != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dfI.ceg());
            if (this.dfN != null) {
                this.dfN.addView(this.dfI.ceg());
            } else {
                aGv().aGy().addView(this.dfI.ceg());
            }
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aGu() {
        if (this.dfI == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dfI = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) this.mContext, true);
            this.dfI.e(aGv().aGB());
            initListener();
        }
        return this.dfI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aGv() {
        if (this.dfJ == null) {
            this.dfJ = new b(this.mContext);
        }
        return this.dfJ;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void br(boolean z) {
        aGu().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bs(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", IntentConfig.STOP);
        if (this.dfI != null) {
            aGu().aGj();
        }
        reset();
    }

    public void reset() {
        if (this.dfI != null) {
            this.dfI.stopPlay();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dfI.hgm);
            this.dfI = null;
        }
    }

    private boolean Hp() {
        return (this.aDb == null || TextUtils.isEmpty(this.aDb.mSrc) || TextUtils.isEmpty(this.aDb.aBc) || TextUtils.isEmpty(this.aDb.id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGw() {
        if (Hp()) {
            if (this.cXM != 0) {
                aGu().seekTo(this.cXM);
                this.cXM = 0;
            } else if (this.aDb.aDh != 0) {
                this.dfI.seekTo(this.aDb.aDh * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0287a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0287a() {
        }

        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            a.this.dfK = false;
            d.a(a.this.aDb.aBc, a.this.aDb.aDU, "ended", new JSONObject());
            if (a.this.dfQ != null) {
                a.this.dfQ.a(a.this);
            }
            a.this.dfM = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.play.g.b
        public boolean onError(g gVar, int i, int i2) {
            a.this.dfK = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aGv().aGz();
            a.this.aGv().aGA();
            if (a.this.dfP != null) {
                a.this.dfP.a(a.this, i, i2);
            }
            a.this.dfM = false;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
            return true;
        }

        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aGw();
            a.this.aGs();
            if (a.this.dfO != null) {
                a.this.dfO.b(a.this);
            }
            a.this.dfM = false;
            a.this.dfK = false;
            d.a(a.this.aDb.aBc, a.this.aDb.aDU, "play", new JSONObject());
            a.this.aGv().aGA();
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void gA(boolean z) {
            if (z) {
                a.this.aGo();
            } else {
                a.this.aGp();
            }
        }
    }
}
