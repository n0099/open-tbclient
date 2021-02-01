package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class f extends k {
    public static final BdUniqueId iAp = BdUniqueId.gen();

    public f(cb cbVar) {
        this.eJQ = cbVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iAp;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb bln() {
        return this.eJQ;
    }

    public static boolean af(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        return cbVar.bpN();
    }
}
