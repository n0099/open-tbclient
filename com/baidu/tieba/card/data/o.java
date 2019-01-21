package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class o extends b implements p {
    public static final BdUniqueId dcs = BdUniqueId.gen();
    public long dcA;
    public String dcB;
    public long dct;
    public String dcv;
    public String dcw;
    public String dcx;
    public String dcy;
    public String dcz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcs;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.dcA;
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
