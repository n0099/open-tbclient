package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b implements t {
    public String bjT;
    public com.baidu.tbadk.core.data.c boc;
    public String mPageType;
    public int mPn;

    public d(com.baidu.tbadk.core.data.c cVar) {
        this.bjT = "";
        this.mPn = 0;
        this.mPageType = "";
        this.boc = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.bjT = "";
        this.mPn = 0;
        this.mPageType = "";
        this.boc = null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.boc != null && this.boc.legoCard != null) {
            return com.baidu.tbadk.core.data.c.Os;
        }
        if (this.boc != null && this.boc.getType() == com.baidu.tbadk.core.data.c.Og) {
            return com.baidu.tbadk.core.data.c.Op;
        }
        if (this.boc != null && this.boc.getType() == com.baidu.tbadk.core.data.c.Oj) {
            return com.baidu.tbadk.core.data.c.Or;
        }
        return com.baidu.tbadk.core.data.c.Oq;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.boc != null ? this.boc.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean RE() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
    }

    public String RF() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.userPortrait;
    }

    public String getUserName() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.userName;
    }

    public String RG() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.OP;
    }

    public String RH() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.OQ;
    }

    public String RI() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.buttonText;
    }

    public String RJ() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.OW;
    }

    public String RK() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.OR;
    }

    public List<String> RL() {
        if (this.boc == null || this.boc.OF == null) {
            return null;
        }
        return this.boc.OF.OX;
    }

    public com.baidu.tbadk.core.data.c RM() {
        return this.boc;
    }

    public boolean pe() {
        if (this.boc != null) {
            return this.boc.pe();
        }
        return false;
    }

    public boolean pd() {
        if (this.boc != null) {
            return this.boc.pd();
        }
        return false;
    }
}
