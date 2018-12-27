package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class o extends b implements p {
    public static final BdUniqueId dbF = BdUniqueId.gen();
    public long dbG;
    public String dbH;
    public String dbI;
    public String dbJ;
    public String dbK;
    public String dbL;
    public long dbM;
    public String dbN;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dbF;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.dbM;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aqJ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fz(boolean z) {
    }
}
