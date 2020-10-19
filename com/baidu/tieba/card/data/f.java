package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes21.dex */
public class f extends l {
    public static final BdUniqueId hIF = BdUniqueId.gen();

    public f(bw bwVar) {
        this.eji = bwVar;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hIF;
    }

    public static boolean ab(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.epz;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return this.eji;
    }
}
