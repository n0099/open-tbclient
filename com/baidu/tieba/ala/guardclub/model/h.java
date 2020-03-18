package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class h extends HttpMessage {
    private long Xj;
    private int aqh;
    private int pn;
    private int ps;

    public h() {
        super(1021138);
        this.ps = 20;
        this.pn = 1;
        this.aqh = 2;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void D(long j) {
        this.Xj = j;
    }

    public void setParams() {
        addParam("scene_from", q.sN());
        addParam("ps", this.ps);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Xj + ""));
        addParam("client_type", this.aqh);
    }
}
