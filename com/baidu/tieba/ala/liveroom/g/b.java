package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public class b {
    private w aFN;
    CustomMessageListener gDE;
    protected a hpx;
    CustomMessageListener hpy;

    public void I(w wVar) {
        if (wVar != null) {
            this.aFN = wVar;
            if (this.hpx != null && this.aFN.aJV != null) {
                this.hpx.fB(this.aFN.aJV.charmCount);
            }
        }
    }

    public void cer() {
        if (this.hpx != null) {
            this.hpx.cer();
        }
    }

    public void dX(int i) {
    }

    public void setVisible(int i) {
        if (this.hpx != null) {
            this.hpx.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hpy);
        MessageManager.getInstance().unRegisterListener(this.gDE);
    }
}
