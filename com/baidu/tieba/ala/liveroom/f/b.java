package com.baidu.tieba.ala.liveroom.f;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.l;
/* loaded from: classes2.dex */
public class b {
    private l aiW;
    protected a eVH;
    CustomMessageListener eVI;
    CustomMessageListener erA;

    public void l(l lVar) {
        if (lVar != null) {
            this.aiW = lVar;
            if (this.eVH != null && this.aiW.Wf != null) {
                this.eVH.cT(this.aiW.Wf.charmCount);
            }
        }
    }

    public void bjD() {
        if (this.eVH != null) {
            this.eVH.bjD();
        }
    }

    public void bN(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void setVisible(int i) {
        if (this.eVH != null) {
            this.eVH.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eVI);
        MessageManager.getInstance().unRegisterListener(this.erA);
    }
}
