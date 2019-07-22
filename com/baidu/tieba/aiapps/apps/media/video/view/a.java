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
    private SwanAppNAViewContainer alj;
    private com.baidu.tieba.aiapps.apps.media.video.c dfT;
    private boolean dfU;
    private com.baidu.swan.apps.model.a.a.a dfV;
    private ConfigurationChangedListenFragment dfW;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a dfX;
    private boolean dfY;
    private boolean isFullScreen;
    private boolean isMute;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.dfT = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.dfU = false;
        this.isFullScreen = false;
        this.dfY = false;
        this.isMute = false;
        b.a(this);
        a(new c.InterfaceC0386c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0386c
            public void pz() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.alj != null) {
                        boolean pB = a.this.pB();
                        if (pB) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.cdO().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.cdO());
                        }
                        viewGroup.addView(a.this.cdO());
                        a.this.gB(true);
                        if (pB) {
                            a.this.hfu.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bLc();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0386c
            public void pA() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.alj != null) {
                        boolean pB = a.this.pB();
                        if (pB) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.cdO().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.cdO());
                        }
                        a.this.alj.Qi();
                        a.this.alj.a(a.this.cdO(), a.this.dfV);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.gB(false);
                        if (pB) {
                            a.this.hfu.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bLc();
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
                d.a(a.this.GM(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.dfY = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPrepared() {
                if (a.this.dfX != null) {
                    a.this.dfX.onPrepared(a.this.dgg);
                }
                a.this.setMuted(a.this.isMute);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(a.this.getVideoView().getDuration()));
                } catch (JSONException e) {
                }
                d.a(a.this.GM(), a.this.getSlaveId(), "timeupdate", jSONObject);
                a.this.dfY = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void aGF() {
                d.a(a.this.GM(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.dfY = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPlayEnd() {
                if (a.this.dfX != null) {
                    a.this.dfX.onCompletion(a.this.dgg);
                }
                a.this.dfY = false;
                a.this.pausePlay();
            }

            @Override // com.baidu.tieba.play.c.o
            public void aGG() {
                if (a.this.dfX != null) {
                    a.this.dfX.onError(a.this.dgg, 0, 0);
                }
                a.this.dfY = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void mN(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                }
                d.a(a.this.GM(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.o
            public void aGH() {
                d.a(a.this.GM(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.dfY = true;
            }
        });
        this.dfW = new ConfigurationChangedListenFragment();
        this.dfW.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.cdu()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.dfW, "onCon").commitAllowingStateLoss();
        pT(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (cdv()) {
                    width = l.af(this.mActivity);
                    height = l.ah(this.mActivity);
                } else {
                    int af = l.af(this.mActivity);
                    width = l.ah(this.mActivity);
                    height = af;
                }
            } else {
                width = this.dfV.aDW.getWidth();
                height = this.dfV.aDW.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(GM(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.dfX = aVar;
    }

    @Override // com.baidu.swan.apps.media.a
    public String GM() {
        return this.dfT == null ? "" : this.dfT.aBc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dfT == null ? "" : this.dfT.aDU;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dfU = true;
                return;
            }
            return;
        }
        if (this.dfU) {
            bLc();
        }
        this.dfU = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.alj = swanAppNAViewContainer;
        if (this.alj.getModel() != null) {
            this.dfV = this.alj.getModel().Hs();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.dfU = true;
                return;
            }
            return;
        }
        if (this.dfU) {
            bLc();
        }
        this.dfU = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (cdv()) {
            cdy();
        } else {
            bKT();
        }
        return true;
    }

    public void aGh() {
        bxZ();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        super.destroy();
        ViewGroup viewGroup = (ViewGroup) cdO().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(cdO());
            this.alj.Qi();
        }
        cdt();
        b.b(this);
    }

    @Override // com.baidu.tieba.play.c
    public void cs(String str, String str2) {
        if (!j.jQ()) {
            bxZ();
            e.iK().removeCallbacks(this.hgg);
            this.eFd.setVisibility(0);
            return;
        }
        super.cs(str, str2);
    }

    @Override // com.baidu.swan.apps.media.a
    public String GN() {
        return null;
    }

    public void seekTo(int i) {
        this.dnu.getPlayer().seekTo(i);
    }

    public int getDuration() {
        return this.dnu.getDuration();
    }

    public void setMuted(boolean z) {
        this.dnu.setMute(z);
        this.isMute = z;
    }

    public void setLooping(boolean z) {
        this.dnu.setLooping(z);
    }
}
