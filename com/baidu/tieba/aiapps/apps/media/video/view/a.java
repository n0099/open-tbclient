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
    private b bFQ;
    private boolean bFR;
    private AiAppsNaViewModel bFS;
    private ConfigurationChangedListenFragment bFT;
    private boolean bFU;
    private boolean isFullScreen;
    private AiAppsNAViewContainer mContainer;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.bFQ = new b();
        this.bFR = false;
        this.isFullScreen = false;
        this.bFU = false;
        AiAppsPlayerManager.addPlayerContext(this);
        a(new c.InterfaceC0286c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0286c
            public void XN() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.mContainer != null) {
                        boolean bpd = a.this.bpd();
                        if (bpd) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.bpp().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.bpp());
                        }
                        viewGroup.addView(a.this.bpp());
                        a.this.dD(true);
                        if (bpd) {
                            a.this.fho.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.aXb();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0286c
            public void XO() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.mContainer != null) {
                        boolean bpd = a.this.bpd();
                        if (bpd) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.bpp().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.bpp());
                        }
                        a.this.mContainer.removeView();
                        a.this.mContainer.insertView(a.this.bpp(), a.this.bFS);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.dD(false);
                        if (bpd) {
                            a.this.fho.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.aXb();
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
                a.this.bFU = true;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPaused() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.bFU = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPlayEnd() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "ended", new JSONObject());
                a.this.bFU = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void XP() {
                a.this.bFU = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void hP(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt(AudioStatusCallback.KEY_POSITION, Integer.valueOf(i));
                } catch (JSONException e) {
                }
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.n
            public void XQ() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.bFU = true;
            }
        });
        this.bFT = new ConfigurationChangedListenFragment();
        this.bFT.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.boV()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.bFT, "onCon").commitAllowingStateLoss();
        mm(false);
    }

    public b XL() {
        return this.bFQ;
    }

    public void a(b bVar) {
        this.bFQ = bVar;
        XM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (boW()) {
                    width = l.aO(this.mActivity);
                    height = l.aQ(this.mActivity);
                } else {
                    int aO = l.aO(this.mActivity);
                    width = l.aQ(this.mActivity);
                    height = aO;
                }
            } else {
                width = this.bFS.position.getWidth();
                height = this.bFS.position.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        com.baidu.tieba.aiapps.apps.media.video.c.a(getPlayerId(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    private void XM() {
        if (this.bFQ.bFE) {
            setVolume(0);
        }
        getVideoView().setLooping(this.bFQ.mLoop);
        if (this.bFQ.bFn) {
            boX();
        }
        mv(!this.bFQ.bFL);
        if (!StringUtils.isNull(this.bFQ.bFF)) {
            setThumbnail(this.bFQ.bFF);
        }
        bpp().setVisibility(this.bFQ.hidden ? 8 : 0);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getPlayerId() {
        return this.bFQ == null ? "" : this.bFQ.mPlayerId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getSlaveId() {
        return this.bFQ == null ? "" : this.bFQ.slaveId;
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
                this.bFR = true;
                return;
            }
            return;
        }
        if (this.bFR) {
            aXb();
        }
        this.bFR = false;
    }

    public void a(AiAppsNAViewContainer aiAppsNAViewContainer) {
        this.mContainer = aiAppsNAViewContainer;
        this.bFS = this.mContainer.getModel().cloneModel();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onAppForegroundChanged(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.bFR = true;
                return;
            }
            return;
        }
        if (this.bFR) {
            aXb();
        }
        this.bFR = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (boW()) {
            boY();
        } else {
            aWS();
        }
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        aKf();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        ViewGroup viewGroup = (ViewGroup) bpp().getParent();
        if (viewGroup != null) {
            aKf();
            viewGroup.removeView(bpp());
            this.mContainer.removeView();
        }
        if (this.bKy != null) {
            this.bKy.stopPlayback();
        }
        boT();
        AiAppsPlayerManager.removePlayerContext(this);
    }

    public void dE(boolean z) {
        if (z != this.isFullScreen) {
            setFullScreenToDestroySurface();
            if (boW()) {
                if (this.bFw) {
                    boY();
                } else {
                    boX();
                }
                mn(this.bFw);
                return;
            }
            aWS();
        }
    }

    @Override // com.baidu.tieba.play.c
    public void aW(String str, String str2) {
        if (!j.kK()) {
            aKf();
            e.jG().removeCallbacks(this.fib);
            this.cQL.setVisibility(0);
            return;
        }
        super.aW(str, str2);
    }

    public boolean hasStart() {
        return this.bFU;
    }
}
