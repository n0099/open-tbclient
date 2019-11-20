package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.i;
/* loaded from: classes6.dex */
public class b {
    private i aaj;
    CustomMessageListener dEz;
    protected a eee;
    CustomMessageListener eef;

    public void h(i iVar) {
        if (iVar != null) {
            this.aaj = iVar;
            if (this.eee != null && this.aaj.OR != null) {
                this.eee.ci(this.aaj.OR.charmCount);
            }
        }
    }

    public void aRq() {
        if (this.eee != null) {
            this.eee.aRq();
        }
    }

    public void bw(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void setVisible(int i) {
        if (this.eee != null) {
            this.eee.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eef);
        MessageManager.getInstance().unRegisterListener(this.dEz);
    }
}
