package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes2.dex */
public class e extends HttpMessage {
    private long Vt;
    private int eCK;
    private long eCQ;
    private String eCR;
    private String sign;

    public e() {
        super(1021142);
        this.eCK = 2;
    }

    public void cK(long j) {
        this.eCQ = j;
    }

    public void yb(String str) {
        this.eCR = str;
    }

    public void yc(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.eCQ);
        addParam("club_name", this.eCR);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Vt + ""));
        addParam("client_type", this.eCK);
    }
}
