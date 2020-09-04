package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes7.dex */
public class a implements c {
    private String aIA;
    private String aIB;
    private long bey;
    private CustomMessageListener fNN;
    private long fuN;
    private boolean gcM;
    private b gkQ;
    private com.baidu.tieba.ala.liveroom.m.a gkR;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bHh();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.gcM = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fuN = j;
        this.aIA = str;
        if (this.aIA == null) {
            this.aIA = "";
        }
        this.aIB = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.bey = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aC(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.gkQ = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bey);
            alaLastLiveroomInfo.setLastAnchorUname(this.aIA);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fuN));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aIB);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.v(this.mActivity).a(this.gkQ).a(this.gkQ.bHi().getSchemeCallback()).aC(this.fuN).hx(this.aIA).cM(this.gcM).aD(this.bey).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] QV = gVar.QV();
            for (com.baidu.live.view.web.a aVar : QV) {
                this.gkQ.bHi().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gkQ.aD(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void FL(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.gkR != null) {
                if (this.gkR.isShowing()) {
                    this.gkR.dismiss();
                }
                this.gkR.release();
                this.gkR = null;
            }
            this.gkR = new com.baidu.tieba.ala.liveroom.m.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bey);
            alaLastLiveroomInfo.setLastAnchorUname(this.aIA);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fuN));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aIB);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.gkR.a(this.fuN, this.aIA, this.bey, alaLastLiveroomInfo, this.gcM);
            this.gkR.show(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.gkQ != null && this.gkQ.isShowing()) {
            this.gkQ.bHi().onResume();
        }
        if (this.gkR != null && this.gkR.isShowing()) {
            this.gkR.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.gkQ != null && this.gkQ.isShowing()) {
            this.gkQ.bHi().onPause();
        }
        if (this.gkR != null && this.gkR.isShowing()) {
            this.gkR.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dz(int i) {
        if (this.gkQ != null && this.gkQ.isShowing()) {
            this.gkQ.dz(i);
        }
        if (this.gkR != null && this.gkR.isShowing()) {
            this.gkR.dz(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fuN = 0L;
        this.aIA = "";
        MessageManager.getInstance().unRegisterListener(this.fNN);
        if (this.gkQ != null) {
            this.gkQ.bHi().release();
        }
        if (this.gkR != null) {
            this.gkR.release();
        }
    }

    private void bHh() {
        this.fNN = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gkQ != null && a.this.gkQ.isShowing()) {
                    a.this.gkQ.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fNN);
    }
}
