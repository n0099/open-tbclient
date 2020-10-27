package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class p extends b implements q {
    public static final BdUniqueId hWt = BdUniqueId.gen();
    public long hWA;
    public String hWB;
    public long hWu;
    public String hWv;
    public String hWw;
    public String hWx;
    public String hWy;
    public String hWz;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWt;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.hWA;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cmj() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void os(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void ot(boolean z) {
    }
}
