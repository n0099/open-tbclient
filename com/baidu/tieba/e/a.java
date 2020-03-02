package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQe = BdUniqueId.gen();
    private bj NQ;

    public void setData(bj bjVar) {
        this.NQ = bjVar;
    }

    public bj aAg() {
        return this.NQ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQe;
    }
}
