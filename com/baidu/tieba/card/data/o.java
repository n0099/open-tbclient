package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId fOh = BdUniqueId.gen();
    public long fOi;
    public String fOj;
    public String fOk;
    public String fOl;
    public String fOm;
    public String fOn;
    public long fOo;
    public String fOp;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fOh;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.fOo;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvx() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
    }
}
