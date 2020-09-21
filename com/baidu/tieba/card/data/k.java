package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes20.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bw bwVar) {
        this.dXg = bwVar;
    }

    public static boolean ab(bw bwVar) {
        return bwVar != null && bwVar.getThreadType() == 49;
    }

    public aq HB(String str) {
        aq HC = HC(str);
        HC.delete("obj_type");
        HC.delete("obj_type");
        HC.ai("obj_type", 3);
        return HC;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return this.dXg;
    }
}
