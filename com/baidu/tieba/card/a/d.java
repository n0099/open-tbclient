package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements r {
    public static final BdUniqueId aRC = BdUniqueId.gen();
    public boolean aRD;
    public com.baidu.tbadk.core.data.c aRE;
    public String aRF;
    public int mPn;

    public d(com.baidu.tbadk.core.data.c cVar) {
        this.aRF = "";
        this.mPn = 0;
        this.aRE = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.aRF = "";
        this.mPn = 0;
        this.aRE = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aRC;
    }

    @Override // com.baidu.tieba.card.a.r
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.aRE != null ? this.aRE.MT : "-1", -1);
    }

    @Override // com.baidu.tieba.card.a.r
    public boolean Kn() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.r
    public void cj(boolean z) {
        this.aRD = z;
    }

    public String Ko() {
        if (this.aRE == null || this.aRE.Nb == null) {
            return null;
        }
        return this.aRE.Nb.userPortrait;
    }

    public String getUserName() {
        if (this.aRE == null || this.aRE.Nb == null) {
            return null;
        }
        return this.aRE.Nb.userName;
    }

    public String Kp() {
        if (this.aRE == null || this.aRE.Nb == null) {
            return null;
        }
        return this.aRE.Nb.Ni;
    }

    public String Kq() {
        if (this.aRE == null || this.aRE.Nb == null) {
            return null;
        }
        return this.aRE.Nb.EZ;
    }

    public String Kr() {
        if (this.aRE == null || this.aRE.Nb == null) {
            return null;
        }
        return this.aRE.Nb.Nk;
    }

    public List<String> Ks() {
        if (this.aRE == null || this.aRE.Nb == null) {
            return null;
        }
        return this.aRE.Nb.Np;
    }

    public com.baidu.tbadk.core.data.c Kt() {
        return this.aRE;
    }

    public boolean oH() {
        if (this.aRE != null) {
            return this.aRE.oH();
        }
        return false;
    }

    public boolean oG() {
        if (this.aRE != null) {
            return this.aRE.oG();
        }
        return false;
    }
}
