package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private int aOF;
    private long aul;
    private long fzG;
    private String fzH;
    private String sign;

    public c() {
        super(1021142);
        this.aOF = 2;
    }

    public void dw(long j) {
        this.fzG = j;
    }

    public void BQ(String str) {
        this.fzH = str;
    }

    public void BR(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.fzG);
        addParam("club_name", this.fzH);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aul + ""));
        addParam("client_type", this.aOF);
    }
}
