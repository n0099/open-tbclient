package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class o extends b implements p {
    public static final BdUniqueId hbc = BdUniqueId.gen();
    public long hbd;
    public String hbe;
    public String hbf;
    public String hbg;
    public String hbh;
    public String hbi;
    public long hbj;
    public String hbk;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hbc;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.hbj;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bSe() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void mL(boolean z) {
    }
}
