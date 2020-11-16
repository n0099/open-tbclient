package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
/* loaded from: classes20.dex */
public class e extends k {
    public static final BdUniqueId ibR = BdUniqueId.gen();

    public e(bx bxVar) {
        this.evQ = bxVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ibR;
    }

    public static boolean ad(bx bxVar) {
        return bxVar != null && bxVar.getType() == bx.eCg;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bx bjd() {
        return this.evQ;
    }
}
