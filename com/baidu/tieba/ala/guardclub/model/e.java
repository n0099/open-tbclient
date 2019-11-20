package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes6.dex */
public class e extends HttpMessage {
    private long Of;
    private int dNr;
    private long dNx;
    private String dNy;
    private String sign;

    public e() {
        super(1021142);
        this.dNr = 2;
    }

    public void ca(long j) {
        this.dNx = j;
    }

    public void tl(String str) {
        this.dNy = str;
    }

    public void tm(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.dNx);
        addParam("club_name", this.dNy);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Of + ""));
        addParam("client_type", this.dNr);
    }
}
