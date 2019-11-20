package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes6.dex */
public class d extends HttpMessage {
    private long Of;
    private boolean dNq;
    private int dNr;

    public d() {
        super(1021137);
        this.dNr = 2;
        this.dNq = false;
    }

    public boolean aLz() {
        return this.dNq;
    }

    public void aLA() {
        this.dNq = true;
    }

    public void bZ(long j) {
        this.Of = j;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.o.wu());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Of + ""));
        addParam("client_type", this.dNr);
    }
}
