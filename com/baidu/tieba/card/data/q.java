package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class q extends b implements s {
    public static final BdUniqueId bcA = BdUniqueId.gen();
    public boolean bcB = true;
    public boolean bcC = true;
    public String bcD;
    public List<p> bcE;
    public int bcF;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bcA;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Op() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
        this.bcB = z;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cu(boolean z) {
        this.bcC = z;
    }
}
