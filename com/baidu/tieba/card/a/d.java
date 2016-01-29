package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d extends b implements w {
    public static final BdUniqueId aRP = BdUniqueId.gen();
    public boolean aRQ;
    public com.baidu.tbadk.core.data.c aRR;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRP;
    }

    @Override // com.baidu.tieba.card.a.w
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.aRR != null ? this.aRR.Uz : "-1", -1);
    }

    @Override // com.baidu.tieba.card.a.w
    public boolean Kk() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.w
    public void bT(boolean z) {
        this.aRQ = z;
    }

    public String Kl() {
        if (this.aRR == null || this.aRR.UI == null) {
            return null;
        }
        return this.aRR.UI.userPortrait;
    }

    public String getUserName() {
        if (this.aRR == null || this.aRR.UI == null) {
            return null;
        }
        return this.aRR.UI.userName;
    }

    public String Km() {
        if (this.aRR == null || this.aRR.UI == null) {
            return null;
        }
        return this.aRR.UI.UQ;
    }

    public String Kn() {
        if (this.aRR == null || this.aRR.UI == null) {
            return null;
        }
        return this.aRR.UI.OC;
    }

    public String Ko() {
        if (this.aRR == null || this.aRR.UI == null) {
            return null;
        }
        return this.aRR.UI.US;
    }

    public com.baidu.tbadk.core.data.c Kp() {
        return this.aRR;
    }

    public boolean rO() {
        if (this.aRR != null) {
            return this.aRR.rO();
        }
        return false;
    }

    public boolean rN() {
        if (this.aRR != null) {
            return this.aRR.rN();
        }
        return false;
    }
}
