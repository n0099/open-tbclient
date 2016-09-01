package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements s {
    public String ahj;
    public com.baidu.tbadk.core.data.b bbA;
    public boolean bbz;
    public String mPageType;
    public int mPn;

    public d(com.baidu.tbadk.core.data.b bVar) {
        this.ahj = "";
        this.mPn = 0;
        this.mPageType = "";
        this.bbA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.ahj = "";
        this.mPn = 0;
        this.mPageType = "";
        this.bbA = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return (this.bbA == null || this.bbA.getType() != com.baidu.tbadk.core.data.b.OQ) ? com.baidu.tbadk.core.data.b.OU : com.baidu.tbadk.core.data.b.OV;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return com.baidu.adp.lib.h.b.g(this.bbA != null ? this.bbA.Pf : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean NO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
        this.bbz = z;
    }

    public String NP() {
        if (this.bbA == null || this.bbA.Pn == null) {
            return null;
        }
        return this.bbA.Pn.Pr;
    }

    public String getUserName() {
        if (this.bbA == null || this.bbA.Pn == null) {
            return null;
        }
        return this.bbA.Pn.userName;
    }

    public String NQ() {
        if (this.bbA == null || this.bbA.Pn == null) {
            return null;
        }
        return this.bbA.Pn.Ps;
    }

    public String NR() {
        if (this.bbA == null || this.bbA.Pn == null) {
            return null;
        }
        return this.bbA.Pn.HT;
    }

    public String NS() {
        if (this.bbA == null || this.bbA.Pn == null) {
            return null;
        }
        return this.bbA.Pn.Pz;
    }

    public String NT() {
        if (this.bbA == null || this.bbA.Pn == null) {
            return null;
        }
        return this.bbA.Pn.Pu;
    }

    public List<String> NU() {
        if (this.bbA == null || this.bbA.Pn == null) {
            return null;
        }
        return this.bbA.Pn.PA;
    }

    public com.baidu.tbadk.core.data.b NV() {
        return this.bbA;
    }

    public boolean pi() {
        if (this.bbA != null) {
            return this.bbA.pi();
        }
        return false;
    }

    public boolean ph() {
        if (this.bbA != null) {
            return this.bbA.ph();
        }
        return false;
    }
}
