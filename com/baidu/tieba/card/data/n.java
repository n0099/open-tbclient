package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId eQK = BdUniqueId.gen();
    public boolean eQL = true;
    public boolean eQM = true;
    public String eQN;
    public List<m> eQO;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eQK;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baM() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
        this.eQL = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
        this.eQM = z;
    }
}
