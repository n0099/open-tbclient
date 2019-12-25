package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.k;
/* loaded from: classes2.dex */
public class b {
    private k aio;
    protected a eTY;
    CustomMessageListener eTZ;
    CustomMessageListener eqn;

    public void j(k kVar) {
        if (kVar != null) {
            this.aio = kVar;
            if (this.eTY != null && this.aio.VP != null) {
                this.eTY.cO(this.aio.VP.charmCount);
            }
        }
    }

    public void biR() {
        if (this.eTY != null) {
            this.eTY.biR();
        }
    }

    public void bN(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void setVisible(int i) {
        if (this.eTY != null) {
            this.eTY.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eTZ);
        MessageManager.getInstance().unRegisterListener(this.eqn);
    }
}
