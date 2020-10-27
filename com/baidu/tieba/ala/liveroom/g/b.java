package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public class b {
    private w aEc;
    CustomMessageListener gpA;
    protected a hae;
    CustomMessageListener haf;

    public void y(w wVar) {
        if (wVar != null) {
            this.aEc = wVar;
            if (this.hae != null && this.aEc.aIe != null) {
                this.hae.eB(this.aEc.aIe.charmCount);
            }
        }
    }

    public void bYB() {
        if (this.hae != null) {
            this.hae.bYB();
        }
    }

    public void dI(int i) {
    }

    public void setVisible(int i) {
        if (this.hae != null) {
            this.hae.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.haf);
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }
}
