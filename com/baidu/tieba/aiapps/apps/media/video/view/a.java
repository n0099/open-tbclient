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
    private com.baidu.tieba.aiapps.apps.media.video.c dep;
    private boolean deq;
    private com.baidu.swan.apps.model.a.a.a der;
    private ConfigurationChangedListenFragment det;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a deu;
    private boolean dev;
    private boolean isFullScreen;
    private boolean isMute;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.dep = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.deq = false;
        this.isFullScreen = false;
        this.dev = false;
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
                        ViewGroup viewGroup2 = (ViewGroup) a.this.caZ().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.caZ());
                        }
                        viewGroup.addView(a.this.caZ());
                        a.this.gx(true);
                        if (pg) {
                            a.this.gZi.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIv();
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
                        ViewGroup viewGroup = (ViewGroup) a.this.caZ().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.caZ());
                        }
                        a.this.akG.Pr();
                        a.this.akG.a(a.this.caZ(), a.this.der);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.gx(false);
                        if (pg) {
                            a.this.gZi.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIv();
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
                a.this.dev = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPrepared() {
                if (a.this.deu != null) {
                    a.this.deu.onPrepared(a.this.deD);
                }
                a.this.setMuted(a.this.isMute);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(a.this.getVideoView().getDuration()));
                } catch (JSONException e) {
                }
                d.a(a.this.Gc(), a.this.getSlaveId(), "timeupdate", jSONObject);
                a.this.dev = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPaused() {
                d.a(a.this.Gc(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.dev = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPlayEnd() {
                if (a.this.deu != null) {
                    a.this.deu.onCompletion(a.this.deD);
                }
                a.this.dev = false;
                a.this.pausePlay();
            }

            @Override // com.baidu.tieba.play.c.o
            public void aFm() {
                if (a.this.deu != null) {
                    a.this.deu.onError(a.this.deD, 0, 0);
                }
                a.this.dev = false;
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
                a.this.dev = true;
            }
        });
        this.det = new ConfigurationChangedListenFragment();
        this.det.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.caF()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.det, "onCon").commitAllowingStateLoss();
        pF(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (caG()) {
                    width = l.af(this.mActivity);
                    height = l.ah(this.mActivity);
                } else {
                    int af = l.af(this.mActivity);
                    width = l.ah(this.mActivity);
                    height = af;
                }
            } else {
                width = this.der.aDo.getWidth();
                height = this.der.aDo.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(Gc(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.deu = aVar;
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gc() {
        return this.dep == null ? "" : this.dep.aAu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dep == null ? "" : this.dep.aDm;
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
                this.deq = true;
                return;
            }
            return;
        }
        if (this.deq) {
            bIv();
        }
        this.deq = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.akG = swanAppNAViewContainer;
        if (this.akG.getModel() != null) {
            this.der = this.akG.getModel().GI();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bu(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.deq = true;
                return;
            }
            return;
        }
        if (this.deq) {
            bIv();
        }
        this.deq = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (caG()) {
            caJ();
        } else {
            bIm();
        }
        return true;
    }

    public void aEP() {
        bvu();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        super.destroy();
        ViewGroup viewGroup = (ViewGroup) caZ().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(caZ());
            this.akG.Pr();
        }
        caE();
        b.b(this);
    }

    @Override // com.baidu.tieba.play.c
    public void cr(String str, String str2) {
        if (!j.jG()) {
            bvu();
            e.iB().removeCallbacks(this.gZU);
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
