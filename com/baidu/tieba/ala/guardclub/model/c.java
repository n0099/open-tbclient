package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long anchorId;
    private int biZ;
    private long gQv;
    private String gQw;
    private String sign;

    public c() {
        super(1021142);
        this.biZ = 2;
    }

    public void fk(long j) {
        this.gQv = j;
    }

    public void HE(String str) {
        this.gQw = str;
    }

    public void HF(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gQv);
        addParam("club_name", this.gQw);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.biZ);
    }
}
