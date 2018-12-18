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
    private b bJt;
    private boolean bJu;
    private AiAppsNaViewModel bJv;
    private ConfigurationChangedListenFragment bJw;
    private boolean bJx;
    private boolean isFullScreen;
    private AiAppsNAViewContainer mContainer;

    public a(Activity activity, boolean z) {
        super(activity, (View) null, z);
        this.bJt = new b();
        this.bJu = false;
        this.isFullScreen = false;
        this.bJx = false;
        AiAppsPlayerManager.addPlayerContext(this);
        a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1
            @Override // com.baidu.tieba.play.c.InterfaceC0297c
            public void YQ() {
                if (!a.this.isFullScreen) {
                    a.this.isFullScreen = true;
                    if (a.this.mContainer != null) {
                        boolean bqV = a.this.bqV();
                        if (bqV) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.mActivity.getWindow().getDecorView();
                        ViewGroup viewGroup2 = (ViewGroup) a.this.brh().getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a.this.brh());
                        }
                        viewGroup.addView(a.this.brh());
                        a.this.dE(true);
                        if (bqV) {
                            a.this.fog.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.aYS();
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.play.c.InterfaceC0297c
            public void YR() {
                if (a.this.isFullScreen) {
                    a.this.isFullScreen = false;
                    if (a.this.mContainer != null) {
                        boolean bqV = a.this.bqV();
                        if (bqV) {
                            a.this.pausePlay();
                        }
                        ViewGroup viewGroup = (ViewGroup) a.this.brh().getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(a.this.brh());
                        }
                        a.this.mContainer.removeView();
                        a.this.mContainer.insertView(a.this.brh(), a.this.bJv);
                        if (a.this.mActivity.getResources().getConfiguration().orientation == 2) {
                            a.this.mActivity.setRequestedOrientation(1);
                        }
                        a.this.dE(false);
                        if (bqV) {
                            a.this.fog.postDelayed(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.aYS();
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
                a.this.bJx = true;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPaused() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "pause", new JSONObject());
                a.this.bJx = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void onPlayEnd() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "ended", new JSONObject());
                a.this.bJx = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void YS() {
                a.this.bJx = false;
            }

            @Override // com.baidu.tieba.play.c.n
            public void id(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(a.this.getVideoView().getDuration()));
                    jSONObject.putOpt(AudioStatusCallback.KEY_POSITION, Integer.valueOf(i));
                } catch (JSONException e) {
                }
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "timeupdate", jSONObject);
            }

            @Override // com.baidu.tieba.play.c.n
            public void YT() {
                com.baidu.tieba.aiapps.apps.media.video.c.a(a.this.getPlayerId(), a.this.getSlaveId(), "play", new JSONObject());
                a.this.bJx = true;
            }
        });
        this.bJw = new ConfigurationChangedListenFragment();
        this.bJw.a(new ConfigurationChangedListenFragment.a() { // from class: com.baidu.tieba.aiapps.apps.media.video.view.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.video.view.ConfigurationChangedListenFragment.a
            public void onConfigurationChanged(Configuration configuration) {
                if (a.this.bqN()) {
                    a.this.setFullScreenToDestroySurface();
                    a.this.onConfigurationChanged(configuration);
                }
            }
        });
        activity.getFragmentManager().beginTransaction().add(this.bJw, "onCon").commitAllowingStateLoss();
        mp(false);
    }

    public b YO() {
        return this.bJt;
    }

    public void a(b bVar) {
        this.bJt = bVar;
        YP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(boolean z) {
        int width;
        int height;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                if (bqO()) {
                    width = l.aO(this.mActivity);
                    height = l.aQ(this.mActivity);
                } else {
                    int aO = l.aO(this.mActivity);
                    width = l.aQ(this.mActivity);
                    height = aO;
                }
            } else {
                width = this.bJv.position.getWidth();
                height = this.bJv.position.getHeight();
            }
            jSONObject.putOpt("fullscreen", z ? "1" : "0");
            jSONObject.putOpt("width", String.valueOf(width));
            jSONObject.putOpt("height", String.valueOf(height));
        } catch (JSONException e) {
        }
        com.baidu.tieba.aiapps.apps.media.video.c.a(getPlayerId(), getSlaveId(), "fullscreenchange", jSONObject);
    }

    private void YP() {
        if (this.bJt.bJh) {
            setVolume(0);
        }
        getVideoView().setLooping(this.bJt.mLoop);
        if (this.bJt.bIQ) {
            bqP();
        }
        my(!this.bJt.bJo);
        if (!StringUtils.isNull(this.bJt.bJi)) {
            setThumbnail(this.bJt.bJi);
        }
        brh().setVisibility(this.bJt.hidden ? 8 : 0);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getPlayerId() {
        return this.bJt == null ? "" : this.bJt.mPlayerId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getSlaveId() {
        return this.bJt == null ? "" : this.bJt.slaveId;
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
                this.bJu = true;
                return;
            }
            return;
        }
        if (this.bJu) {
            aYS();
        }
        this.bJu = false;
    }

    public void a(AiAppsNAViewContainer aiAppsNAViewContainer) {
        this.mContainer = aiAppsNAViewContainer;
        this.bJv = this.mContainer.getModel().cloneModel();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onAppForegroundChanged(boolean z) {
        if (!z) {
            if (getVideoView().isPlaying()) {
                pausePlay();
                this.bJu = true;
                return;
            }
            return;
        }
        if (this.bJu) {
            aYS();
        }
        this.bJu = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public boolean onBackPressed() {
        if (!this.isFullScreen) {
            return false;
        }
        if (bqO()) {
            bqQ();
        } else {
            aYJ();
        }
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        aLW();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        ViewGroup viewGroup = (ViewGroup) brh().getParent();
        if (viewGroup != null) {
            aLW();
            viewGroup.removeView(brh());
            this.mContainer.removeView();
        }
        if (this.bOn != null) {
            this.bOn.stopPlayback();
        }
        bqL();
        AiAppsPlayerManager.removePlayerContext(this);
    }

    public void dF(boolean z) {
        if (z != this.isFullScreen) {
            setFullScreenToDestroySurface();
            if (bqO()) {
                if (this.bIZ) {
                    bqQ();
                } else {
                    bqP();
                }
                mq(this.bIZ);
                return;
            }
            aYJ();
        }
    }

    @Override // com.baidu.tieba.play.c
    public void aZ(String str, String str2) {
        if (!j.kK()) {
            aLW();
            e.jG().removeCallbacks(this.foT);
            this.cXs.setVisibility(0);
            return;
        }
        super.aZ(str, str2);
    }

    public boolean hasStart() {
        return this.bJx;
    }
}
