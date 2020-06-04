package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes8.dex */
public class f extends k {
    public static final BdUniqueId gHi = BdUniqueId.gen();

    public f(bk bkVar) {
        this.dEA = bkVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gHi;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return this.dEA;
    }

    public static boolean ad(bk bkVar) {
        if (bkVar == null) {
            return false;
        }
        return bkVar.aSv();
    }
}
