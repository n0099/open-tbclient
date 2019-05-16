package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId eBs = BdUniqueId.gen();
    public boolean eBt = true;
    public boolean eBu = true;
    public String eBv;
    public List<m> eBw;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eBs;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aYc() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iy(boolean z) {
        this.eBt = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iz(boolean z) {
        this.eBu = z;
    }
}
