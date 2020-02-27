package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long WZ;
    private int apW;
    private long eGI;
    private String eGJ;
    private String sign;

    public c() {
        super(1021142);
        this.apW = 2;
    }

    public void cM(long j) {
        this.eGI = j;
    }

    public void yw(String str) {
        this.eGJ = str;
    }

    public void yx(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.eGI);
        addParam("club_name", this.eGJ);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.WZ + ""));
        addParam("client_type", this.apW);
    }
}
