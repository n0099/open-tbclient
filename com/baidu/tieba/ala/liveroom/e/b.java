package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.i;
/* loaded from: classes6.dex */
public class b {
    private i aaB;
    CustomMessageListener dFq;
    protected a eeV;
    CustomMessageListener eeW;

    public void h(i iVar) {
        if (iVar != null) {
            this.aaB = iVar;
            if (this.eeV != null && this.aaB.Ps != null) {
                this.eeV.cj(this.aaB.Ps.charmCount);
            }
        }
    }

    public void aRs() {
        if (this.eeV != null) {
            this.eeV.aRs();
        }
    }

    public void bw(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void setVisible(int i) {
        if (this.eeV != null) {
            this.eeV.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eeW);
        MessageManager.getInstance().unRegisterListener(this.dFq);
    }
}
