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
    private c bEp;
    private int eaD;
    private SwanVideoView eeU;
    private VideoContainerManager eeV;
    private boolean eeW;
    private boolean eeX;
    private boolean eeY;
    private FrameLayout eeZ;
    private l.d efa;
    private l.b efb;
    private l.a efc;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsForeground = true;
    private int efd = 0;

    @Override // com.baidu.swan.apps.w.b.l
    public void HS() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void HU() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.w.b.l
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bEp = cVar;
        baq();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.efa = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.efb = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.efc = aVar;
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
        bap().setVideoPath(this.bEp.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eeZ = frameLayout;
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
        this.bEp = cVar;
        if (z) {
            hH(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.bEp == null) {
            return false;
        }
        return (this.bEp.bEt == cVar.bEt && this.bEp.bEC == cVar.bEC && TextUtils.equals(this.bEp.bEw, cVar.bEw) && this.bEp.bEK == cVar.bEK && this.bEp.bEH == cVar.bEH && this.bEp.bEI == cVar.bEI && this.bEp.bEJ == cVar.bEJ && this.bEp.mDirection == cVar.mDirection && this.bEp.mLoop == cVar.mLoop) ? false : true;
    }

    private void g(c cVar) {
        bap().setMuted(cVar.bEt);
        bap().setMediaControllerEnabled(cVar.bEC);
        bap().setLooping(cVar.mLoop);
        if (TextUtils.equals(cVar.bEw, "cover")) {
            bap().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.bEw, "fill")) {
            bap().setVideoScalingMode(3);
        } else {
            bap().setVideoScalingMode(1);
        }
    }

    private void hH(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.eeU != null && !z && isPlaying()) {
            this.eeU.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bAL);
        i(cVar);
        this.bEp = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        bal();
        bam();
        baq().cN(cVar.bEu, cVar.bEw);
    }

    public void h(c cVar) {
        baq().j(cVar);
        bao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baj() {
        final Activity activity;
        e acI = e.acI();
        if (acI == null || (activity = acI.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.ai(activity);
                SwanAppComponentContainerView bav = a.this.baq().bav();
                bav.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(bav);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, bav);
                b.a(a.this.bEp.bAL, a.this.bEp.biB, true, a.this.baq());
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
    public boolean bak() {
        Activity activity;
        e acI = e.acI();
        if (acI == null || (activity = acI.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(a.this.baq().bav());
                a.this.baq().KI();
                b.a(a.this.bEp.bAL, a.this.bEp.biB, false, a.this.baq());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.bEp != null && cVar != null && !TextUtils.isEmpty(this.bEp.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.bEp.mSrc, cVar.mSrc)) {
            this.eeX = true;
        } else {
            this.eeX = false;
        }
    }

    private void bal() {
        if (this.eeU != null) {
            this.eeU.stopPlayback();
        }
    }

    private void bam() {
        baq().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (Yj()) {
            baq().bat();
            reset();
            bap().baF();
            g(this.bEp);
            a(this.bEp, false);
            e(this.bEp);
            bap().start();
            this.eeX = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        bap().pause();
        this.eeW = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.eeW && !this.eeX) {
            bap().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (Yj()) {
            if (!this.eeX) {
                bap().seekTo(i);
            } else {
                this.eaD = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return bap().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return bap().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.eeY;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void f(boolean z, int i) {
        if (z) {
            baj();
        } else {
            bak();
        }
    }

    private void initListener() {
        bap().setVideoPlayerCallback(new C0416a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ban() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.eeU == null) {
            return false;
        }
        return this.eeU.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && bak();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void Vo() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void ii(String str) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(c cVar) {
    }

    private void bao() {
        if (this.eeU != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eeU);
            if (this.eeZ != null) {
                this.eeZ.addView(this.eeU);
            } else {
                baq().getVideoHolder().addView(this.eeU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView bap() {
        if (this.eeU == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.eeU = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.eeU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager baq() {
        if (this.bEp == null) {
            com.baidu.swan.apps.component.e.a.at("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eeV == null) {
            this.eeV = new VideoContainerManager(this.mContext, this.bEp);
        }
        return this.eeV;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cK(boolean z) {
        bap().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cL(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        bap().release();
    }

    public void reset() {
        if (this.eeU != null) {
            this.eeU.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.eeU);
            this.eeU = null;
        }
    }

    private boolean Yj() {
        return (this.bEp == null || TextUtils.isEmpty(this.bEp.mSrc) || TextUtils.isEmpty(this.bEp.bAL) || TextUtils.isEmpty(this.bEp.biA)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bar() {
        if (Yj()) {
            if (this.eaD != 0) {
                bap().seekTo(this.eaD);
                this.eaD = 0;
            } else if (this.bEp.bEv != 0) {
                this.eeU.seekTo(this.bEp.bEv * 1000);
                this.bEp.bEv = 0;
            } else if (this.efd != 0) {
                this.eeU.seekTo(this.efd);
                this.efd = 0;
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
            a.this.eeW = false;
            b.a(a.this.bEp.bAL, a.this.bEp.biB, "ended", new JSONObject());
            if (a.this.efc != null) {
                a.this.efc.b(a.this);
            }
            a.this.eeY = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void g(int i, int i2, String str) {
            a.this.eeW = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.baq().bat();
            a.this.baq().bau();
            b.a(a.this.bEp.bAL, a.this.bEp.biB, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.os(i2));
            if (a.this.efb != null) {
                a.this.efb.a(a.this, i, i2);
            }
            a.this.eeY = false;
            int currentPosition = a.this.bap().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.efd;
            }
            aVar.efd = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.bar();
            a.this.ban();
            if (a.this.efa != null) {
                a.this.efa.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void hI(boolean z) {
            if (z) {
                a.this.baj();
            } else {
                a.this.bak();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition();
            int duration = swanVideoView.getDuration();
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition < bufferPercentage || currentPosition == 0 || (currentPosition > 0 && bufferPercentage == 0)) {
                com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                bc(currentPosition, duration);
                return;
            }
            com.baidu.swan.apps.console.c.d("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            b.a(a.this.bEp.bAL, a.this.bEp.biB, "waiting", new JSONObject());
        }

        private void bc(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            b.a(a.this.bEp.bAL, a.this.bEp.biB, "timeupdate", jSONObject);
        }
    }
}
