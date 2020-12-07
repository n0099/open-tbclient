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
    private long ggj;
    private b hdx;
    private com.baidu.tieba.ala.liveroom.m.a hdy;
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
        this.ggj = j;
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
            this.hdx = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.brr);
            alaLastLiveroomInfo.setLastAnchorUname(this.aPR);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.ggj));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aPS);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.x(this.mActivity).a(this.hdx).a(this.hdx.getWebView().getSchemeCallback()).bA(this.ggj).jq(this.aPR).dA(this.aUy).bB(this.brr).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] YO = gVar.YO();
            for (com.baidu.live.view.web.a aVar : YO) {
                this.hdx.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.hdx.aH(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void HV(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.hdy != null) {
                if (this.hdy.isShowing()) {
                    this.hdy.dismiss();
                }
                this.hdy.release();
                this.hdy = null;
            }
            this.hdy = new com.baidu.tieba.ala.liveroom.m.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.brr);
            alaLastLiveroomInfo.setLastAnchorUname(this.aPR);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.ggj));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aPS);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.hdy.a(this.ggj, this.aPR, this.brr, alaLastLiveroomInfo, this.aUy);
            this.hdy.GD(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.hdx != null && this.hdx.isShowing()) {
            this.hdx.getWebView().onResume();
        }
        if (this.hdy != null && this.hdy.isShowing()) {
            this.hdy.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.hdx != null && this.hdx.isShowing()) {
            this.hdx.getWebView().onPause();
        }
        if (this.hdy != null && this.hdy.isShowing()) {
            this.hdy.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dX(int i) {
        if (this.hdx != null && this.hdx.isShowing()) {
            this.hdx.dX(i);
        }
        if (this.hdy != null && this.hdy.isShowing()) {
            this.hdy.dX(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.ggj = 0L;
        this.aPR = "";
        MessageManager.getInstance().unRegisterListener(this.bRw);
        if (this.hdx != null) {
            this.hdx.getWebView().release();
            this.hdx.YQ();
        }
        if (this.hdy != null) {
            this.hdy.release();
            this.hdy.dismiss();
        }
    }

    private void YP() {
        this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hdx != null && a.this.hdx.isShowing()) {
                    a.this.hdx.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bRw);
    }
}
