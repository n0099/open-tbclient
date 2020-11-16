package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aMS;
    private String aMT;
    private boolean aRw;
    private CustomMessageListener bMq;
    private long bmk;
    private long fXY;
    private b gUk;
    private com.baidu.tieba.ala.liveroom.n.a gUl;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        Wp();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.aRw = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fXY = j;
        this.aMS = str;
        if (this.aMS == null) {
            this.aMS = "";
        }
        this.aMT = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.bmk = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aF(String str, int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.gUk = new b(this.mActivity);
            g gVar = new g();
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bmk);
            alaLastLiveroomInfo.setLastAnchorUname(this.aMS);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fXY));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aMT);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
            gVar.x(this.mActivity).a(this.gUk).a(this.gUk.Wq().getSchemeCallback()).bc(this.fXY).iM(this.aMS).dm(this.aRw).bd(this.bmk).a(alaLastLiveroomInfo);
            com.baidu.live.view.web.a[] Wo = gVar.Wo();
            for (com.baidu.live.view.web.a aVar : Wo) {
                this.gUk.Wq().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gUk.aG(str, i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void Hh(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.gUl != null) {
                if (this.gUl.isShowing()) {
                    this.gUl.dismiss();
                }
                this.gUl.release();
                this.gUl = null;
            }
            this.gUl = new com.baidu.tieba.ala.liveroom.n.a(this.mActivity);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastLiveId(this.bmk);
            alaLastLiveroomInfo.setLastAnchorUname(this.aMS);
            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fXY));
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aMT);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_FULL_SCREEN_WEBVIEW);
            this.gUl.a(this.fXY, this.aMS, this.bmk, alaLastLiveroomInfo, this.aRw);
            this.gUl.FO(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.gUk != null && this.gUk.isShowing()) {
            this.gUk.Wq().onResume();
        }
        if (this.gUl != null && this.gUl.isShowing()) {
            this.gUl.onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.gUk != null && this.gUk.isShowing()) {
            this.gUk.Wq().onPause();
        }
        if (this.gUl != null && this.gUl.isShowing()) {
            this.gUl.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void dE(int i) {
        if (this.gUk != null && this.gUk.isShowing()) {
            this.gUk.dE(i);
        }
        if (this.gUl != null && this.gUl.isShowing()) {
            this.gUl.dE(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fXY = 0L;
        this.aMS = "";
        MessageManager.getInstance().unRegisterListener(this.bMq);
        if (this.gUk != null) {
            this.gUk.Wq().release();
            this.gUk.Wr();
        }
        if (this.gUl != null) {
            this.gUl.release();
            this.gUl.dismiss();
        }
    }

    private void Wp() {
        this.bMq = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gUk != null && a.this.gUk.isShowing()) {
                    a.this.gUk.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bMq);
    }
}
