package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class o extends b implements p {
    public static final BdUniqueId cSg = BdUniqueId.gen();
    public long cSh;
    public String cSi;
    public String cSj;
    public String cSk;
    public String cSl;
    public String cSm;
    public long cSn;
    public String cSo;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cSg;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.cSn;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aoh() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fv(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fw(boolean z) {
    }
}
