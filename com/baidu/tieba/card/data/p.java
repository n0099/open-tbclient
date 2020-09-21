package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes21.dex */
public class p extends b implements q {
    public static final BdUniqueId hvb = BdUniqueId.gen();
    public long hvc;
    public String hvd;
    public String hve;
    public String hvf;
    public String hvg;
    public String hvh;
    public long hvi;
    public String hvj;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hvb;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.hvi;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cfG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nv(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void nw(boolean z) {
    }
}
