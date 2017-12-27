package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId cTq = BdUniqueId.gen();
    public long cTr;
    public String cTs;
    public String cTt;
    public String cTu;
    public String cTv;
    public String cTw;
    public long cTx;
    public String cTy;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return cTq;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.cTx;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ajP() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eD(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eE(boolean z) {
    }
}
