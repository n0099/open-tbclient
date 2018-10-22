package com.baidu.tieba.aiapps.apps.media.video.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.tieba.aiapps.apps.media.video.b;
import com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment;
import com.baidu.tieba.play.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c implements AiAppsPlayerContext {
    private b bFe;
    private boolean bFf;
    private AiAppsNaViewModel bFg;
    private ConfigurationChangedListenFragment bFh;
    private boolean bFi;
    private boolean isFullScreen;
    private AiAppsNAViewContainer mContainer;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.bFe = new b();
        this.bFf = false;
        this.isFullScreen = false;
        this.bFi = false;
        AiAppsPlayerManager.addPlayerContext(this);
        a(new c.InterfaceC0258c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0258c
            public void XD() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.mContainer != null) {
                        boolean bpH = a.this.bpH();
                        if (bpH) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.bpT().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.bpT());
                        }
                        viewGroup.addView(a.this.bpT());
                        a.this.dm(true);
                        if (bpH) {
                            a.this.ffV.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.aXE();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0258c
            public void XE() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.mContainer != null) {
                        boolean bpH = a.this.bpH();
                        if (bpH) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.bpT().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.bpT());
                        }
                        a.this.mContainer.removeView();
                        a.this.mContainer.insertView(a.this.bpT(), a.this.bFg);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.dm(false);
                        if (bpH) {
                            a.this.ffV.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.aXE();
                                }
                            }, 100L);
                        }
                    }
                }
            }
        });
        a(new c.n() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.2
            @Override // com.baidu.tieba.play.c.n
            public void onStarted() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.bFi = true;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPaused() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.bFi = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPlayEnd() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "ended", new JSONObject());
                a.this.bFi = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void XF() {
                a.this.bFi = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void hC(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt(AudioStatusCallback.KEY_POSITION, Integer.valueOf(i));
                } catch (JSONException e) {
                }
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.n
            public void XG() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.bFi = true;
            }
        });
        this.bFh = new ConfigurationChangedListenFragment();
        this.bFh.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.bpA()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.bFh, "onCon").commitAllowingStateLoss();
        mb(false);
    }

    public b XB() {
        return this.bFe;
    }

    public void a(b bVar) {
        this.bFe = bVar;
        XC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (bpB()) {
                    width = l.aO(this.mActivity);
                    height = l.aQ(this.mActivity);
                } else {
                    int aO = l.aO(this.mActivity);
                    width = l.aQ(this.mActivity);
                    height = aO;
                }
            } else {
                width = this.bFg.position.getWidth();
                height = this.bFg.position.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        com.baidu.tieba.aiapps.apps.media.video.c.a(getPlayerId(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    private void XC() {
        if (this.bFe.bES) {
            setVolume(0);
        }
        getVideoView().setLooping(this.bFe.mLoop);
        if (this.bFe.bEB) {
            bpC();
        }
        mk(!this.bFe.bEZ);
        if (!StringUtils.isNull(this.bFe.bET)) {
            setThumbnail(this.bFe.bET);
        }
        bpT().setVisibility(this.bFe.hidden ? 8 : 0);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getPlayerId() {
        return this.bFe == null ? "" : this.bFe.mPlayerId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getSlaveId() {
        return this.bFe == null ? "" : this.bFe.slaveId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public Object getPlayerObject() {
        return this;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public int getPlayerType() {
        return 1;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onForegroundChanged(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.bFf = true;
                return;
            }
            return;
        }
        if (this.bFf) {
            aXE();
        }
        this.bFf = false;
    }

    public void a(AiAppsNAViewContainer aiAppsNAViewContainer) {
        this.mContainer = aiAppsNAViewContainer;
        this.bFg = this.mContainer.getModel().cloneModel();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onAppForegroundChanged(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.bFf = true;
                return;
            }
            return;
        }
        if (this.bFf) {
            aXE();
        }
        this.bFf = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (bpB()) {
            bpD();
        } else {
            aXv();
        }
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        aKH();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        ViewGroup viewGroup = (ViewGroup) bpT().getParent();
        if (viewGroup != null) {
            aKH();
            viewGroup.removeView(bpT());
            this.mContainer.removeView();
        }
        if (this.bJN != null) {
            this.bJN.stopPlayback();
        }
        bpy();
        AiAppsPlayerManager.removePlayerContext(this);
    }

    public void dn(boolean z) {
        if (z != this.isFullScreen) {
            setFullScreenToDestroySurface();
            if (bpB()) {
                if (this.bEK) {
                    bpD();
                } else {
                    bpC();
                }
                mc(this.bEK);
                return;
            }
            aXv();
        }
    }

    @Override // com.baidu.tieba.play.c
    public void aW(String str, String str2) {
        if (!j.kM()) {
            aKH();
            e.jI().removeCallbacks(this.fgI);
            this.cPF.setVisibility(0);
            return;
        }
        super.aW(str, str2);
    }

    public boolean hasStart() {
        return this.bFi;
    }
}
