package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId iDz = BdUniqueId.gen();
    public long iDA;
    public String iDB;
    public String iDC;
    public String iDD;
    public String iDE;
    public String iDF;
    public long iDG;
    public String iDH;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iDz;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.iDG;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cte() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
    }
}
