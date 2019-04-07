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
    private SwanAppNAViewContainer akt;
    private com.baidu.tieba.aiapps.apps.media.video.c cVN;
    private boolean cVO;
    private com.baidu.swan.apps.model.a.a.a cVP;
    private ConfigurationChangedListenFragment cVQ;
    private boolean cVR;
    private boolean isFullScreen;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.cVN = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.cVO = false;
        this.isFullScreen = false;
        this.cVR = false;
        b.a(this);
        a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0368c
            public void qj() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.akt != null) {
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
                            a.this.gHJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
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
                    if (a.this.akt != null) {
                        boolean ql = a.this.ql();
                        if (ql) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.bSV().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.bSV());
                        }
                        a.this.akt.MI();
                        a.this.akt.a(a.this.bSV(), a.this.cVP);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.fZ(false);
                        if (ql) {
                            a.this.gHJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
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
                a.this.cVR = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPaused() {
                d.a(a.this.Eg(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.cVR = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPlayEnd() {
                d.a(a.this.Eg(), a.this.getSlaveId(), "ended", new JSONObject());
                a.this.cVR = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void azE() {
                a.this.cVR = false;
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
                a.this.cVR = true;
            }
        });
        this.cVQ = new ConfigurationChangedListenFragment();
        this.cVQ.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.bSB()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.cVQ, "onCon").commitAllowingStateLoss();
        oP(false);
    }

    public com.baidu.tieba.aiapps.apps.media.video.c azC() {
        return this.cVN;
    }

    public void a(com.baidu.tieba.aiapps.apps.media.video.c cVar) {
        this.cVN = cVar;
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
                width = this.cVP.aBI.getWidth();
                height = this.cVP.aBI.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(Eg(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    private void azD() {
        if (this.cVN.cVB) {
            setVolume(0);
        }
        getVideoView().setLooping(this.cVN.mLoop);
        if (this.cVN.cVh) {
            bSE();
        }
        oZ(!this.cVN.cVI);
        if (!StringUtils.isNull(this.cVN.cVC)) {
            setThumbnail(this.cVN.cVC);
        }
        bSV().setVisibility(this.cVN.hidden ? 8 : 0);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.cVN == null ? "" : this.cVN.azv;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVN == null ? "" : this.cVN.aBG;
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
                this.cVO = true;
                return;
            }
            return;
        }
        if (this.cVO) {
            bAH();
        }
        this.cVO = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.akt = swanAppNAViewContainer;
        this.cVP = this.akt.getModel().EK();
    }

    @Override // com.baidu.swan.apps.media.a
    public void bl(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.cVO = true;
                return;
            }
            return;
        }
        if (this.cVO) {
            bAH();
        }
        this.cVO = false;
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
            this.akt.MI();
        }
        if (this.dbf != null) {
            this.dbf.stopPlayback();
        }
        bSA();
        b.b(this);
    }

    public void ga(boolean z) {
        if (z != this.isFullScreen) {
            setFullScreenToDestroySurface();
            if (bSC()) {
                if (this.UT) {
                    bSF();
                } else {
                    bSE();
                }
                oR(this.UT);
                return;
            }
            bAy();
        }
    }

    @Override // com.baidu.tieba.play.c
    public void cf(String str, String str2) {
        if (!j.kM()) {
            bnN();
            e.jH().removeCallbacks(this.gIv);
            this.ekr.setVisibility(0);
            return;
        }
        super.cf(str, str2);
    }

    public boolean hasStart() {
        return this.cVR;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eh() {
        return null;
    }
}
