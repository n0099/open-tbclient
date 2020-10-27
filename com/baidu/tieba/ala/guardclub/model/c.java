package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long anchorId;
    private int bfd;
    private long gBR;
    private String gBS;
    private String sign;

    public c() {
        super(1021142);
        this.bfd = 2;
    }

    public void ek(long j) {
        this.gBR = j;
    }

    public void Hc(String str) {
        this.gBS = str;
    }

    public void Hd(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gBR);
        addParam("club_name", this.gBS);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bfd);
    }
}
