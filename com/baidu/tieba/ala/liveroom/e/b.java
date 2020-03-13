package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.m;
/* loaded from: classes3.dex */
public class b {
    private m ale;
    protected a eZM;
    CustomMessageListener eZN;
    CustomMessageListener evY;

    public void q(m mVar) {
        if (mVar != null) {
            this.ale = mVar;
            if (this.eZM != null && this.ale.XQ != null) {
                this.eZM.cV(this.ale.XQ.charmCount);
            }
        }
    }

    public void blv() {
        if (this.eZM != null) {
            this.eZM.blv();
        }
    }

    public void bW(int i) {
    }

    public void setVisible(int i) {
        if (this.eZM != null) {
            this.eZM.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eZN);
        MessageManager.getInstance().unRegisterListener(this.evY);
    }
}
