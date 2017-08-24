package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bLb = BdUniqueId.gen();
    public long bLc;
    public String bLd;
    public String bLe;
    public String bLf;
    public String bLg;
    public String bLh;
    public long bLi;
    public String bLj;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bLb;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bLi;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Xd() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
    }
}
