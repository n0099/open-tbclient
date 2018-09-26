package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId cIH = BdUniqueId.gen();
    public long cII;
    public String cIJ;
    public String cIK;
    public String cIL;
    public String cIM;
    public String cIN;
    public long cIO;
    public String cIP;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cIH;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cIO;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ald() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eS(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eT(boolean z) {
    }
}
