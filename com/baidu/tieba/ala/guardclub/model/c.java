package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes7.dex */
public class c extends HttpMessage {
    private long aCw;
    private int aXU;
    private long gcl;
    private String gcm;
    private String sign;

    public c() {
        super(1021142);
        this.aXU = 2;
    }

    public void dY(long j) {
        this.gcl = j;
    }

    public void Fw(String str) {
        this.gcm = str;
    }

    public void Fx(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gcl);
        addParam("club_name", this.gcm);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aCw + ""));
        addParam("client_type", this.aXU);
    }
}
