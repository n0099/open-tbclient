package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes11.dex */
public class e extends HttpMessage {
    private long anchorId;
    private int biX;
    private long haA;
    private String haB;
    private String sign;

    public e() {
        super(1021231);
        this.biX = 2;
    }

    public void fq(long j) {
        this.haA = j;
    }

    public void GS(String str) {
        this.haB = str;
    }

    public void GT(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.haA);
        addParam("club_name", this.haB);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.biX);
    }
}
