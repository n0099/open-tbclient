package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId cAo = BdUniqueId.gen();
    public long cAp;
    public String cAq;
    public String cAr;
    public String cAs;
    public String cAt;
    public String cAu;
    public long cAv;
    public String cAw;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cAo;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cAv;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aiQ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
    }
}
