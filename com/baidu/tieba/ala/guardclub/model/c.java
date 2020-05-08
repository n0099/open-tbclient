package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private int aIW;
    private long aps;
    private long flO;
    private String flP;
    private String sign;

    public c() {
        super(1021142);
        this.aIW = 2;
    }

    public void du(long j) {
        this.flO = j;
    }

    public void Aj(String str) {
        this.flP = str;
    }

    public void Ak(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.flO);
        addParam("club_name", this.flP);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aps + ""));
        addParam("client_type", this.aIW);
    }
}
