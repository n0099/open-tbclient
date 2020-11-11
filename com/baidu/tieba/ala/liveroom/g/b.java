package com.baidu.tieba.ala.liveroom.g;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public class b {
    private w aES;
    CustomMessageListener gvo;
    protected a hgi;
    CustomMessageListener hgj;

    public void D(w wVar) {
        if (wVar != null) {
            this.aES = wVar;
            if (this.hgi != null && this.aES.aIV != null) {
                this.hgi.eX(this.aES.aIV.charmCount);
            }
        }
    }

    public void cbd() {
        if (this.hgi != null) {
            this.hgi.cbd();
        }
    }

    public void dI(int i) {
    }

    public void setVisible(int i) {
        if (this.hgi != null) {
            this.hgi.getView().setVisibility(i);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hgj);
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }
}
