package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId iBQ = BdUniqueId.gen();
    public long iBR;
    public String iBS;
    public String iBT;
    public String iBU;
    public String iBV;
    public String iBW;
    public long iBX;
    public String iBY;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iBQ;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.iBX;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csY() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
    }
}
