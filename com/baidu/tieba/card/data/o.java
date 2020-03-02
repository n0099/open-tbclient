package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId fNU = BdUniqueId.gen();
    public long fNV;
    public String fNW;
    public String fNX;
    public String fNY;
    public String fNZ;
    public String fOa;
    public long fOb;
    public String fOc;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNU;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.fOb;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvw() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
    }
}
