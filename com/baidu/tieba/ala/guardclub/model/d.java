package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes6.dex */
public class d extends HttpMessage {
    private long OF;
    private boolean dOh;
    private int dOi;

    public d() {
        super(1021137);
        this.dOi = 2;
        this.dOh = false;
    }

    public boolean aLB() {
        return this.dOh;
    }

    public void aLC() {
        this.dOh = true;
    }

    public void ca(long j) {
        this.OF = j;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.o.wt());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.OF + ""));
        addParam("client_type", this.dOi);
    }
}
