package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long anchorId;
    private int bgy;
    private long gHF;
    private String gHG;
    private String sign;

    public c() {
        super(1021142);
        this.bgy = 2;
    }

    public void eG(long j) {
        this.gHF = j;
    }

    public void Hp(String str) {
        this.gHG = str;
    }

    public void Hq(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gHF);
        addParam("club_name", this.gHG);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bgy);
    }
}
