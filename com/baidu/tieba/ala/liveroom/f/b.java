package com.baidu.tieba.ala.liveroom.f;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.ab;
/* loaded from: classes11.dex */
public class b {
    private ab aDd;
    CustomMessageListener gNs;
    protected a hAZ;
    CustomMessageListener hBa;

    public void J(ab abVar) {
        if (abVar != null) {
            this.aDd = abVar;
            if (this.hAZ != null && this.aDd.aId != null) {
                this.hAZ.fG(this.aDd.aId.charmCount);
            }
        }
    }

    public void cem() {
        if (this.hAZ != null) {
            this.hAZ.cem();
        }
    }

    public void cr(int i) {
    }

    public void setVisible(int i) {
        if (this.hAZ != null) {
            this.hAZ.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hBa);
        MessageManager.getInstance().unRegisterListener(this.gNs);
    }
}
