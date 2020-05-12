package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId gtC = BdUniqueId.gen();
    public long gtD;
    public String gtE;
    public String gtF;
    public String gtG;
    public String gtH;
    public String gtI;
    public long gtJ;
    public String gtK;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gtC;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.gtJ;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bFm() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void lB(boolean z) {
    }
}
