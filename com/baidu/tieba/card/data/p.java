package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class p extends b implements q {
    public static final BdUniqueId hJW = BdUniqueId.gen();
    public long hJX;
    public String hJY;
    public String hJZ;
    public String hKa;
    public String hKb;
    public String hKc;
    public long hKd;
    public String hKe;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hJW;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.hKd;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cjc() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void ob(boolean z) {
    }
}
