package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends b implements p {
    public static final BdUniqueId fKY = BdUniqueId.gen();
    public boolean fKZ = true;
    public boolean fLa = true;
    public String fLb;
    public List<m> fLc;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKY;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean btQ() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kq(boolean z) {
        this.fKZ = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kr(boolean z) {
        this.fLa = z;
    }
}
