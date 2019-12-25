package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes5.dex */
public class e extends k {
    public static final BdUniqueId fGR = BdUniqueId.gen();

    public e(bj bjVar) {
        this.cMR = bjVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fGR;
    }

    public static boolean Y(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cNi;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axx() {
        return this.cMR;
    }
}
