package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId iBC = BdUniqueId.gen();
    public long iBD;
    public String iBE;
    public String iBF;
    public String iBG;
    public String iBH;
    public String iBI;
    public long iBJ;
    public String iBK;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iBC;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.iBJ;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csR() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
    }
}
