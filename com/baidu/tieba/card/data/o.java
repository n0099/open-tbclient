package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class o extends b implements p {
    public static final BdUniqueId dcr = BdUniqueId.gen();
    public String dcA;
    public long dcs;
    public String dct;
    public String dcv;
    public String dcw;
    public String dcx;
    public String dcy;
    public long dcz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcr;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.dcz;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean arg() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fC(boolean z) {
    }
}
