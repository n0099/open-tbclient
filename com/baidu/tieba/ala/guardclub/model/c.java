package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private int aSE;
    private long axs;
    private long fQj;
    private String fQk;
    private String sign;

    public c() {
        super(1021142);
        this.aSE = 2;
    }

    public void dN(long j) {
        this.fQj = j;
    }

    public void Da(String str) {
        this.fQk = str;
    }

    public void Db(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.fQj);
        addParam("club_name", this.fQk);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.axs + ""));
        addParam("client_type", this.aSE);
    }
}
