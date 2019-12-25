package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes5.dex */
public class n extends b implements p {
    public static final BdUniqueId fHO = BdUniqueId.gen();
    public boolean fHP = true;
    public boolean fHQ = true;
    public String fHR;
    public List<m> fHS;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fHO;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bsO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kf(boolean z) {
        this.fHP = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kg(boolean z) {
        this.fHQ = z;
    }
}
