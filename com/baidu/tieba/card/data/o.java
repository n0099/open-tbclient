package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class o extends b implements p {
    public static final BdUniqueId fLw = BdUniqueId.gen();
    public String fLA;
    public String fLB;
    public String fLC;
    public long fLD;
    public String fLE;
    public long fLx;
    public String fLy;
    public String fLz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fLw;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.fLD;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean btQ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kq(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kr(boolean z) {
    }
}
