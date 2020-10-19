package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.u;
/* loaded from: classes4.dex */
public class b {
    private u aDU;
    protected a gOq;
    CustomMessageListener gOr;
    CustomMessageListener gfx;

    public void v(u uVar) {
        if (uVar != null) {
            this.aDU = uVar;
            if (this.gOq != null && this.aDU.aHD != null) {
                this.gOq.ez(this.aDU.aHD.charmCount);
            }
        }
    }

    public void bVC() {
        if (this.gOq != null) {
            this.gOq.bVC();
        }
    }

    public void dI(int i) {
    }

    public void setVisible(int i) {
        if (this.gOq != null) {
            this.gOq.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gOr);
        MessageManager.getInstance().unRegisterListener(this.gfx);
    }
}
