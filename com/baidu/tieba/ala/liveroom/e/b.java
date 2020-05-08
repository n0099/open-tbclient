package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.n;
/* loaded from: classes3.dex */
public class b {
    private n aDK;
    protected a fED;
    CustomMessageListener fEE;
    CustomMessageListener faq;

    public void p(n nVar) {
        if (nVar != null) {
            this.aDK = nVar;
            if (this.fED != null && this.aDK.aqk != null) {
                this.fED.dD(this.aDK.aqk.charmCount);
            }
        }
    }

    public void buR() {
        if (this.fED != null) {
            this.fED.buR();
        }
    }

    public void cl(int i) {
    }

    public void setVisible(int i) {
        if (this.fED != null) {
            this.fED.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fEE);
        MessageManager.getInstance().unRegisterListener(this.faq);
    }
}
