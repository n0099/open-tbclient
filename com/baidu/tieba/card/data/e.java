package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes8.dex */
public class e extends k {
    public static final BdUniqueId gUh = BdUniqueId.gen();

    public e(bu buVar) {
        this.dLi = buVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gUh;
    }

    public static boolean ad(bu buVar) {
        return buVar != null && buVar.getType() == bu.dLz;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return this.dLi;
    }
}
