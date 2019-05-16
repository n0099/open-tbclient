package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId eBP = BdUniqueId.gen();
    public long eBQ;
    public String eBR;
    public String eBS;
    public String eBT;
    public String eBU;
    public String eBV;
    public long eBW;
    public String eBX;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eBP;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.eBW;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aYc() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iz(boolean z) {
    }
}
