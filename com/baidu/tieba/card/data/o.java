package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId eIC = BdUniqueId.gen();
    public long eID;
    public String eIE;
    public String eIF;
    public String eIG;
    public String eIH;
    public String eII;
    public long eIJ;
    public String eIK;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eIC;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.eIJ;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iL(boolean z) {
    }
}
