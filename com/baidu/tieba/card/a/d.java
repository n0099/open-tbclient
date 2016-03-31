package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d extends b implements z {
    public static final BdUniqueId aVx = BdUniqueId.gen();
    public boolean aVy;
    public com.baidu.tbadk.core.data.c aVz;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aVx;
    }

    @Override // com.baidu.tieba.card.a.z
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.aVz != null ? this.aVz.Sf : "-1", -1);
    }

    @Override // com.baidu.tieba.card.a.z
    public boolean LE() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.z
    public void cd(boolean z) {
        this.aVy = z;
    }

    public String LF() {
        if (this.aVz == null || this.aVz.Sn == null) {
            return null;
        }
        return this.aVz.Sn.userPortrait;
    }

    public String getUserName() {
        if (this.aVz == null || this.aVz.Sn == null) {
            return null;
        }
        return this.aVz.Sn.userName;
    }

    public String LG() {
        if (this.aVz == null || this.aVz.Sn == null) {
            return null;
        }
        return this.aVz.Sn.Su;
    }

    public String LH() {
        if (this.aVz == null || this.aVz.Sn == null) {
            return null;
        }
        return this.aVz.Sn.OJ;
    }

    public String LI() {
        if (this.aVz == null || this.aVz.Sn == null) {
            return null;
        }
        return this.aVz.Sn.Sw;
    }

    public com.baidu.tbadk.core.data.c LJ() {
        return this.aVz;
    }

    public boolean rm() {
        if (this.aVz != null) {
            return this.aVz.rm();
        }
        return false;
    }

    public boolean rl() {
        if (this.aVz != null) {
            return this.aVz.rl();
        }
        return false;
    }
}
