package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes7.dex */
public class c extends HttpMessage {
    private long aCu;
    private int aXS;
    private long gch;
    private String gci;
    private String sign;

    public c() {
        super(1021142);
        this.aXS = 2;
    }

    public void dY(long j) {
        this.gch = j;
    }

    public void Fv(String str) {
        this.gci = str;
    }

    public void Fw(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gch);
        addParam("club_name", this.gci);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aCu + ""));
        addParam("client_type", this.aXS);
    }
}
