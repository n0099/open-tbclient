package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long Xj;
    private int aqh;
    private long eHs;
    private String eHt;
    private String sign;

    public c() {
        super(1021142);
        this.aqh = 2;
    }

    public void cM(long j) {
        this.eHs = j;
    }

    public void yy(String str) {
        this.eHt = str;
    }

    public void yz(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.eHs);
        addParam("club_name", this.eHt);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Xj + ""));
        addParam("client_type", this.aqh);
    }
}
