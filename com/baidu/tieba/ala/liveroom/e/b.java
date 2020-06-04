package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.q;
/* loaded from: classes3.dex */
public class b {
    private q aJj;
    protected a fSI;
    CustomMessageListener fSJ;
    CustomMessageListener foe;

    public void p(q qVar) {
        if (qVar != null) {
            this.aJj = qVar;
            if (this.fSI != null && this.aJj.avj != null) {
                this.fSI.dE(this.aJj.avj.charmCount);
            }
        }
    }

    public void bAS() {
        if (this.fSI != null) {
            this.fSI.bAS();
        }
    }

    public void cu(int i) {
    }

    public void setVisible(int i) {
        if (this.fSI != null) {
            this.fSI.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fSJ);
        MessageManager.getInstance().unRegisterListener(this.foe);
    }
}
