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
    private SwanAppNAViewContainer aEK;
    private com.baidu.tieba.aiapps.apps.media.video.c dqp;
    private boolean dqq;
    private com.baidu.swan.apps.model.a.a.a dqr;
    private ConfigurationChangedListenFragment dqs;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a dqt;
    private boolean dqu;
    private boolean isFullScreen;
    private boolean isMute;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.dqp = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.dqq = false;
        this.isFullScreen = false;
        this.dqu = false;
        this.isMute = false;
        b.a(this);
        a(new c.InterfaceC0492c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0492c
            public void kv() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.aEK != null) {
                        boolean kx = a.this.kx();
                        if (kx) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.cbV().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.cbV());
                        }
                        viewGroup.addView(a.this.cbV());
                        a.this.gt(true);
                        if (kx) {
                            a.this.hfu.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIK();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0492c
            public void kw() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.aEK != null) {
                        boolean kx = a.this.kx();
                        if (kx) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.cbV().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.cbV());
                        }
                        a.this.aEK.Va();
                        a.this.aEK.a(a.this.cbV(), a.this.dqr);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.gt(false);
                        if (kx) {
                            a.this.hfu.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIK();
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
                d.a(a.this.LL(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.dqu = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPrepared() {
                if (a.this.dqt != null) {
                    a.this.dqt.onPrepared(null);
                }
                a.this.setMuted(a.this.isMute);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                } catch (JSONException e) {
                }
                d.a(a.this.LL(), a.this.getSlaveId(), "timeupdate", jSONObject);
                a.this.dqu = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHw() {
                d.a(a.this.LL(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.dqu = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void qL() {
                if (a.this.dqt != null) {
                    a.this.dqt.onCompletion(null);
                }
                a.this.dqu = false;
                a.this.pausePlay();
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHx() {
                if (a.this.dqt != null) {
                    a.this.dqt.onError(null, 0, 0);
                }
                a.this.dqu = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void lT(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                }
                d.a(a.this.LL(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHy() {
                d.a(a.this.LL(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.dqu = true;
            }
        });
        this.dqs = new ConfigurationChangedListenFragment();
        this.dqs.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.cbB()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.dqs, "onCon").commitAllowingStateLoss();
        pF(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (cbC()) {
                    width = l.getEquipmentWidth(this.mActivity);
                    height = l.getEquipmentHeight(this.mActivity);
                } else {
                    int equipmentWidth = l.getEquipmentWidth(this.mActivity);
                    width = l.getEquipmentHeight(this.mActivity);
                    height = equipmentWidth;
                }
            } else {
                width = this.dqr.aXr.getWidth();
                height = this.dqr.aXr.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(LL(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.dqt = aVar;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return this.dqp == null ? "" : this.dqp.aUw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dqp == null ? "" : this.dqp.aXp;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LN() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dqq = true;
                return;
            }
            return;
        }
        if (this.dqq) {
            bIK();
        }
        this.dqq = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.aEK = swanAppNAViewContainer;
        if (this.aEK.getModel() != null) {
            this.dqr = this.aEK.getModel().Mr();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dqq = true;
                return;
            }
            return;
        }
        if (this.dqq) {
            bIK();
        }
        this.dqq = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (cbC()) {
            cbG();
        } else {
            vt();
        }
        return true;
    }

    public void aGY() {
        bvK();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        super.destroy();
        ViewGroup viewGroup = (ViewGroup) cbV().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(cbV());
            this.aEK.Va();
        }
        cbA();
        b.b(this);
    }

    @Override // com.baidu.tieba.play.c
    public void cm(String str, String str2) {
        if (!j.isNetworkAvailableForImmediately()) {
            bvK();
            e.fZ().removeCallbacks(this.hgg);
            this.eOI.setVisibility(0);
            return;
        }
        super.cm(str, str2);
    }

    @Override // com.baidu.swan.apps.media.a
    public String LM() {
        return null;
    }

    public void seekTo(int i) {
        this.iva.seekTo(i);
    }

    public int getDuration() {
        return this.iva.getDuration();
    }

    public void setMuted(boolean z) {
        this.iva.setMute(z);
        this.isMute = z;
    }

    public void setLooping(boolean z) {
        this.iva.setLooping(z);
    }
}
