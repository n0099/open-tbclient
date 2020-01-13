package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes2.dex */
public class d extends HttpMessage {
    private long Vt;
    private boolean eCJ;
    private int eCK;

    public d() {
        super(1021137);
        this.eCK = 2;
        this.eCJ = false;
    }

    public boolean bdd() {
        return this.eCJ;
    }

    public void bde() {
        this.eCJ = true;
    }

    public void cz(long j) {
        this.Vt = j;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.q.yN());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Vt + ""));
        addParam("client_type", this.eCK);
    }
}
