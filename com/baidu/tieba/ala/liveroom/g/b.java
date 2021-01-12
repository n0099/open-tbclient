package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.x;
/* loaded from: classes10.dex */
public class b {
    private x aBr;
    CustomMessageListener gKM;
    protected a hwP;
    CustomMessageListener hwQ;

    public void I(x xVar) {
        if (xVar != null) {
            this.aBr = xVar;
            if (this.hwP != null && this.aBr.aFH != null) {
                this.hwP.fB(this.aBr.aFH.charmCount);
            }
        }
    }

    public void cdr() {
        if (this.hwP != null) {
            this.hwP.cdr();
        }
    }

    public void co(int i) {
    }

    public void setVisible(int i) {
        if (this.hwP != null) {
            this.hwP.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hwQ);
        MessageManager.getInstance().unRegisterListener(this.gKM);
    }
}
