package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId elS = BdUniqueId.gen();
    public boolean elT = true;
    public boolean elU = true;
    public String elV;
    public List<m> elW;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return elS;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQV() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
        this.elT = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
        this.elU = z;
    }
}
