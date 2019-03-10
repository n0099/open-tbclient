package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId emt = BdUniqueId.gen();
    public long emA;
    public String emB;
    public long emu;
    public String emv;
    public String emw;
    public String emx;
    public String emy;
    public String emz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return emt;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.emA;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQW() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
    }
}
