package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private int aIQ;
    private long apl;
    private long flJ;
    private String flK;
    private String sign;

    public c() {
        super(1021142);
        this.aIQ = 2;
    }

    public void du(long j) {
        this.flJ = j;
    }

    public void Ag(String str) {
        this.flK = str;
    }

    public void Ah(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.flJ);
        addParam("club_name", this.flK);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.apl + ""));
        addParam("client_type", this.aIQ);
    }
}
