package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class f extends k {
    public static final BdUniqueId izm = BdUniqueId.gen();

    public f(bz bzVar) {
        this.eMv = bzVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return izm;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz boO() {
        return this.eMv;
    }

    public static boolean ae(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        return bzVar.bto();
    }
}
