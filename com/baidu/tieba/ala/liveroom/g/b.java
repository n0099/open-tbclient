package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public class b {
    private w aDh;
    CustomMessageListener guV;
    protected a hfP;
    CustomMessageListener hfQ;

    public void D(w wVar) {
        if (wVar != null) {
            this.aDh = wVar;
            if (this.hfP != null && this.aDh.aHk != null) {
                this.hfP.eX(this.aDh.aHk.charmCount);
            }
        }
    }

    public void caw() {
        if (this.hfP != null) {
            this.hfP.caw();
        }
    }

    public void dE(int i) {
    }

    public void setVisible(int i) {
        if (this.hfP != null) {
            this.hfP.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hfQ);
        MessageManager.getInstance().unRegisterListener(this.guV);
    }
}
