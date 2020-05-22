package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes8.dex */
public class e extends k {
    public static final BdUniqueId gGW = BdUniqueId.gen();

    public e(bk bkVar) {
        this.dEA = bkVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gGW;
    }

    public static boolean ac(bk bkVar) {
        return bkVar != null && bkVar.getType() == bk.dER;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return this.dEA;
    }
}
