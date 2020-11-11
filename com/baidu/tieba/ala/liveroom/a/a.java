package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aOD;
    private String aOE;
    private boolean aTh;
    private CustomMessageListener bOa;
    private long bnV;
    private long fYr;
    private b gUD;
    private com.baidu.tieba.ala.liveroom.n.a gUE;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        WY();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aTh = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fYr = j;
        this.aOD = str;
        if (this.aOD == null) {
            this.aOD = "";
        }
        this.aOE = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.bnV = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aG(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.gUD = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bnV);
            alaLastLiveroomInfo.setLastAnchorUname(this.aOD);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fYr));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aOE);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.y(this.mActivity).a(this.gUD).a(this.gUD.WZ().getSchemeCallback()).bc(this.fYr).iS(this.aOD).dk(this.aTh).bd(this.bnV).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] WX = gVar.WX();
            for (com.baidu.live.view.web.a aVar : WX) {
                this.gUD.WZ().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gUD.aH(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void HG(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.gUE != null) {
                if (this.gUE.isShowing()) {
                    this.gUE.dismiss();
                }
                this.gUE.release();
                this.gUE = null;
            }
            this.gUE = new com.baidu.tieba.ala.liveroom.n.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bnV);
            alaLastLiveroomInfo.setLastAnchorUname(this.aOD);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fYr));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aOE);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.gUE.a(this.fYr, this.aOD, this.bnV, alaLastLiveroomInfo, this.aTh);
            this.gUE.Gn(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.gUD != null && this.gUD.isShowing()) {
            this.gUD.WZ().onResume();
        }
        if (this.gUE != null && this.gUE.isShowing()) {
            this.gUE.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.gUD != null && this.gUD.isShowing()) {
            this.gUD.WZ().onPause();
        }
        if (this.gUE != null && this.gUE.isShowing()) {
            this.gUE.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dI(int i) {
        if (this.gUD != null && this.gUD.isShowing()) {
            this.gUD.dI(i);
        }
        if (this.gUE != null && this.gUE.isShowing()) {
            this.gUE.dI(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fYr = 0L;
        this.aOD = "";
        MessageManager.getInstance().unRegisterListener(this.bOa);
        if (this.gUD != null) {
            this.gUD.WZ().release();
            this.gUD.Xa();
        }
        if (this.gUE != null) {
            this.gUE.release();
            this.gUE.dismiss();
        }
    }

    private void WY() {
        this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gUD != null && a.this.gUD.isShowing()) {
                    a.this.gUD.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bOa);
    }
}
