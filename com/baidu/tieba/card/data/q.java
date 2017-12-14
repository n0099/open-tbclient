package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId ceI = BdUniqueId.gen();
    public long ceJ;
    public String ceK;
    public String ceL;
    public String ceM;
    public String ceN;
    public String ceO;
    public long ceP;
    public String ceQ;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ceI;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.ceP;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ack() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
    }
}
