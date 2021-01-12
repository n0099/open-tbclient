package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId ivt = BdUniqueId.gen();
    public boolean ivu = true;
    public boolean ivv = true;
    public String ivw;
    public List<m> ivx;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ivt;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean crF() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pu(boolean z) {
        this.ivu = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pv(boolean z) {
        this.ivv = z;
    }
}
