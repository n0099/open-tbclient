package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId csG = BdUniqueId.gen();
    public long csH;
    public String csI;
    public String csJ;
    public String csK;
    public String csL;
    public String csM;
    public long csN;
    public String csO;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return csG;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.csN;
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
