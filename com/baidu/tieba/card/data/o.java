package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId cCT = BdUniqueId.gen();
    public long cCU;
    public String cCV;
    public String cCW;
    public String cCX;
    public String cCY;
    public String cCZ;
    public long cDa;
    public String cDb;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cCT;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cDa;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajp() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eC(boolean z) {
    }
}
