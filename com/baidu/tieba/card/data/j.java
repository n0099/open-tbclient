package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes8.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bu buVar) {
        this.dLi = buVar;
    }

    public static boolean ad(bu buVar) {
        return buVar != null && buVar.getThreadType() == 49;
    }

    public ao DT(String str) {
        ao DU = DU(str);
        DU.delete("obj_type");
        DU.delete("obj_type");
        DU.ag("obj_type", 3);
        return DU;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return this.dLi;
    }
}
