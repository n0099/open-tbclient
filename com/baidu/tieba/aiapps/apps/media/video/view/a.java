package com.baidu.tieba.aiapps.apps.media.video.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.swan.apps.media.b;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tieba.aiapps.apps.media.video.d;
import com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment;
import com.baidu.tieba.play.c;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c implements com.baidu.swan.apps.media.a {
    private SwanAppNAViewContainer aku;
    private com.baidu.tieba.aiapps.apps.media.video.c cVO;
    private boolean cVP;
    private com.baidu.swan.apps.model.a.a.a cVQ;
    private ConfigurationChangedListenFragment cVR;
    private boolean cVS;
    private boolean isFullScreen;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.cVO = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.cVP = false;
        this.isFullScreen = false;
        this.cVS = false;
        b.a(this);
        a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0368c
            public void qj() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.aku != null) {
                        boolean ql = a.this.ql();
                        if (ql) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.bSV().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.bSV());
                        }
                        viewGroup.addView(a.this.bSV());
                        a.this.fZ(true);
                        if (ql) {
                            a.this.gHK.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bAH();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0368c
            public void qk() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.aku != null) {
                        boolean ql = a.this.ql();
                        if (ql) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.bSV().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.bSV());
                        }
                        a.this.aku.MI();
                        a.this.aku.a(a.this.bSV(), a.this.cVQ);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.fZ(false);
                        if (ql) {
                            a.this.gHK.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bAH();
                                }
                            }, 100L);
                        }
                    }
                }
            }
        });
        a(new c.o() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.2
            @Override // com.baidu.tieba.play.c.o
            public void onStarted() {
                d.a(a.this.Eg(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.cVS = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPaused() {
                d.a(a.this.Eg(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.cVS = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPlayEnd() {
                d.a(a.this.Eg(), a.this.getSlaveId(), "ended", new JSONObject());
                a.this.cVS = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void azE() {
                a.this.cVS = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void lU(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                }
                d.a(a.this.Eg(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.o
            public void azF() {
                d.a(a.this.Eg(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.cVS = true;
            }
        });
        this.cVR = new ConfigurationChangedListenFragment();
        this.cVR.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.bSB()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.cVR, "onCon").commitAllowingStateLoss();
        oP(false);
    }

    public com.baidu.tieba.aiapps.apps.media.video.c azC() {
        return this.cVO;
    }

    public void a(com.baidu.tieba.aiapps.apps.media.video.c cVar) {
        this.cVO = cVar;
        azD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (bSC()) {
                    width = l.aO(this.mActivity);
                    height = l.aQ(this.mActivity);
                } else {
                    int aO = l.aO(this.mActivity);
                    width = l.aQ(this.mActivity);
                    height = aO;
                }
            } else {
                width = this.cVQ.aBJ.getWidth();
                height = this.cVQ.aBJ.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(Eg(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    private void azD() {
        if (this.cVO.cVC) {
            setVolume(0);
        }
        getVideoView().setLooping(this.cVO.mLoop);
        if (this.cVO.cVi) {
            bSE();
        }
        oZ(!this.cVO.cVJ);
        if (!StringUtils.isNull(this.cVO.cVD)) {
            setThumbnail(this.cVO.cVD);
        }
        bSV().setVisibility(this.cVO.hidden ? 8 : 0);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.cVO == null ? "" : this.cVO.azw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVO == null ? "" : this.cVO.aBH;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ei() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bk(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.cVP = true;
                return;
            }
            return;
        }
        if (this.cVP) {
            bAH();
        }
        this.cVP = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.aku = swanAppNAViewContainer;
        this.cVQ = this.aku.getModel().EK();
    }

    @Override // com.baidu.swan.apps.media.a
    public void bl(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.cVP = true;
                return;
            }
            return;
        }
        if (this.cVP) {
            bAH();
        }
        this.cVP = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (bSC()) {
            bSF();
        } else {
            bAy();
        }
        return true;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        ViewGroup viewGroup = (ViewGroup) bSV().getParent();
        if (viewGroup != null) {
            bnN();
            viewGroup.removeView(bSV());
            this.aku.MI();
        }
        if (this.dbg != null) {
            this.dbg.stopPlayback();
        }
        bSA();
        b.b(this);
    }

    public void ga(boolean z) {
        if (z != this.isFullScreen) {
            setFullScreenToDestroySurface();
            if (bSC()) {
                if (this.UU) {
                    bSF();
                } else {
                    bSE();
                }
                oR(this.UU);
                return;
            }
            bAy();
        }
    }

    @Override // com.baidu.tieba.play.c
    public void cf(String str, String str2) {
        if (!j.kM()) {
            bnN();
            e.jH().removeCallbacks(this.gIw);
            this.eks.setVisibility(0);
            return;
        }
        super.cf(str, str2);
    }

    public boolean hasStart() {
        return this.cVS;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eh() {
        return null;
    }
}
