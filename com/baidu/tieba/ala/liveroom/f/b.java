package com.baidu.tieba.ala.liveroom.f;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.ab;
/* loaded from: classes10.dex */
public class b {
    private ab aED;
    CustomMessageListener gPp;
    protected a hCW;
    CustomMessageListener hCX;

    public void J(ab abVar) {
        if (abVar != null) {
            this.aED = abVar;
            if (this.hCW != null && this.aED.aJD != null) {
                this.hCW.fG(this.aED.aJD.charmCount);
            }
        }
    }

    public void cez() {
        if (this.hCW != null) {
            this.hCW.cez();
        }
    }

    public void cs(int i) {
    }

    public void setVisible(int i) {
        if (this.hCW != null) {
            this.hCW.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hCX);
        MessageManager.getInstance().unRegisterListener(this.gPp);
    }
}
