package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId fNS = BdUniqueId.gen();
    public long fNT;
    public String fNU;
    public String fNV;
    public String fNW;
    public String fNX;
    public String fNY;
    public long fNZ;
    public String fOa;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNS;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.fNZ;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvu() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
    }
}
