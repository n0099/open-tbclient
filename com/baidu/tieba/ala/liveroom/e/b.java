package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.m;
/* loaded from: classes3.dex */
public class b {
    private m ald;
    protected a eZy;
    CustomMessageListener eZz;
    CustomMessageListener evK;

    public void q(m mVar) {
        if (mVar != null) {
            this.ald = mVar;
            if (this.eZy != null && this.ald.XQ != null) {
                this.eZy.cV(this.ald.XQ.charmCount);
            }
        }
    }

    public void bls() {
        if (this.eZy != null) {
            this.eZy.bls();
        }
    }

    public void bW(int i) {
    }

    public void setVisible(int i) {
        if (this.eZy != null) {
            this.eZy.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eZz);
        MessageManager.getInstance().unRegisterListener(this.evK);
    }
}
