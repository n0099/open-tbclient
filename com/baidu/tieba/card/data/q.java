package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bNU = BdUniqueId.gen();
    public long bNV;
    public String bNW;
    public String bNX;
    public String bNY;
    public String bNZ;
    public String bOa;
    public long bOb;
    public String bOc;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bNU;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bOb;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Yg() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dJ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dK(boolean z) {
    }
}
