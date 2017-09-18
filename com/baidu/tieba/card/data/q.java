package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bOL = BdUniqueId.gen();
    public long bOM;
    public String bON;
    public String bOO;
    public String bOP;
    public String bOQ;
    public String bOR;
    public long bOS;
    public String bOT;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bOL;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bOS;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Yr() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dL(boolean z) {
    }
}
