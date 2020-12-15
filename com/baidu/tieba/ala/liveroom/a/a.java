package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aPR;
    private String aPS;
    private boolean aUy;
    private CustomMessageListener bRw;
    private long brr;
    private long ggl;
    private com.baidu.tieba.ala.liveroom.m.a hdA;
    private b hdz;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        YP();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aUy = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void f(long j, String str, String str2) {
        this.ggl = j;
        this.aPR = str;
        if (this.aPR == null) {
            this.aPR = "";
        }
        this.aPS = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.brr = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aG(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.hdz = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.brr);
            alaLastLiveroomInfo.setLastAnchorUname(this.aPR);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.ggl));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aPS);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.x(this.mActivity).a(this.hdz).a(this.hdz.getWebView().getSchemeCallback()).bA(this.ggl).jq(this.aPR).dA(this.aUy).bB(this.brr).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] YO = gVar.YO();
            for (com.baidu.live.view.web.a aVar : YO) {
                this.hdz.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.hdz.aH(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void HV(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.hdA != null) {
                if (this.hdA.isShowing()) {
                    this.hdA.dismiss();
                }
                this.hdA.release();
                this.hdA = null;
            }
            this.hdA = new com.baidu.tieba.ala.liveroom.m.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.brr);
            alaLastLiveroomInfo.setLastAnchorUname(this.aPR);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.ggl));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aPS);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.hdA.a(this.ggl, this.aPR, this.brr, alaLastLiveroomInfo, this.aUy);
            this.hdA.GD(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.hdz != null && this.hdz.isShowing()) {
            this.hdz.getWebView().onResume();
        }
        if (this.hdA != null && this.hdA.isShowing()) {
            this.hdA.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.hdz != null && this.hdz.isShowing()) {
            this.hdz.getWebView().onPause();
        }
        if (this.hdA != null && this.hdA.isShowing()) {
            this.hdA.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dX(int i) {
        if (this.hdz != null && this.hdz.isShowing()) {
            this.hdz.dX(i);
        }
        if (this.hdA != null && this.hdA.isShowing()) {
            this.hdA.dX(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.ggl = 0L;
        this.aPR = "";
        MessageManager.getInstance().unRegisterListener(this.bRw);
        if (this.hdz != null) {
            this.hdz.getWebView().release();
            this.hdz.YQ();
        }
        if (this.hdA != null) {
            this.hdA.release();
            this.hdA.dismiss();
        }
    }

    private void YP() {
        this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hdz != null && a.this.hdz.isShowing()) {
                    a.this.hdz.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bRw);
    }
}
