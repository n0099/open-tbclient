package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes8.dex */
public class n extends b implements p {
    public static final BdUniqueId fNw = BdUniqueId.gen();
    public List<m> fNA;
    public boolean fNx = true;
    public boolean fNy = true;
    public String fNz;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNw;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvw() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
        this.fNx = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
        this.fNy = z;
    }
}
