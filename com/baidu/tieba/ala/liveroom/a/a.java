package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes7.dex */
public class a implements c {
    private String aIy;
    private String aIz;
    private long bew;
    private CustomMessageListener fNJ;
    private long fuJ;
    private boolean gcI;
    private b gkM;
    private com.baidu.tieba.ala.liveroom.m.a gkN;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bHg();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.gcI = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fuJ = j;
        this.aIy = str;
        if (this.aIy == null) {
            this.aIy = "";
        }
        this.aIz = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.bew = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aC(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.gkM = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bew);
            alaLastLiveroomInfo.setLastAnchorUname(this.aIy);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fuJ));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aIz);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.v(this.mActivity).a(this.gkM).a(this.gkM.bHh().getSchemeCallback()).aC(this.fuJ).hw(this.aIy).cL(this.gcI).aD(this.bew).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] QV = gVar.QV();
            for (com.baidu.live.view.web.a aVar : QV) {
                this.gkM.bHh().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gkM.aD(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void FK(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.gkN != null) {
                if (this.gkN.isShowing()) {
                    this.gkN.dismiss();
                }
                this.gkN.release();
                this.gkN = null;
            }
            this.gkN = new com.baidu.tieba.ala.liveroom.m.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bew);
            alaLastLiveroomInfo.setLastAnchorUname(this.aIy);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fuJ));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aIz);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.gkN.a(this.fuJ, this.aIy, this.bew, alaLastLiveroomInfo, this.gcI);
            this.gkN.show(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.gkM != null && this.gkM.isShowing()) {
            this.gkM.bHh().onResume();
        }
        if (this.gkN != null && this.gkN.isShowing()) {
            this.gkN.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.gkM != null && this.gkM.isShowing()) {
            this.gkM.bHh().onPause();
        }
        if (this.gkN != null && this.gkN.isShowing()) {
            this.gkN.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dz(int i) {
        if (this.gkM != null && this.gkM.isShowing()) {
            this.gkM.dz(i);
        }
        if (this.gkN != null && this.gkN.isShowing()) {
            this.gkN.dz(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fuJ = 0L;
        this.aIy = "";
        MessageManager.getInstance().unRegisterListener(this.fNJ);
        if (this.gkM != null) {
            this.gkM.bHh().release();
        }
        if (this.gkN != null) {
            this.gkN.release();
        }
    }

    private void bHg() {
        this.fNJ = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gkM != null && a.this.gkM.isShowing()) {
                    a.this.gkM.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fNJ);
    }
}
