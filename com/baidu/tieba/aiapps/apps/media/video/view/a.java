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
    private SwanAppNAViewContainer akp;
    private com.baidu.tieba.aiapps.apps.media.video.c cVL;
    private boolean cVM;
    private com.baidu.swan.apps.model.a.a.a cVN;
    private ConfigurationChangedListenFragment cVO;
    private boolean cVP;
    private boolean isFullScreen;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.cVL = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.cVM = false;
        this.isFullScreen = false;
        this.cVP = false;
        b.a(this);
        a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0368c
            public void qj() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.akp != null) {
                        boolean ql = a.this.ql();
                        if (ql) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.bSZ().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.bSZ());
                        }
                        viewGroup.addView(a.this.bSZ());
                        a.this.fZ(true);
                        if (ql) {
                            a.this.gHW.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bAK();
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
                    if (a.this.akp != null) {
                        boolean ql = a.this.ql();
                        if (ql) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.bSZ().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.bSZ());
                        }
                        a.this.akp.MK();
                        a.this.akp.a(a.this.bSZ(), a.this.cVN);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.fZ(false);
                        if (ql) {
                            a.this.gHW.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bAK();
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
                d.a(a.this.Ei(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.cVP = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPaused() {
                d.a(a.this.Ei(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.cVP = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPlayEnd() {
                d.a(a.this.Ei(), a.this.getSlaveId(), "ended", new JSONObject());
                a.this.cVP = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void azH() {
                a.this.cVP = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void lV(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                }
                d.a(a.this.Ei(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.o
            public void azI() {
                d.a(a.this.Ei(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.cVP = true;
            }
        });
        this.cVO = new ConfigurationChangedListenFragment();
        this.cVO.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.bSF()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.cVO, "onCon").commitAllowingStateLoss();
        oP(false);
    }

    public com.baidu.tieba.aiapps.apps.media.video.c azF() {
        return this.cVL;
    }

    public void a(com.baidu.tieba.aiapps.apps.media.video.c cVar) {
        this.cVL = cVar;
        azG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (bSG()) {
                    width = l.aO(this.mActivity);
                    height = l.aQ(this.mActivity);
                } else {
                    int aO = l.aO(this.mActivity);
                    width = l.aQ(this.mActivity);
                    height = aO;
                }
            } else {
                width = this.cVN.aBF.getWidth();
                height = this.cVN.aBF.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(Ei(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    private void azG() {
        if (this.cVL.cVz) {
            setVolume(0);
        }
        getVideoView().setLooping(this.cVL.mLoop);
        if (this.cVL.cVf) {
            bSI();
        }
        oZ(!this.cVL.cVG);
        if (!StringUtils.isNull(this.cVL.cVA)) {
            setThumbnail(this.cVL.cVA);
        }
        bSZ().setVisibility(this.cVL.hidden ? 8 : 0);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ei() {
        return this.cVL == null ? "" : this.cVL.azs;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVL == null ? "" : this.cVL.aBD;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ek() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bk(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.cVM = true;
                return;
            }
            return;
        }
        if (this.cVM) {
            bAK();
        }
        this.cVM = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.akp = swanAppNAViewContainer;
        this.cVN = this.akp.getModel().EM();
    }

    @Override // com.baidu.swan.apps.media.a
    public void bl(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.cVM = true;
                return;
            }
            return;
        }
        if (this.cVM) {
            bAK();
        }
        this.cVM = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (bSG()) {
            bSJ();
        } else {
            bAB();
        }
        return true;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        ViewGroup viewGroup = (ViewGroup) bSZ().getParent();
        if (viewGroup != null) {
            bnQ();
            viewGroup.removeView(bSZ());
            this.akp.MK();
        }
        if (this.dbc != null) {
            this.dbc.stopPlayback();
        }
        bSE();
        b.b(this);
    }

    public void ga(boolean z) {
        if (z != this.isFullScreen) {
            setFullScreenToDestroySurface();
            if (bSG()) {
                if (this.UT) {
                    bSJ();
                } else {
                    bSI();
                }
                oR(this.UT);
                return;
            }
            bAB();
        }
    }

    @Override // com.baidu.tieba.play.c
    public void cf(String str, String str2) {
        if (!j.kM()) {
            bnQ();
            e.jH().removeCallbacks(this.gII);
            this.ekF.setVisibility(0);
            return;
        }
        super.cf(str, str2);
    }

    public boolean hasStart() {
        return this.cVP;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ej() {
        return null;
    }
}
