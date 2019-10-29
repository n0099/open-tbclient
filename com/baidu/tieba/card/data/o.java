package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId eRh = BdUniqueId.gen();
    public long eRi;
    public String eRj;
    public String eRk;
    public String eRl;
    public String eRm;
    public String eRn;
    public long eRo;
    public String eRp;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eRh;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.eRo;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baM() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
    }
}
