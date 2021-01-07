package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId iAz = BdUniqueId.gen();
    public long iAA;
    public String iAB;
    public String iAC;
    public String iAD;
    public String iAE;
    public String iAF;
    public long iAG;
    public String iAH;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iAz;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.iAG;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cvx() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void py(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pz(boolean z) {
    }
}
