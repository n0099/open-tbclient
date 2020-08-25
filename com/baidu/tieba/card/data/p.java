package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class p extends b implements q {
    public static final BdUniqueId hnT = BdUniqueId.gen();
    public long hnU;
    public String hnV;
    public String hnW;
    public String hnX;
    public String hnY;
    public String hnZ;
    public long hoa;
    public String hob;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hnT;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.hoa;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccq() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nn(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void no(boolean z) {
    }
}
