package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
import com.baidu.mobstat.Config;
/* loaded from: classes7.dex */
public class h extends HttpMessage {
    private long aCw;
    private int aXU;
    private int pn;
    private int ps;

    public h() {
        super(1021138);
        this.ps = 20;
        this.pn = 1;
        this.aXU = 2;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void ag(long j) {
        this.aCw = j;
    }

    public void setParams() {
        addParam("scene_from", p.EZ());
        addParam("ps", this.ps);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aCw + ""));
        addParam("client_type", this.aXU);
    }
}
