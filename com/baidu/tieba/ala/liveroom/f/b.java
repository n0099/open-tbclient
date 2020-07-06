package com.baidu.tieba.ala.liveroom.f;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.q;
/* loaded from: classes3.dex */
public class b {
    private q aLQ;
    CustomMessageListener fzr;
    protected a gfv;
    CustomMessageListener gfw;

    public void r(q qVar) {
        if (qVar != null) {
            this.aLQ = qVar;
            if (this.gfv != null && this.aLQ.axp != null) {
                this.gfv.dH(this.aLQ.axp.charmCount);
            }
        }
    }

    public void bDX() {
        if (this.gfv != null) {
            this.gfv.bDX();
        }
    }

    public void cA(int i) {
    }

    public void setVisible(int i) {
        if (this.gfv != null) {
            this.gfv.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gfw);
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }
}
