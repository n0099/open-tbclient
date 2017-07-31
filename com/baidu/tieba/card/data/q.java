package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bKr = BdUniqueId.gen();
    public long bKs;
    public String bKt;
    public String bKu;
    public String bKv;
    public String bKw;
    public String bKx;
    public long bKy;
    public String bKz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bKr;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bKy;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean WK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dF(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }
}
