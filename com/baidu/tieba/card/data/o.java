package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class o extends b implements p {
    public static final BdUniqueId cRa = BdUniqueId.gen();
    public long cRb;
    public String cRc;
    public String cRd;
    public String cRe;
    public String cRf;
    public String cRg;
    public long cRh;
    public String cRi;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cRa;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cRh;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aoG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fk(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fl(boolean z) {
    }
}
