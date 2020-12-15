package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public class b {
    private w aFN;
    CustomMessageListener gDG;
    CustomMessageListener hpA;
    protected a hpz;

    public void I(w wVar) {
        if (wVar != null) {
            this.aFN = wVar;
            if (this.hpz != null && this.aFN.aJV != null) {
                this.hpz.fB(this.aFN.aJV.charmCount);
            }
        }
    }

    public void ces() {
        if (this.hpz != null) {
            this.hpz.ces();
        }
    }

    public void dX(int i) {
    }

    public void setVisible(int i) {
        if (this.hpz != null) {
            this.hpz.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hpA);
        MessageManager.getInstance().unRegisterListener(this.gDG);
    }
}
