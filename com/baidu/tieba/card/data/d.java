package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements s {
    public String aRN;
    public com.baidu.tbadk.core.data.c beQ;
    public String mPageType;
    public int mPn;

    public d(com.baidu.tbadk.core.data.c cVar) {
        this.aRN = "";
        this.mPn = 0;
        this.mPageType = "";
        this.beQ = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.aRN = "";
        this.mPn = 0;
        this.mPageType = "";
        this.beQ = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.beQ != null && this.beQ.PC != null) {
            return com.baidu.tbadk.core.data.c.Pk;
        }
        if (this.beQ != null && this.beQ.getType() == com.baidu.tbadk.core.data.c.OY) {
            return com.baidu.tbadk.core.data.c.Ph;
        }
        if (this.beQ != null && this.beQ.getType() == com.baidu.tbadk.core.data.c.Pc) {
            return com.baidu.tbadk.core.data.c.Pj;
        }
        return com.baidu.tbadk.core.data.c.Pi;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.beQ != null ? this.beQ.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Ps() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cz(boolean z) {
    }

    public String Pt() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.userPortrait;
    }

    public String getUserName() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.userName;
    }

    public String Pu() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.PK;
    }

    public String Pv() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.PM;
    }

    public String Pw() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.buttonText;
    }

    public String Px() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.PT;
    }

    public String Py() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.PN;
    }

    public List<String> Pz() {
        if (this.beQ == null || this.beQ.Pz == null) {
            return null;
        }
        return this.beQ.Pz.PU;
    }

    public com.baidu.tbadk.core.data.c PA() {
        return this.beQ;
    }

    public boolean pl() {
        if (this.beQ != null) {
            return this.beQ.pl();
        }
        return false;
    }

    public boolean pk() {
        if (this.beQ != null) {
            return this.beQ.pk();
        }
        return false;
    }
}
