package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class p extends b implements q {
    public static final BdUniqueId hnX = BdUniqueId.gen();
    public long hnY;
    public String hnZ;
    public String hoa;
    public String hob;
    public String hoc;
    public String hod;
    public long hoe;
    public String hof;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hnX;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.hoe;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccr() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void np(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void nq(boolean z) {
    }
}
