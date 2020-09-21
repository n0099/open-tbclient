package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aJQ;
    private String aJR;
    private boolean aVq;
    private long bhr;
    private CustomMessageListener byS;
    private long fxY;
    private b gnX;
    private com.baidu.tieba.ala.liveroom.n.a gnY;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        RF();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aVq = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fxY = j;
        this.aJQ = str;
        if (this.aJQ == null) {
            this.aJQ = "";
        }
        this.aJR = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.bhr = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aC(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.gnX = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bhr);
            alaLastLiveroomInfo.setLastAnchorUname(this.aJQ);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fxY));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aJR);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.w(this.mActivity).a(this.gnX).a(this.gnX.RG().getSchemeCallback()).aC(this.fxY).hT(this.aJQ).cN(this.aVq).aD(this.bhr).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] RE = gVar.RE();
            for (com.baidu.live.view.web.a aVar : RE) {
                this.gnX.RG().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gnX.aD(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void Gi(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.gnY != null) {
                if (this.gnY.isShowing()) {
                    this.gnY.dismiss();
                }
                this.gnY.release();
                this.gnY = null;
            }
            this.gnY = new com.baidu.tieba.ala.liveroom.n.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bhr);
            alaLastLiveroomInfo.setLastAnchorUname(this.aJQ);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fxY));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aJR);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.gnY.a(this.fxY, this.aJQ, this.bhr, alaLastLiveroomInfo, this.aVq);
            this.gnY.EO(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.gnX != null && this.gnX.isShowing()) {
            this.gnX.RG().onResume();
        }
        if (this.gnY != null && this.gnY.isShowing()) {
            this.gnY.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.gnX != null && this.gnX.isShowing()) {
            this.gnX.RG().onPause();
        }
        if (this.gnY != null && this.gnY.isShowing()) {
            this.gnY.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dD(int i) {
        if (this.gnX != null && this.gnX.isShowing()) {
            this.gnX.dD(i);
        }
        if (this.gnY != null && this.gnY.isShowing()) {
            this.gnY.dD(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fxY = 0L;
        this.aJQ = "";
        MessageManager.getInstance().unRegisterListener(this.byS);
        if (this.gnX != null) {
            this.gnX.RG().release();
            this.gnX.RH();
        }
        if (this.gnY != null) {
            this.gnY.release();
            this.gnY.dismiss();
        }
    }

    private void RF() {
        this.byS = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gnX != null && a.this.gnX.isShowing()) {
                    a.this.gnX.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.byS);
    }
}
