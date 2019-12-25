package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes2.dex */
public class e extends HttpMessage {
    private long Vc;
    private long eBF;
    private String eBG;
    private int eBz;
    private String sign;

    public e() {
        super(1021142);
        this.eBz = 2;
    }

    public void cF(long j) {
        this.eBF = j;
    }

    public void xW(String str) {
        this.eBG = str;
    }

    public void xX(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.eBF);
        addParam("club_name", this.eBG);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Vc + ""));
        addParam("client_type", this.eBz);
    }
}
