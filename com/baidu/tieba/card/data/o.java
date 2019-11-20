package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId eQq = BdUniqueId.gen();
    public long eQr;
    public String eQs;
    public String eQt;
    public String eQu;
    public String eQv;
    public String eQw;
    public long eQx;
    public String eQy;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eQq;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.eQx;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
    }
}
