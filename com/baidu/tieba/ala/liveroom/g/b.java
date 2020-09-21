package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.u;
/* loaded from: classes4.dex */
public class b {
    private u aAP;
    CustomMessageListener fTe;
    protected a gzX;
    CustomMessageListener gzY;

    public void u(u uVar) {
        if (uVar != null) {
            this.aAP = uVar;
            if (this.gzX != null && this.aAP.aEz != null) {
                this.gzX.ej(this.aAP.aEz.charmCount);
            }
        }
    }

    public void bSj() {
        if (this.gzX != null) {
            this.gzX.bSj();
        }
    }

    public void dD(int i) {
    }

    public void setVisible(int i) {
        if (this.gzX != null) {
            this.gzX.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gzY);
        MessageManager.getInstance().unRegisterListener(this.fTe);
    }
}
