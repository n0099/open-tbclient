package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId cCQ = BdUniqueId.gen();
    public long cCR;
    public String cCS;
    public String cCT;
    public String cCU;
    public String cCV;
    public String cCW;
    public long cCX;
    public String cCY;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cCQ;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cCX;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajs() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eC(boolean z) {
    }
}
