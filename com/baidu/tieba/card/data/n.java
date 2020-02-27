package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes8.dex */
public class n extends b implements p {
    public static final BdUniqueId fNu = BdUniqueId.gen();
    public boolean fNv = true;
    public boolean fNw = true;
    public String fNx;
    public List<m> fNy;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNu;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvu() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
        this.fNv = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
        this.fNw = z;
    }
}
