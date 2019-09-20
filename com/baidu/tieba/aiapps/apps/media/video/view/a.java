package com.baidu.tieba.aiapps.apps.media.video.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.swan.apps.media.b;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tieba.aiapps.apps.media.video.d;
import com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment;
import com.baidu.tieba.play.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c implements com.baidu.swan.apps.media.a {
    private SwanAppNAViewContainer alI;
    private com.baidu.tieba.aiapps.apps.media.video.c dhL;
    private boolean dhM;
    private com.baidu.swan.apps.model.a.a.a dhN;
    private ConfigurationChangedListenFragment dhO;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a dhP;
    private boolean dhQ;
    private boolean isFullScreen;
    private boolean isMute;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.dhL = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.dhM = false;
        this.isFullScreen = false;
        this.dhQ = false;
        this.isMute = false;
        b.a(this);
        a(new c.InterfaceC0403c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0403c
            public void pA() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.alI != null) {
                        boolean pC = a.this.pC();
                        if (pC) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.ceV().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.ceV());
                        }
                        viewGroup.addView(a.this.ceV());
                        a.this.gE(true);
                        if (pC) {
                            a.this.hih.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bMd();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0403c
            public void pB() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.alI != null) {
                        boolean pC = a.this.pC();
                        if (pC) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.ceV().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.ceV());
                        }
                        a.this.alI.Qm();
                        a.this.alI.a(a.this.ceV(), a.this.dhN);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.gE(false);
                        if (pC) {
                            a.this.hih.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bMd();
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
                d.a(a.this.GQ(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.dhQ = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPrepared() {
                if (a.this.dhP != null) {
                    a.this.dhP.onPrepared(null);
                }
                a.this.setMuted(a.this.isMute);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                } catch (JSONException e) {
                }
                d.a(a.this.GQ(), a.this.getSlaveId(), "timeupdate", jSONObject);
                a.this.dhQ = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHl() {
                d.a(a.this.GQ(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.dhQ = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPlayEnd() {
                if (a.this.dhP != null) {
                    a.this.dhP.onCompletion(null);
                }
                a.this.dhQ = false;
                a.this.pausePlay();
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHm() {
                if (a.this.dhP != null) {
                    a.this.dhP.onError(null, 0, 0);
                }
                a.this.dhQ = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void mS(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                }
                d.a(a.this.GQ(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHn() {
                d.a(a.this.GQ(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.dhQ = true;
            }
        });
        this.dhO = new ConfigurationChangedListenFragment();
        this.dhO.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.ceB()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.dhO, "onCon").commitAllowingStateLoss();
        pX(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (ceC()) {
                    width = l.af(this.mActivity);
                    height = l.ah(this.mActivity);
                } else {
                    int af = l.af(this.mActivity);
                    width = l.ah(this.mActivity);
                    height = af;
                }
            } else {
                width = this.dhN.aEu.getWidth();
                height = this.dhN.aEu.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(GQ(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.dhP = aVar;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GQ() {
        return this.dhL == null ? "" : this.dhL.aBA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dhL == null ? "" : this.dhL.aEs;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GS() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dhM = true;
                return;
            }
            return;
        }
        if (this.dhM) {
            bMd();
        }
        this.dhM = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.alI = swanAppNAViewContainer;
        if (this.alI.getModel() != null) {
            this.dhN = this.alI.getModel().Hw();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dhM = true;
                return;
            }
            return;
        }
        if (this.dhM) {
            bMd();
        }
        this.dhM = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (ceC()) {
            ceG();
        } else {
            bLU();
        }
        return true;
    }

    public void aGN() {
        bzb();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        super.destroy();
        ViewGroup viewGroup = (ViewGroup) ceV().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(ceV());
            this.alI.Qm();
        }
        ceA();
        b.b(this);
    }

    @Override // com.baidu.tieba.play.c
    public void ct(String str, String str2) {
        if (!j.jQ()) {
            bzb();
            e.iK().removeCallbacks(this.hiT);
            this.eGT.setVisibility(0);
            return;
        }
        super.ct(str, str2);
    }

    @Override // com.baidu.swan.apps.media.a
    public String GR() {
        return null;
    }

    public void seekTo(int i) {
        this.ixp.seekTo(i);
    }

    public int getDuration() {
        return this.ixp.getDuration();
    }

    public void setMuted(boolean z) {
        this.ixp.setMute(z);
        this.isMute = z;
    }

    public void setLooping(boolean z) {
        this.ixp.setLooping(z);
    }
}
