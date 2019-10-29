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
    private boolean aLQ = true;
    private com.baidu.swan.apps.media.d.c aWO;
    private int diR;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dqO;
    private b dqP;
    private boolean dqQ;
    private boolean dqR;
    private boolean dqS;
    private FrameLayout dqT;
    private v.c dqU;
    private v.b dqV;
    private v.a dqW;
    private Context mContext;
    private boolean mIsLandscape;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.b.v
    /* renamed from: dg */
    public a bi(Context context) {
        this.mContext = context;
        aHm();
        return this;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.c cVar) {
        this.dqU = cVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.b bVar) {
        this.dqV = bVar;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(v.a aVar) {
        this.dqW = aVar;
    }

    private void e(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        aHl().setVideoUrl(this.aWO.mSrc, "");
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(FrameLayout frameLayout) {
        this.dqT = frameLayout;
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
        this.aWO = cVar;
        if (z) {
            gr(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aWO == null) {
            return false;
        }
        return (this.aWO.aWS == cVar.aWS && this.aWO.aXb == cVar.aXb && TextUtils.equals(this.aWO.aWV, cVar.aWV) && this.aWO.aXj == cVar.aXj && this.aWO.aXg == cVar.aXg && this.aWO.aXh == cVar.aXh && this.aWO.aXi == cVar.aXi && this.aWO.mDirection == cVar.mDirection && this.aWO.aUY == cVar.aUY) ? false : true;
    }

    private void g(com.baidu.swan.apps.media.d.c cVar) {
        aHl().setMuted(cVar.aWS);
        aHl().setLooping(cVar.aUY);
    }

    private void gr(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.dqO != null && !z && isPlaying()) {
            this.dqO.pausePlay();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void a(com.baidu.swan.apps.media.d.c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.aUO);
        i(cVar);
        this.aWO = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aHh();
        reset();
        g(this.aWO);
        a(this.aWO, false);
        e(this.aWO);
        aHm().ck(cVar.aWT, cVar.aWV);
        aHi();
    }

    public void h(com.baidu.swan.apps.media.d.c cVar) {
        aHm().j(cVar);
        aHk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHf() {
        final Activity activity;
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null || (activity = QZ.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.Z(activity);
                SwanAppNAViewContainer aHs = a.this.aHm().aHs();
                aHs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aHs);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aHs);
                d.a(a.this.aWO.aUO, a.this.aWO.aXH, true, a.this.aHm());
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
    public boolean aHg() {
        Activity activity;
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null || (activity = QZ.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAppNAViewContainer aHs = a.this.aHm().aHs();
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aHs);
                com.baidu.swan.apps.view.container.c.c.a(aHs, ac.jc(aHs.getSlaveId()));
                d.a(a.this.aWO.aUO, a.this.aWO.aXH, false, a.this.aHm());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(com.baidu.swan.apps.media.d.c cVar) {
        if (this.aWO != null && cVar != null && !TextUtils.isEmpty(this.aWO.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.aWO.mSrc, cVar.mSrc)) {
            this.dqR = true;
        } else {
            this.dqR = false;
        }
    }

    private void aHh() {
        if (aHl() != null) {
            this.dqO.stopPlay();
        }
    }

    private void aHi() {
        aHm().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Mn()) {
            aHm().aHq();
            reset();
            g(this.aWO);
            a(this.aWO, false);
            e(this.aWO);
            aHl().cm(this.aWO.mSrc, "");
            this.dqR = false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void pause() {
        aHl().pausePlay();
        this.dqQ = true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void resume() {
        if (this.dqQ && !this.dqR) {
            aHl().bIM();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void seekTo(int i) {
        if (Mn()) {
            if (!this.dqR) {
                aHl().seekTo(i);
            } else {
                this.diR = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getDuration() {
        return aHl().getDuration();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public int getCurrentPosition() {
        return aHl().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isEnd() {
        return this.dqS;
    }

    private void initListener() {
        aHl().setVideoPlayerCallback(new C0328a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHj() {
        if (!this.aLQ) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean isPlaying() {
        return aHl().kx();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean onBackPressed() {
        return isLandscape() && aHg();
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void Kj() {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void setFullScreen(boolean z) {
        if (z) {
            aHf();
        } else {
            aHg();
        }
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void fp(String str) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void b(com.baidu.swan.apps.media.d.c cVar) {
    }

    private void aHk() {
        if (aHl() != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dqO.cbX());
            if (this.dqT != null) {
                this.dqT.addView(this.dqO.cbX());
            } else {
                aHm().aHp().addView(this.dqO.cbX());
            }
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aHl() {
        if (this.dqO == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.dqO = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) this.mContext, true);
            this.dqO.e(aHm().aHs());
            initListener();
        }
        return this.dqO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aHm() {
        if (this.dqP == null) {
            this.dqP = new b(this.mContext);
        }
        return this.dqP;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bJ(boolean z) {
        aHl().setMuted(z);
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void bK(boolean z) {
    }

    @Override // com.baidu.swan.apps.u.b.v
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        if (this.dqO != null) {
            aHl().aHa();
        }
        reset();
    }

    public void reset() {
        if (this.dqO != null) {
            this.dqO.stopPlay();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.dqO.hgl);
            this.dqO = null;
        }
    }

    private boolean Mn() {
        return (this.aWO == null || TextUtils.isEmpty(this.aWO.mSrc) || TextUtils.isEmpty(this.aWO.aUO) || TextUtils.isEmpty(this.aWO.id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHn() {
        if (Mn()) {
            if (this.diR != 0) {
                aHl().seekTo(this.diR);
                this.diR = 0;
            } else if (this.aWO.aWU != 0) {
                this.dqO.seekTo(this.aWO.aWU * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0328a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0328a() {
        }

        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            a.this.dqQ = false;
            d.a(a.this.aWO.aUO, a.this.aWO.aXH, "ended", new JSONObject());
            if (a.this.dqW != null) {
                a.this.dqW.a(a.this);
            }
            a.this.dqS = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.play.g.b
        public boolean onError(g gVar, int i, int i2) {
            a.this.dqQ = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aHm().aHq();
            a.this.aHm().aHr();
            if (a.this.dqV != null) {
                a.this.dqV.a(a.this, i, i2);
            }
            a.this.dqS = false;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
            return true;
        }

        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aHn();
            a.this.aHj();
            if (a.this.dqU != null) {
                a.this.dqU.b(a.this);
            }
            a.this.dqS = false;
            a.this.dqQ = false;
            d.a(a.this.aWO.aUO, a.this.aWO.aXH, "play", new JSONObject());
            a.this.aHm().aHr();
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void gs(boolean z) {
            if (z) {
                a.this.aHf();
            } else {
                a.this.aHg();
            }
        }
    }
}
