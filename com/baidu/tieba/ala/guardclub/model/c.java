package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long aDf;
    private int bas;
    private long gfy;
    private String gfz;
    private String sign;

    public c() {
        super(1021142);
        this.bas = 2;
    }

    public void ea(long j) {
        this.gfy = j;
    }

    public void FT(String str) {
        this.gfz = str;
    }

    public void FU(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gfy);
        addParam("club_name", this.gfz);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aDf + ""));
        addParam("client_type", this.bas);
    }
}
