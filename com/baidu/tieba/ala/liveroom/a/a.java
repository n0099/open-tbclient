package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aNA;
    private String aNB;
    private boolean aRP;
    private CustomMessageListener bIu;
    private long bmB;
    private long fSB;
    private b gOe;
    private com.baidu.tieba.ala.liveroom.n.a gOf;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        Uy();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aRP = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fSB = j;
        this.aNA = str;
        if (this.aNA == null) {
            this.aNA = "";
        }
        this.aNB = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.bmB = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aE(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.gOe = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bmB);
            alaLastLiveroomInfo.setLastAnchorUname(this.aNA);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fSB));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aNB);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.x(this.mActivity).a(this.gOe).a(this.gOe.Uz().getSchemeCallback()).aG(this.fSB).iF(this.aNA).dd(this.aRP).aH(this.bmB).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] Ux = gVar.Ux();
            for (com.baidu.live.view.web.a aVar : Ux) {
                this.gOe.Uz().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gOe.aF(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void Hs(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.gOf != null) {
                if (this.gOf.isShowing()) {
                    this.gOf.dismiss();
                }
                this.gOf.release();
                this.gOf = null;
            }
            this.gOf = new com.baidu.tieba.ala.liveroom.n.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bmB);
            alaLastLiveroomInfo.setLastAnchorUname(this.aNA);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fSB));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aNB);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.gOf.a(this.fSB, this.aNA, this.bmB, alaLastLiveroomInfo, this.aRP);
            this.gOf.FZ(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.gOe != null && this.gOe.isShowing()) {
            this.gOe.Uz().onResume();
        }
        if (this.gOf != null && this.gOf.isShowing()) {
            this.gOf.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.gOe != null && this.gOe.isShowing()) {
            this.gOe.Uz().onPause();
        }
        if (this.gOf != null && this.gOf.isShowing()) {
            this.gOf.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dI(int i) {
        if (this.gOe != null && this.gOe.isShowing()) {
            this.gOe.dI(i);
        }
        if (this.gOf != null && this.gOf.isShowing()) {
            this.gOf.dI(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fSB = 0L;
        this.aNA = "";
        MessageManager.getInstance().unRegisterListener(this.bIu);
        if (this.gOe != null) {
            this.gOe.Uz().release();
            this.gOe.UA();
        }
        if (this.gOf != null) {
            this.gOf.release();
            this.gOf.dismiss();
        }
    }

    private void Uy() {
        this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gOe != null && a.this.gOe.isShowing()) {
                    a.this.gOe.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bIu);
    }
}
