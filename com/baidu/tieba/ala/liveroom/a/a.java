package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aMV;
    private String aMW;
    private boolean aYB;
    private CustomMessageListener bFv;
    private long blh;
    private long fKh;
    private b gCq;
    private com.baidu.tieba.ala.liveroom.n.a gCr;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        Ty();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aYB = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fKh = j;
        this.aMV = str;
        if (this.aMV == null) {
            this.aMV = "";
        }
        this.aMW = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.blh = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aD(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.gCq = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.blh);
            alaLastLiveroomInfo.setLastAnchorUname(this.aMV);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fKh));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aMW);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.x(this.mActivity).a(this.gCq).a(this.gCq.Tz().getSchemeCallback()).aE(this.fKh).iu(this.aMV).cU(this.aYB).aF(this.blh).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] Tx = gVar.Tx();
            for (com.baidu.live.view.web.a aVar : Tx) {
                this.gCq.Tz().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gCq.aE(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void GU(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.gCr != null) {
                if (this.gCr.isShowing()) {
                    this.gCr.dismiss();
                }
                this.gCr.release();
                this.gCr = null;
            }
            this.gCr = new com.baidu.tieba.ala.liveroom.n.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.blh);
            alaLastLiveroomInfo.setLastAnchorUname(this.aMV);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fKh));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aMW);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.gCr.a(this.fKh, this.aMV, this.blh, alaLastLiveroomInfo, this.aYB);
            this.gCr.Fz(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.gCq != null && this.gCq.isShowing()) {
            this.gCq.Tz().onResume();
        }
        if (this.gCr != null && this.gCr.isShowing()) {
            this.gCr.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.gCq != null && this.gCq.isShowing()) {
            this.gCq.Tz().onPause();
        }
        if (this.gCr != null && this.gCr.isShowing()) {
            this.gCr.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dI(int i) {
        if (this.gCq != null && this.gCq.isShowing()) {
            this.gCq.dI(i);
        }
        if (this.gCr != null && this.gCr.isShowing()) {
            this.gCr.dI(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fKh = 0L;
        this.aMV = "";
        MessageManager.getInstance().unRegisterListener(this.bFv);
        if (this.gCq != null) {
            this.gCq.Tz().release();
            this.gCq.TA();
        }
        if (this.gCr != null) {
            this.gCr.release();
            this.gCr.dismiss();
        }
    }

    private void Ty() {
        this.bFv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gCq != null && a.this.gCq.isShowing()) {
                    a.this.gCq.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bFv);
    }
}
