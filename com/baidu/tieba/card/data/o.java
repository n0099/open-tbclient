package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class o extends b implements p {
    public static final BdUniqueId cCu = BdUniqueId.gen();
    public String cCA;
    public long cCB;
    public String cCC;
    public long cCv;
    public String cCw;
    public String cCx;
    public String cCy;
    public String cCz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cCu;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cCB;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
    }
}
