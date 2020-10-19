package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long anchorId;
    private int bdM;
    private long grN;
    private String grO;
    private String sign;

    public c() {
        super(1021142);
        this.bdM = 2;
    }

    public void ej(long j) {
        this.grN = j;
    }

    public void GE(String str) {
        this.grO = str;
    }

    public void GF(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.grN);
        addParam("club_name", this.grO);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bdM);
    }
}
