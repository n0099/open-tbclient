package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes10.dex */
public class a implements c {
    private String aLT;
    private String aLU;
    private boolean aRd;
    private CustomMessageListener bSr;
    private long brk;
    private long gmc;
    private b hkF;
    private com.baidu.tieba.ala.liveroom.m.a hkG;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        Wn();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aRd = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void g(long j, String str, String str2) {
        this.gmc = j;
        this.aLT = str;
        if (this.aLT == null) {
            this.aLT = "";
        }
        this.aLU = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.brk = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aI(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.hkF = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.brk);
            alaLastLiveroomInfo.setLastAnchorUname(this.aLT);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gmc));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aLU);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.w(this.mActivity).a(this.hkF).a(this.hkF.getWebView().getSchemeCallback()).bA(this.gmc).hY(this.aLT).dz(this.aRd).bB(this.brk).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] Wm = gVar.Wm();
            for (com.baidu.live.view.web.a aVar : Wm) {
                this.hkF.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.hkF.aJ(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void GJ(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.hkG != null) {
                if (this.hkG.isShowing()) {
                    this.hkG.dismiss();
                }
                this.hkG.release();
                this.hkG = null;
            }
            this.hkG = new com.baidu.tieba.ala.liveroom.m.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.brk);
            alaLastLiveroomInfo.setLastAnchorUname(this.aLT);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gmc));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aLU);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.hkG.a(this.gmc, this.aLT, this.brk, alaLastLiveroomInfo, this.aRd);
            this.hkG.Fp(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.hkF != null && this.hkF.isShowing()) {
            this.hkF.getWebView().onResume();
        }
        if (this.hkG != null && this.hkG.isShowing()) {
            this.hkG.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.hkF != null && this.hkF.isShowing()) {
            this.hkF.getWebView().onPause();
        }
        if (this.hkG != null && this.hkG.isShowing()) {
            this.hkG.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void co(int i) {
        if (this.hkF != null && this.hkF.isShowing()) {
            this.hkF.co(i);
        }
        if (this.hkG != null && this.hkG.isShowing()) {
            this.hkG.co(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.gmc = 0L;
        this.aLT = "";
        MessageManager.getInstance().unRegisterListener(this.bSr);
        if (this.hkF != null) {
            this.hkF.getWebView().release();
            this.hkF.Wo();
        }
        if (this.hkG != null) {
            this.hkG.release();
            this.hkG.dismiss();
        }
    }

    private void Wn() {
        this.bSr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hkF != null && a.this.hkF.isShowing()) {
                    a.this.hkF.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bSr);
    }
}
