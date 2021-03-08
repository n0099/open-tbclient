package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class e extends k {
    public static final BdUniqueId iCl = BdUniqueId.gen();

    public e(cb cbVar) {
        this.eLr = cbVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iCl;
    }

    public static boolean ae(cb cbVar) {
        return cbVar != null && cbVar.getType() == cb.eSc;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb blp() {
        return this.eLr;
    }
}
