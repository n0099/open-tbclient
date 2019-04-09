package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId emc = BdUniqueId.gen();
    public long emd;
    public String eme;
    public String emf;
    public String emg;
    public String emh;
    public String emi;
    public long emj;
    public String emk;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return emc;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.emj;
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
