package com.baidu.tieba.ala.liveroom.f;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.ab;
/* loaded from: classes11.dex */
public class b {
    private ab aDd;
    CustomMessageListener gNG;
    protected a hBn;
    CustomMessageListener hBo;

    public void J(ab abVar) {
        if (abVar != null) {
            this.aDd = abVar;
            if (this.hBn != null && this.aDd.aId != null) {
                this.hBn.fG(this.aDd.aId.charmCount);
            }
        }
    }

    public void cet() {
        if (this.hBn != null) {
            this.hBn.cet();
        }
    }

    public void cr(int i) {
    }

    public void setVisible(int i) {
        if (this.hBn != null) {
            this.hBn.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hBo);
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }
}
