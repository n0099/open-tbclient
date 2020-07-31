package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class h extends HttpMessage {
    private int aSE;
    private long axs;
    private int pn;
    private int ps;

    public h() {
        super(1021138);
        this.ps = 20;
        this.pn = 1;
        this.aSE = 2;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void af(long j) {
        this.axs = j;
    }

    public void setParams() {
        addParam("scene_from", p.zw());
        addParam("ps", this.ps);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.axs + ""));
        addParam("client_type", this.aSE);
    }
}
