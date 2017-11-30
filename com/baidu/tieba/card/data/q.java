package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId ceu = BdUniqueId.gen();
    public String ceA;
    public long ceB;
    public String ceC;
    public long cev;
    public String cew;
    public String cex;
    public String cey;
    public String cez;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ceu;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.ceB;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aca() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dV(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
    }
}
