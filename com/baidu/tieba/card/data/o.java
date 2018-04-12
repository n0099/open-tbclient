package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId csJ = BdUniqueId.gen();
    public long csK;
    public String csL;
    public String csM;
    public String csN;
    public String csO;
    public String csP;
    public long csQ;
    public String csR;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return csJ;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.csQ;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean afO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ev(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
    }
}
