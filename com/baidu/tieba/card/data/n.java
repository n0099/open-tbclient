package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId icG = BdUniqueId.gen();
    public boolean icH = true;
    public boolean icI = true;
    public String icJ;
    public List<m> icK;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return icG;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cop() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void oE(boolean z) {
        this.icH = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void oF(boolean z) {
        this.icI = z;
    }
}
