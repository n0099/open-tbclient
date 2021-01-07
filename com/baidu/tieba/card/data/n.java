package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId iAa = BdUniqueId.gen();
    public boolean iAb = true;
    public boolean iAc = true;
    public String iAd;
    public List<m> iAe;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iAa;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cvx() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void py(boolean z) {
        this.iAb = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pz(boolean z) {
        this.iAc = z;
    }
}
