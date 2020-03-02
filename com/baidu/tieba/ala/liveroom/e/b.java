package com.baidu.tieba.ala.liveroom.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.m;
/* loaded from: classes3.dex */
public class b {
    private m ald;
    CustomMessageListener eZA;
    protected a eZz;
    CustomMessageListener evL;

    public void q(m mVar) {
        if (mVar != null) {
            this.ald = mVar;
            if (this.eZz != null && this.ald.XQ != null) {
                this.eZz.cV(this.ald.XQ.charmCount);
            }
        }
    }

    public void blu() {
        if (this.eZz != null) {
            this.eZz.blu();
        }
    }

    public void bW(int i) {
    }

    public void setVisible(int i) {
        if (this.eZz != null) {
            this.eZz.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eZA);
        MessageManager.getInstance().unRegisterListener(this.evL);
    }
}
