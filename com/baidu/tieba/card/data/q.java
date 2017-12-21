package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId ceM = BdUniqueId.gen();
    public long ceN;
    public String ceO;
    public String ceP;
    public String ceQ;
    public String ceR;
    public String ceS;
    public long ceT;
    public String ceU;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ceM;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.ceT;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean acj() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
    }
}
