package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long anchorId;
    private int beK;
    private long gHm;
    private String gHn;
    private String sign;

    public c() {
        super(1021142);
        this.beK = 2;
    }

    public void eG(long j) {
        this.gHm = j;
    }

    public void GQ(String str) {
        this.gHn = str;
    }

    public void GR(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gHm);
        addParam("club_name", this.gHn);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.beK);
    }
}
