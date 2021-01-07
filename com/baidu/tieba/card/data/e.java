package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class e extends k {
    public static final BdUniqueId izl = BdUniqueId.gen();

    public e(bz bzVar) {
        this.eMv = bzVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return izl;
    }

    public static boolean ad(bz bzVar) {
        return bzVar != null && bzVar.getType() == bz.eTa;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz boP() {
        return this.eMv;
    }
}
