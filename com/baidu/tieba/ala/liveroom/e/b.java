package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.n;
/* loaded from: classes3.dex */
public class b {
    private n aDE;
    protected a fEy;
    CustomMessageListener fEz;
    CustomMessageListener fal;

    public void p(n nVar) {
        if (nVar != null) {
            this.aDE = nVar;
            if (this.fEy != null && this.aDE.aqe != null) {
                this.fEy.dD(this.aDE.aqe.charmCount);
            }
        }
    }

    public void buT() {
        if (this.fEy != null) {
            this.fEy.buT();
        }
    }

    public void cl(int i) {
    }

    public void setVisible(int i) {
        if (this.fEy != null) {
            this.fEy.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fEz);
        MessageManager.getInstance().unRegisterListener(this.fal);
    }
}
