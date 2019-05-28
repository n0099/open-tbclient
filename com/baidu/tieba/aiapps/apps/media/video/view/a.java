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
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c implements com.baidu.swan.apps.media.a {
    private SwanAppNAViewContainer akG;
    private com.baidu.tieba.aiapps.apps.media.video.c deo;
    private boolean dep;
    private com.baidu.swan.apps.model.a.a.a deq;
    private ConfigurationChangedListenFragment der;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a det;
    private boolean deu;
    private boolean isFullScreen;
    private boolean isMute;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.deo = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.dep = false;
        this.isFullScreen = false;
        this.deu = false;
        this.isMute = false;
        b.a(this);
        a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0387c
            public void pe() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.akG != null) {
                        boolean pg = a.this.pg();
                        if (pg) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.caY().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.caY());
                        }
                        viewGroup.addView(a.this.caY());
                        a.this.gx(true);
                        if (pg) {
                            a.this.gZh.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIu();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0387c
            public void pf() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.akG != null) {
                        boolean pg = a.this.pg();
                        if (pg) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.caY().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.caY());
                        }
                        a.this.akG.Pr();
                        a.this.akG.a(a.this.caY(), a.this.deq);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.gx(false);
                        if (pg) {
                            a.this.gZh.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIu();
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
                d.a(a.this.Gc(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.deu = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPrepared() {
                if (a.this.det != null) {
                    a.this.det.onPrepared(a.this.deC);
                }
                a.this.setMuted(a.this.isMute);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(a.this.getVideoView().getDuration()));
                } catch (JSONException e) {
                }
                d.a(a.this.Gc(), a.this.getSlaveId(), "timeupdate", jSONObject);
                a.this.deu = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPaused() {
                d.a(a.this.Gc(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.deu = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPlayEnd() {
                if (a.this.det != null) {
                    a.this.det.onCompletion(a.this.deC);
                }
                a.this.deu = false;
                a.this.pausePlay();
            }

            @Override // com.baidu.tieba.play.c.o
            public void aFm() {
                if (a.this.det != null) {
                    a.this.det.onError(a.this.deC, 0, 0);
                }
                a.this.deu = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void mG(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                }
                d.a(a.this.Gc(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.o
            public void aFn() {
                d.a(a.this.Gc(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.deu = true;
            }
        });
        this.der = new ConfigurationChangedListenFragment();
        this.der.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.caE()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.der, "onCon").commitAllowingStateLoss();
        pE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (caF()) {
                    width = l.af(this.mActivity);
                    height = l.ah(this.mActivity);
                } else {
                    int af = l.af(this.mActivity);
                    width = l.ah(this.mActivity);
                    height = af;
                }
            } else {
                width = this.deq.aDo.getWidth();
                height = this.deq.aDo.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(Gc(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.det = aVar;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gc() {
        return this.deo == null ? "" : this.deo.aAu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.deo == null ? "" : this.deo.aDm;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ge() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bt(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dep = true;
                return;
            }
            return;
        }
        if (this.dep) {
            bIu();
        }
        this.dep = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.akG = swanAppNAViewContainer;
        if (this.akG.getModel() != null) {
            this.deq = this.akG.getModel().GI();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bu(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dep = true;
                return;
            }
            return;
        }
        if (this.dep) {
            bIu();
        }
        this.dep = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (caF()) {
            caI();
        } else {
            bIl();
        }
        return true;
    }

    public void aEP() {
        bvt();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        super.destroy();
        ViewGroup viewGroup = (ViewGroup) caY().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(caY());
            this.akG.Pr();
        }
        caD();
        b.b(this);
    }

    @Override // com.baidu.tieba.play.c
    public void cr(String str, String str2) {
        if (!j.jG()) {
            bvt();
            e.iB().removeCallbacks(this.gZT);
            this.eAh.setVisibility(0);
            return;
        }
        super.cr(str, str2);
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gd() {
        return null;
    }

    public void seekTo(int i) {
        this.dlM.getPlayer().seekTo(i);
    }

    public int getDuration() {
        return this.dlM.getDuration();
    }

    public void setMuted(boolean z) {
        this.dlM.setMute(z);
        this.isMute = z;
    }

    public void setLooping(boolean z) {
        this.dlM.setLooping(z);
    }
}
