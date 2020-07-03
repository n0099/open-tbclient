package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private int aRl;
    private long awn;
    private long fKP;
    private String fKQ;
    private String sign;

    public c() {
        super(1021142);
        this.aRl = 2;
    }

    public void dz(long j) {
        this.fKP = j;
    }

    public void Co(String str) {
        this.fKQ = str;
    }

    public void Cp(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.fKP);
        addParam("club_name", this.fKQ);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.awn + ""));
        addParam("client_type", this.aRl);
    }
}
