package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId fOP = BdUniqueId.gen();
    public long fOQ;
    public String fOR;
    public String fOS;
    public String fOT;
    public String fOU;
    public String fOV;
    public long fOW;
    public String fOX;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fOP;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.fOW;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvC() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kx(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void ky(boolean z) {
    }
}
