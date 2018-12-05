package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class o extends b implements p {
    public static final BdUniqueId cYN = BdUniqueId.gen();
    public long cYO;
    public String cYP;
    public String cYQ;
    public String cYR;
    public String cYS;
    public String cYT;
    public long cYU;
    public String cYV;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cYN;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cYU;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean apU() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fw(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fx(boolean z) {
    }
}
