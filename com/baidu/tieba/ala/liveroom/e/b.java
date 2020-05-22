package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.q;
/* loaded from: classes3.dex */
public class b {
    private q aJj;
    protected a fSx;
    CustomMessageListener fSy;
    CustomMessageListener fnT;

    public void p(q qVar) {
        if (qVar != null) {
            this.aJj = qVar;
            if (this.fSx != null && this.aJj.avj != null) {
                this.fSx.dE(this.aJj.avj.charmCount);
            }
        }
    }

    public void bAQ() {
        if (this.fSx != null) {
            this.fSx.bAQ();
        }
    }

    public void cs(int i) {
    }

    public void setVisible(int i) {
        if (this.fSx != null) {
            this.fSx.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fSy);
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }
}
