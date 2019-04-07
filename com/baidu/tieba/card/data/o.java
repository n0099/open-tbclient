package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId emb = BdUniqueId.gen();
    public long emc;
    public String emd;
    public String eme;
    public String emf;
    public String emg;
    public String emh;
    public long emi;
    public String emj;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return emb;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.emi;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQT() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
    }
}
