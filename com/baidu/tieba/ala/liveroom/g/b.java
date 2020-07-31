package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.q;
/* loaded from: classes4.dex */
public class b {
    private q avf;
    CustomMessageListener fEy;
    protected a gkD;
    CustomMessageListener gkE;

    public void r(q qVar) {
        if (qVar != null) {
            this.avf = qVar;
            if (this.gkD != null && this.avf.ayC != null) {
                this.gkD.dV(this.avf.ayC.charmCount);
            }
        }
    }

    public void bHi() {
        if (this.gkD != null) {
            this.gkD.bHi();
        }
    }

    public void bN(int i) {
    }

    public void setVisible(int i) {
        if (this.gkD != null) {
            this.gkD.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gkE);
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }
}
