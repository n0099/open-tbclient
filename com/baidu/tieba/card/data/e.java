package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class e extends k {
    public static final BdUniqueId iAC = BdUniqueId.gen();

    public e(cb cbVar) {
        this.eJQ = cbVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iAC;
    }

    public static boolean ae(cb cbVar) {
        return cbVar != null && cbVar.getType() == cb.eQB;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb bln() {
        return this.eJQ;
    }
}
