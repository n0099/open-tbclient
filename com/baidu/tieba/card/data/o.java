package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId ivS = BdUniqueId.gen();
    public long ivT;
    public String ivU;
    public String ivV;
    public String ivW;
    public String ivX;
    public String ivY;
    public long ivZ;
    public String iwa;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ivS;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.ivZ;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean crF() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pu(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pv(boolean z) {
    }
}
