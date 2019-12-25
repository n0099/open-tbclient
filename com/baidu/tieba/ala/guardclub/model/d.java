package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes2.dex */
public class d extends HttpMessage {
    private long Vc;
    private boolean eBy;
    private int eBz;

    public d() {
        super(1021137);
        this.eBz = 2;
        this.eBy = false;
    }

    public boolean bcI() {
        return this.eBy;
    }

    public void bcJ() {
        this.eBy = true;
    }

    public void cu(long j) {
        this.Vc = j;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.p.yu());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Vc + ""));
        addParam("client_type", this.eBz);
    }
}
