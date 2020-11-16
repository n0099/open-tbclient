package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
/* loaded from: classes20.dex */
public class f extends k {
    public static final BdUniqueId ibS = BdUniqueId.gen();

    public f(bx bxVar) {
        this.evQ = bxVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ibS;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bx bjd() {
        return this.evQ;
    }

    public static boolean ae(bx bxVar) {
        if (bxVar == null) {
            return false;
        }
        return bxVar.bnz();
    }
}
