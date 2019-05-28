package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId eBQ = BdUniqueId.gen();
    public long eBR;
    public String eBS;
    public String eBT;
    public String eBU;
    public String eBV;
    public String eBW;
    public long eBX;
    public String eBY;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eBQ;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.eBX;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aYf() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iz(boolean z) {
    }
}
