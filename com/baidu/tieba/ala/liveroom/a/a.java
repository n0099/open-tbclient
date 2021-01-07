package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes11.dex */
public class a implements c {
    private String aQG;
    private String aQH;
    private boolean aVQ;
    private CustomMessageListener bXd;
    private long bvY;
    private long gqJ;
    private b hpm;
    private com.baidu.tieba.ala.liveroom.m.a hpn;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        aag();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aVQ = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void g(long j, String str, String str2) {
        this.gqJ = j;
        this.aQG = str;
        if (this.aQG == null) {
            this.aQG = "";
        }
        this.aQH = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.bvY = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aI(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.hpm = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bvY);
            alaLastLiveroomInfo.setLastAnchorUname(this.aQG);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gqJ));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aQH);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.w(this.mActivity).a(this.hpm).a(this.hpm.getWebView().getSchemeCallback()).bA(this.gqJ).jj(this.aQG).dD(this.aVQ).bB(this.bvY).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] aaf = gVar.aaf();
            for (com.baidu.live.view.web.a aVar : aaf) {
                this.hpm.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.hpm.aJ(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void HU(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.hpn != null) {
                if (this.hpn.isShowing()) {
                    this.hpn.dismiss();
                }
                this.hpn.release();
                this.hpn = null;
            }
            this.hpn = new com.baidu.tieba.ala.liveroom.m.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bvY);
            alaLastLiveroomInfo.setLastAnchorUname(this.aQG);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gqJ));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aQH);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.hpn.a(this.gqJ, this.aQG, this.bvY, alaLastLiveroomInfo, this.aVQ);
            this.hpn.GA(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.hpm != null && this.hpm.isShowing()) {
            this.hpm.getWebView().onResume();
        }
        if (this.hpn != null && this.hpn.isShowing()) {
            this.hpn.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.hpm != null && this.hpm.isShowing()) {
            this.hpm.getWebView().onPause();
        }
        if (this.hpn != null && this.hpn.isShowing()) {
            this.hpn.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dU(int i) {
        if (this.hpm != null && this.hpm.isShowing()) {
            this.hpm.dU(i);
        }
        if (this.hpn != null && this.hpn.isShowing()) {
            this.hpn.dU(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.gqJ = 0L;
        this.aQG = "";
        MessageManager.getInstance().unRegisterListener(this.bXd);
        if (this.hpm != null) {
            this.hpm.getWebView().release();
            this.hpm.aah();
        }
        if (this.hpn != null) {
            this.hpn.release();
            this.hpn.dismiss();
        }
    }

    private void aag() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hpm != null && a.this.hpm.isShowing()) {
                    a.this.hpm.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bXd);
    }
}
