package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId gtw = BdUniqueId.gen();
    public String gtA;
    public String gtB;
    public String gtC;
    public long gtD;
    public String gtE;
    public long gtx;
    public String gty;
    public String gtz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gtw;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.gtD;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bFn() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void lB(boolean z) {
    }
}
