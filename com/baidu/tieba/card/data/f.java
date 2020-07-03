package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes8.dex */
public class f extends k {
    public static final BdUniqueId gUi = BdUniqueId.gen();

    public f(bu buVar) {
        this.dLi = buVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gUi;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return this.dLi;
    }

    public static boolean ae(bu buVar) {
        if (buVar == null) {
            return false;
        }
        return buVar.aUl();
    }
}
