package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.m;
/* loaded from: classes3.dex */
public class b {
    private m alp;
    CustomMessageListener ewu;
    protected a fak;
    CustomMessageListener fal;

    public void q(m mVar) {
        if (mVar != null) {
            this.alp = mVar;
            if (this.fak != null && this.alp.Ya != null) {
                this.fak.cV(this.alp.Ya.charmCount);
            }
        }
    }

    public void blA() {
        if (this.fak != null) {
            this.fak.blA();
        }
    }

    public void bW(int i) {
    }

    public void setVisible(int i) {
        if (this.fak != null) {
            this.fak.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fal);
        MessageManager.getInstance().unRegisterListener(this.ewu);
    }
}
