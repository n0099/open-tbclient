package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes11.dex */
public class e extends HttpMessage {
    private long anchorId;
    private int biX;
    private long ham;
    private String han;
    private String sign;

    public e() {
        super(1021231);
        this.biX = 2;
    }

    public void fq(long j) {
        this.ham = j;
    }

    public void GR(String str) {
        this.han = str;
    }

    public void GS(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.ham);
        addParam("club_name", this.han);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.biX);
    }
}
