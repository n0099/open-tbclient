package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.r;
/* loaded from: classes7.dex */
public class b {
    private r aAj;
    CustomMessageListener fPT;
    protected a gwL;
    CustomMessageListener gwM;

    public void s(r rVar) {
        if (rVar != null) {
            this.aAj = rVar;
            if (this.gwL != null && this.aAj.aDG != null) {
                this.gwL.eg(this.aAj.aDG.charmCount);
            }
        }
    }

    public void bQN() {
        if (this.gwL != null) {
            this.gwL.bQN();
        }
    }

    public void dz(int i) {
    }

    public void setVisible(int i) {
        if (this.gwL != null) {
            this.gwL.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gwM);
        MessageManager.getInstance().unRegisterListener(this.fPT);
    }
}
