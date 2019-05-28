package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId eBt = BdUniqueId.gen();
    public boolean eBu = true;
    public boolean eBv = true;
    public String eBw;
    public List<m> eBx;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eBt;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aYf() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iy(boolean z) {
        this.eBu = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iz(boolean z) {
        this.eBv = z;
    }
}
