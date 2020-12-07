package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
/* loaded from: classes21.dex */
public class f extends k {
    public static final BdUniqueId imP = BdUniqueId.gen();

    public f(by byVar) {
        this.eCR = byVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return imP;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public by bmn() {
        return this.eCR;
    }

    public static boolean ae(by byVar) {
        if (byVar == null) {
            return false;
        }
        return byVar.bqM();
    }
}
