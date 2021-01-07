package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.x;
/* loaded from: classes11.dex */
public class b {
    private x aGe;
    CustomMessageListener gPs;
    protected a hBv;
    CustomMessageListener hBw;

    public void I(x xVar) {
        if (xVar != null) {
            this.aGe = xVar;
            if (this.hBv != null && this.aGe.aKu != null) {
                this.hBv.fB(this.aGe.aKu.charmCount);
            }
        }
    }

    public void chj() {
        if (this.hBv != null) {
            this.hBv.chj();
        }
    }

    public void dU(int i) {
    }

    public void setVisible(int i) {
        if (this.hBv != null) {
            this.hBv.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hBw);
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }
}
