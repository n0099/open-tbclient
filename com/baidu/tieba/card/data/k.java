package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes15.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bw bwVar) {
        this.dUW = bwVar;
    }

    public static boolean aa(bw bwVar) {
        return bwVar != null && bwVar.getThreadType() == 49;
    }

    public aq He(String str) {
        aq Hf = Hf(str);
        Hf.delete("obj_type");
        Hf.delete("obj_type");
        Hf.ai("obj_type", 3);
        return Hf;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this.dUW;
    }
}
