package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long WZ;
    private int apX;
    private long eGW;
    private String eGX;
    private String sign;

    public c() {
        super(1021142);
        this.apX = 2;
    }

    public void cM(long j) {
        this.eGW = j;
    }

    public void yx(String str) {
        this.eGX = str;
    }

    public void yy(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.eGW);
        addParam("club_name", this.eGX);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.WZ + ""));
        addParam("client_type", this.apX);
    }
}
