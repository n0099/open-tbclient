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
/* loaded from: classes10.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c bzW;
    private int dVV;
    private SwanVideoView ean;
    private VideoContainerManager eao;
    private boolean eap;
    private boolean eaq;
    private boolean ear;
    private FrameLayout eas;
    private l.d eat;
    private l.b eau;
    private l.a eav;
    private Context mContext;
    private boolean mIsLandscape;
    private boolean mIsForeground = true;
    private int eaw = 0;

    @Override // com.baidu.swan.apps.w.b.l
    public void Fy() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void FA() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.w.b.l
    /* renamed from: b */
    public a a(Context context, @NonNull c cVar) {
        this.mContext = context;
        this.bzW = cVar;
        aXU();
        return this;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.d dVar) {
        this.eat = dVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.b bVar) {
        this.eau = bVar;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(l.a aVar) {
        this.eav = aVar;
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
        aXT().setVideoPath(this.bzW.mSrc);
        com.baidu.swan.apps.console.c.d("video", "setDataSource url " + cVar.mSrc);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(FrameLayout frameLayout) {
        this.eas = frameLayout;
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
        this.bzW = cVar;
        if (z) {
            hz(cVar.isVisible());
        }
        h(cVar);
    }

    private boolean f(c cVar) {
        if (this.bzW == null) {
            return false;
        }
        return (this.bzW.bAa == cVar.bAa && this.bzW.bAj == cVar.bAj && TextUtils.equals(this.bzW.bAd, cVar.bAd) && this.bzW.bAr == cVar.bAr && this.bzW.bAo == cVar.bAo && this.bzW.bAp == cVar.bAp && this.bzW.bAq == cVar.bAq && this.bzW.mDirection == cVar.mDirection && this.bzW.bwy == cVar.bwy) ? false : true;
    }

    private void g(c cVar) {
        aXT().setMuted(cVar.bAa);
        aXT().setMediaControllerEnabled(cVar.bAj);
        aXT().setLooping(cVar.bwy);
        if (TextUtils.equals(cVar.bAd, "cover")) {
            aXT().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.bAd, "fill")) {
            aXT().setVideoScalingMode(3);
        } else {
            aXT().setVideoScalingMode(1);
        }
    }

    private void hz(boolean z) {
        if (DEBUG) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.ean != null && !z && isPlaying()) {
            this.ean.pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void a(c cVar) {
        com.baidu.swan.apps.console.c.d("video", "Open Player " + cVar.bwp);
        i(cVar);
        this.bzW = cVar;
        h(cVar);
        if (cVar.isAutoPlay() && cVar.isVisible()) {
            start();
            return;
        }
        aXP();
        aXQ();
        aXU().cF(cVar.bAb, cVar.bAd);
    }

    public void h(c cVar) {
        aXU().j(cVar);
        aXS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXN() {
        final Activity activity;
        e aap = e.aap();
        if (aap == null || (activity = aap.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                a.this.af(activity);
                SwanAppComponentContainerView aXZ = a.this.aXU().aXZ();
                aXZ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(aXZ);
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.e(activity, aXZ);
                b.a(a.this.bzW.bwp, a.this.bzW.bdW, true, a.this.aXU());
            }
        });
        this.mIsLandscape = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXO() {
        Activity activity;
        e aap = e.aap();
        if (aap == null || (activity = aap.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(a.this.aXU().aXZ());
                a.this.aXU().Io();
                b.a(a.this.bzW.bwp, a.this.bzW.bdW, false, a.this.aXU());
            }
        });
        this.mIsLandscape = false;
        return true;
    }

    private void i(c cVar) {
        if (this.bzW != null && cVar != null && !TextUtils.isEmpty(this.bzW.mSrc) && !TextUtils.isEmpty(cVar.mSrc) && !TextUtils.equals(this.bzW.mSrc, cVar.mSrc)) {
            this.eaq = true;
        } else {
            this.eaq = false;
        }
    }

    private void aXP() {
        if (this.ean != null) {
            this.ean.stopPlayback();
        }
    }

    private void aXQ() {
        aXU().k(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.video.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.start();
            }
        });
    }

    public void start() {
        if (VQ()) {
            aXU().aXX();
            reset();
            aXT().aYj();
            g(this.bzW);
            a(this.bzW, false);
            e(this.bzW);
            aXT().start();
            this.eaq = false;
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void pause() {
        aXT().pause();
        this.eap = true;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void resume() {
        if (this.eap && !this.eaq) {
            aXT().start();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void seekTo(int i) {
        if (VQ()) {
            if (!this.eaq) {
                aXT().seekTo(i);
            } else {
                this.dVV = i;
            }
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getDuration() {
        return aXT().getDuration();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public int getCurrentPosition() {
        return aXT().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isEnd() {
        return this.ear;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void e(boolean z, int i) {
        if (z) {
            aXN();
        } else {
            aXO();
        }
    }

    private void initListener() {
        aXT().setVideoPlayerCallback(new C0405a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXR() {
        if (!this.mIsForeground) {
            pause();
        }
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean isPlaying() {
        if (this.ean == null) {
            return false;
        }
        return this.ean.isPlaying();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public boolean onBackPressed() {
        return isLandscape() && aXO();
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void SV() {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void hT(String str) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void b(c cVar) {
    }

    private void aXS() {
        if (this.ean != null) {
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.ean);
            if (this.eas != null) {
                this.eas.addView(this.ean);
            } else {
                aXU().getVideoHolder().addView(this.ean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SwanVideoView aXT() {
        if (this.ean == null) {
            com.baidu.swan.apps.console.c.i("video", "create player");
            this.ean = new SwanVideoView(this.mContext);
            initListener();
        }
        return this.ean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoContainerManager aXU() {
        if (this.bzW == null) {
            com.baidu.swan.apps.component.e.a.ak("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.eao == null) {
            this.eao = new VideoContainerManager(this.mContext, this.bzW);
        }
        return this.eao;
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cC(boolean z) {
        aXT().setMuted(z);
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void cD(boolean z) {
    }

    @Override // com.baidu.swan.apps.w.b.l
    public void stop() {
        com.baidu.swan.apps.console.c.d("video", "stop");
        reset();
        aXT().release();
    }

    public void reset() {
        if (this.ean != null) {
            this.ean.stopPlayback();
            com.baidu.tieba.aiapps.apps.media.videoplayer.c.bs(this.ean);
            this.ean = null;
        }
    }

    private boolean VQ() {
        return (this.bzW == null || TextUtils.isEmpty(this.bzW.mSrc) || TextUtils.isEmpty(this.bzW.bwp) || TextUtils.isEmpty(this.bzW.bdV)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXV() {
        if (VQ()) {
            if (this.dVV != 0) {
                aXT().seekTo(this.dVV);
                this.dVV = 0;
            } else if (this.bzW.bAc != 0) {
                this.ean.seekTo(this.bzW.bAc * 1000);
                this.bzW.bAc = 0;
            } else if (this.eaw != 0) {
                this.ean.seekTo(this.eaw);
                this.eaw = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0405a extends com.baidu.tieba.aiapps.apps.media.videoplayer.a.b {
        private C0405a() {
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onEnd() {
            a.this.eap = false;
            b.a(a.this.bzW.bwp, a.this.bzW.bdW, "ended", new JSONObject());
            if (a.this.eav != null) {
                a.this.eav.b(a.this);
            }
            a.this.ear = true;
            com.baidu.swan.apps.console.c.d("video", "onEnded call back");
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void g(int i, int i2, String str) {
            a.this.eap = false;
            com.baidu.swan.apps.console.c.e("video", "errorCode :" + i);
            a.this.aXU().aXX();
            a.this.aXU().aXY();
            b.a(a.this.bzW.bwp, a.this.bzW.bdW, BdStatsConstant.StatsType.ERROR, com.baidu.tieba.aiapps.apps.media.b.b.nZ(i2));
            if (a.this.eau != null) {
                a.this.eau.a(a.this, i, i2);
            }
            a.this.ear = false;
            int currentPosition = a.this.aXT().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = a.this.eaw;
            }
            aVar.eaw = currentPosition;
            com.baidu.swan.apps.console.c.e("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void onPrepared() {
            com.baidu.swan.apps.console.c.d("video", "onPrepared call back");
            a.this.aXV();
            a.this.aXR();
            if (a.this.eat != null) {
                a.this.eat.a(a.this);
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b, com.baidu.tieba.aiapps.apps.media.videoplayer.a.a
        public void hA(boolean z) {
            if (z) {
                a.this.aXN();
            } else {
                a.this.aXO();
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
            b.a(a.this.bzW.bwp, a.this.bzW.bdW, "waiting", new JSONObject());
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
            b.a(a.this.bzW.bwp, a.this.bzW.bdW, "timeupdate", jSONObject);
        }
    }
}
