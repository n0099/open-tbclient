package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.r;
/* loaded from: classes7.dex */
public class b {
    private r aAh;
    CustomMessageListener fPP;
    protected a gwH;
    CustomMessageListener gwI;

    public void s(r rVar) {
        if (rVar != null) {
            this.aAh = rVar;
            if (this.gwH != null && this.aAh.aDE != null) {
                this.gwH.eg(this.aAh.aDE.charmCount);
            }
        }
    }

    public void bQM() {
        if (this.gwH != null) {
            this.gwH.bQM();
        }
    }

    public void dz(int i) {
    }

    public void setVisible(int i) {
        if (this.gwH != null) {
            this.gwH.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gwI);
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }
}
