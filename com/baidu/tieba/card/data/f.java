package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes20.dex */
public class f extends l {
    public static final BdUniqueId htL = BdUniqueId.gen();

    public f(bw bwVar) {
        this.dXg = bwVar;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return htL;
    }

    public static boolean ab(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.edu;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return this.dXg;
    }
}
