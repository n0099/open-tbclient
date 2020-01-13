package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes6.dex */
public class e extends k {
    public static final BdUniqueId fKb = BdUniqueId.gen();

    public e(bj bjVar) {
        this.cNb = bjVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKb;
    }

    public static boolean Z(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cNs;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axQ() {
        return this.cNb;
    }
}
