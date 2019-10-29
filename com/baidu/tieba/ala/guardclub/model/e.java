package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes6.dex */
public class e extends HttpMessage {
    private long OF;
    private int dOi;
    private long dOo;
    private String dOp;
    private String sign;

    public e() {
        super(1021142);
        this.dOi = 2;
    }

    public void cb(long j) {
        this.dOo = j;
    }

    public void tl(String str) {
        this.dOp = str;
    }

    public void tm(String str) {
        this.sign = str;
    }

    public void setParams() {
        addParam("guard_club_id", this.dOo);
        addParam("club_name", this.dOp);
        addParam("sign", this.sign);
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.OF + ""));
        addParam("client_type", this.dOi);
    }
}
