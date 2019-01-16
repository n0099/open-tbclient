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
    private b bKj;
    private boolean bKk;
    private AiAppsNaViewModel bKl;
    private ConfigurationChangedListenFragment bKm;
    private boolean bKn;
    private boolean isFullScreen;
    private AiAppsNAViewContainer mContainer;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.bKj = new b();
        this.bKk = false;
        this.isFullScreen = false;
        this.bKn = false;
        AiAppsPlayerManager.addPlayerContext(this);
        a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0297c
            public void Zp() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.mContainer != null) {
                        boolean bsq = a.this.bsq();
                        if (bsq) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.bsC().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.bsC());
                        }
                        viewGroup.addView(a.this.bsC());
                        a.this.dH(true);
                        if (bsq) {
                            a.this.frT.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bag();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0297c
            public void Zq() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.mContainer != null) {
                        boolean bsq = a.this.bsq();
                        if (bsq) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.bsC().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.bsC());
                        }
                        a.this.mContainer.removeView();
                        a.this.mContainer.insertView(a.this.bsC(), a.this.bKl);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.dH(false);
                        if (bsq) {
                            a.this.frT.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bag();
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
                a.this.bKn = true;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPaused() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.bKn = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPlayEnd() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "ended", new JSONObject());
                a.this.bKn = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void Zr() {
                a.this.bKn = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void ie(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt(AudioStatusCallback.KEY_POSITION, Integer.valueOf(i));
                } catch (JSONException e) {
                }
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.n
            public void Zs() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.bKn = true;
            }
        });
        this.bKm = new ConfigurationChangedListenFragment();
        this.bKm.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.bsi()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.bKm, "onCon").commitAllowingStateLoss();
        ms(false);
    }

    public b Zn() {
        return this.bKj;
    }

    public void a(b bVar) {
        this.bKj = bVar;
        Zo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (bsj()) {
                    width = l.aO(this.mActivity);
                    height = l.aQ(this.mActivity);
                } else {
                    int aO = l.aO(this.mActivity);
                    width = l.aQ(this.mActivity);
                    height = aO;
                }
            } else {
                width = this.bKl.position.getWidth();
                height = this.bKl.position.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        com.baidu.tieba.aiapps.apps.media.video.c.a(getPlayerId(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    private void Zo() {
        if (this.bKj.bJX) {
            setVolume(0);
        }
        getVideoView().setLooping(this.bKj.mLoop);
        if (this.bKj.bJG) {
            bsk();
        }
        mB(!this.bKj.bKe);
        if (!StringUtils.isNull(this.bKj.bJY)) {
            setThumbnail(this.bKj.bJY);
        }
        bsC().setVisibility(this.bKj.hidden ? 8 : 0);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getPlayerId() {
        return this.bKj == null ? "" : this.bKj.mPlayerId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getSlaveId() {
        return this.bKj == null ? "" : this.bKj.slaveId;
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
                this.bKk = true;
                return;
            }
            return;
        }
        if (this.bKk) {
            bag();
        }
        this.bKk = false;
    }

    public void a(AiAppsNAViewContainer aiAppsNAViewContainer) {
        this.mContainer = aiAppsNAViewContainer;
        this.bKl = this.mContainer.getModel().cloneModel();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onAppForegroundChanged(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.bKk = true;
                return;
            }
            return;
        }
        if (this.bKk) {
            bag();
        }
        this.bKk = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (bsj()) {
            bsl();
        } else {
            aZX();
        }
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        aNk();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        ViewGroup viewGroup = (ViewGroup) bsC().getParent();
        if (viewGroup != null) {
            aNk();
            viewGroup.removeView(bsC());
            this.mContainer.removeView();
        }
        if (this.bPb != null) {
            this.bPb.stopPlayback();
        }
        bsg();
        AiAppsPlayerManager.removePlayerContext(this);
    }

    public void dI(boolean z) {
        if (z != this.isFullScreen) {
            setFullScreenToDestroySurface();
            if (bsj()) {
                if (this.bJP) {
                    bsl();
                } else {
                    bsk();
                }
                mt(this.bJP);
                return;
            }
            aZX();
        }
    }

    @Override // com.baidu.tieba.play.c
    public void ba(String str, String str2) {
        if (!j.kK()) {
            aNk();
            e.jG().removeCallbacks(this.fsG);
            this.daV.setVisibility(0);
            return;
        }
        super.ba(str, str2);
    }

    public boolean hasStart() {
        return this.bKn;
    }
}
