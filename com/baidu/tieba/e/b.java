package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fRb = BdUniqueId.gen();
    private bj NR;

    public void setData(bj bjVar) {
        this.NR = bjVar;
    }

    public bj aAj() {
        return this.NR;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRb;
    }
}
