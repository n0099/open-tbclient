package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes10.dex */
public class e extends HttpMessage {
    private long anchorId;
    private int bkx;
    private long hcj;
    private String hck;
    private String sign;

    public e() {
        super(1021231);
        this.bkx = 2;
    }

    public void fq(long j) {
        this.hcj = j;
    }

    public void Hb(String str) {
        this.hck = str;
    }

    public void Hc(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.hcj);
        addParam("club_name", this.hck);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bkx);
    }
}
