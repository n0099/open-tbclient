package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes10.dex */
public class e extends HttpMessage {
    private long anchorId;
    private int bfO;
    private long gXC;
    private String gXD;
    private String sign;

    public e() {
        super(1021231);
        this.bfO = 2;
    }

    public void fk(long j) {
        this.gXC = j;
    }

    public void Gs(String str) {
        this.gXD = str;
    }

    public void Gt(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.gXC);
        addParam("club_name", this.gXD);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bfO);
    }
}
