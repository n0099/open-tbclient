package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId eGT = BdUniqueId.gen();
    public long eGU;
    public String eGV;
    public String eGW;
    public String eGX;
    public String eGY;
    public String eGZ;
    public long eHa;
    public String eHb;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eGT;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.eHa;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bag() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
    }
}
