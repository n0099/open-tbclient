package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId ctQ = BdUniqueId.gen();
    public long ctR;
    public String ctS;
    public String ctT;
    public String ctU;
    public String ctV;
    public String ctW;
    public long ctX;
    public String ctY;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ctQ;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.ctX;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean afO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void ex(boolean z) {
    }
}
