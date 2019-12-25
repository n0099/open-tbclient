package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class o extends b implements p {
    public static final BdUniqueId fIm = BdUniqueId.gen();
    public long fIn;
    public String fIo;
    public String fIp;
    public String fIq;
    public String fIr;
    public String fIs;
    public long fIt;
    public String fIu;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fIm;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.fIt;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bsO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kf(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kg(boolean z) {
    }
}
