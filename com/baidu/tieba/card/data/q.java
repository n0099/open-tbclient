package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bLa = BdUniqueId.gen();
    public long bLb;
    public String bLc;
    public String bLd;
    public String bLe;
    public String bLf;
    public String bLg;
    public long bLh;
    public String bLi;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bLa;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bLh;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Xg() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
    }
}
