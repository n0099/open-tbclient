package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    private long anchorId;
    private int bkE;
    private long hci;
    private String hcj;
    private String sign;

    public c() {
        super(1021142);
        this.bkE = 2;
    }

    public void fk(long j) {
        this.hci = j;
    }

    public void HE(String str) {
        this.hcj = str;
    }

    public void HF(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.hci);
        addParam("club_name", this.hcj);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bkE);
    }
}
