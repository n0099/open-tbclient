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
    private SwanAppNAViewContainer aFc;
    private com.baidu.tieba.aiapps.apps.media.video.c drg;
    private boolean drh;
    private com.baidu.swan.apps.model.a.a.a dri;
    private ConfigurationChangedListenFragment drj;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.a.a drk;
    private boolean drl;
    private boolean isFullScreen;
    private boolean isMute;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.drg = new com.baidu.tieba.aiapps.apps.media.video.c();
        this.drh = false;
        this.isFullScreen = false;
        this.drl = false;
        this.isMute = false;
        b.a(this);
        a(new c.InterfaceC0497c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0497c
            public void kv() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.aFc != null) {
                        boolean kx = a.this.kx();
                        if (kx) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.cbX().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.cbX());
                        }
                        viewGroup.addView(a.this.cbX());
                        a.this.gt(true);
                        if (kx) {
                            a.this.hgl.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIM();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0497c
            public void kw() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.aFc != null) {
                        boolean kx = a.this.kx();
                        if (kx) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.cbX().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.cbX());
                        }
                        a.this.aFc.Vc();
                        a.this.aFc.a(a.this.cbX(), a.this.dri);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.gt(false);
                        if (kx) {
                            a.this.hgl.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bIM();
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
                d.a(a.this.LK(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.drl = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void onPrepared() {
                if (a.this.drk != null) {
                    a.this.drk.onPrepared(null);
                }
                a.this.setMuted(a.this.isMute);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                } catch (JSONException e) {
                }
                d.a(a.this.LK(), a.this.getSlaveId(), "timeupdate", jSONObject);
                a.this.drl = true;
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHy() {
                d.a(a.this.LK(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.drl = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void qK() {
                if (a.this.drk != null) {
                    a.this.drk.onCompletion(null);
                }
                a.this.drl = false;
                a.this.pausePlay();
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHz() {
                if (a.this.drk != null) {
                    a.this.drk.onError(null, 0, 0);
                }
                a.this.drl = false;
            }

            @Override // com.baidu.tieba.play.c.o
            public void lU(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                }
                d.a(a.this.LK(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.o
            public void aHA() {
                d.a(a.this.LK(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.drl = true;
            }
        });
        this.drj = new ConfigurationChangedListenFragment();
        this.drj.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.cbD()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.drj, "onCon").commitAllowingStateLoss();
        pF(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (cbE()) {
                    width = l.getEquipmentWidth(this.mActivity);
                    height = l.getEquipmentHeight(this.mActivity);
                } else {
                    int equipmentWidth = l.getEquipmentWidth(this.mActivity);
                    width = l.getEquipmentHeight(this.mActivity);
                    height = equipmentWidth;
                }
            } else {
                width = this.dri.aXJ.getWidth();
                height = this.dri.aXJ.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        d.a(LK(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    public void setVideoPlayerCallback(com.baidu.tieba.aiapps.apps.media.videoplayer.a.a aVar) {
        this.drk = aVar;
    }

    @Override // com.baidu.swan.apps.media.a
    public String LK() {
        return this.drg == null ? "" : this.drg.aUO;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.drg == null ? "" : this.drg.aXH;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.drh = true;
                return;
            }
            return;
        }
        if (this.drh) {
            bIM();
        }
        this.drh = false;
    }

    public void e(SwanAppNAViewContainer swanAppNAViewContainer) {
        this.aFc = swanAppNAViewContainer;
        if (this.aFc.getModel() != null) {
            this.dri = this.aFc.getModel().Mq();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.drh = true;
                return;
            }
            return;
        }
        if (this.drh) {
            bIM();
        }
        this.drh = false;
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (cbE()) {
            cbI();
        } else {
            vs();
        }
        return true;
    }

    public void aHa() {
        bvM();
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        super.destroy();
        ViewGroup viewGroup = (ViewGroup) cbX().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(cbX());
            this.aFc.Vc();
        }
        cbC();
        b.b(this);
    }

    @Override // com.baidu.tieba.play.c
    public void cm(String str, String str2) {
        if (!j.isNetworkAvailableForImmediately()) {
            bvM();
            e.fZ().removeCallbacks(this.hgX);
            this.ePz.setVisibility(0);
            return;
        }
        super.cm(str, str2);
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return null;
    }

    public void seekTo(int i) {
        this.ivR.seekTo(i);
    }

    public int getDuration() {
        return this.ivR.getDuration();
    }

    public void setMuted(boolean z) {
        this.ivR.setMute(z);
        this.isMute = z;
    }

    public void setLooping(boolean z) {
        this.ivR.setLooping(z);
    }
}
