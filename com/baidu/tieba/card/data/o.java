package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId eGM = BdUniqueId.gen();
    public long eGN;
    public String eGO;
    public String eGP;
    public String eGQ;
    public String eGR;
    public String eGS;
    public long eGT;
    public String eGU;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eGM;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.eGT;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bae() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
    }
}
