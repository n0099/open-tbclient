package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bVX = BdUniqueId.gen();
    public long bVY;
    public String bVZ;
    public String bWa;
    public String bWb;
    public String bWc;
    public String bWd;
    public long bWe;
    public String bWf;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bVX;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bWe;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aar() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
    }
}
