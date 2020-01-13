package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.mobstat.Config;
/* loaded from: classes2.dex */
public class m extends HttpMessage {
    private long Vt;
    private int eCK;
    private int pn;
    private int ps;

    public m() {
        super(1021138);
        this.ps = 20;
        this.pn = 1;
        this.eCK = 2;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void cz(long j) {
        this.Vt = j;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.q.yN());
        addParam("ps", this.ps);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Vt + ""));
        addParam("client_type", this.eCK);
    }
}
