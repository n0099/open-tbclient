package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes8.dex */
public class n extends b implements p {
    public static final BdUniqueId fNJ = BdUniqueId.gen();
    public boolean fNK = true;
    public boolean fNL = true;
    public String fNM;
    public List<m> fNN;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNJ;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvx() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
        this.fNK = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
        this.fNL = z;
    }
}
