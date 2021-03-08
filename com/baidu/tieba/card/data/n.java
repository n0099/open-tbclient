package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId iDa = BdUniqueId.gen();
    public boolean iDb = true;
    public boolean iDc = true;
    public String iDd;
    public List<m> iDe;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iDa;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cte() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
        this.iDb = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
        this.iDc = z;
    }
}
