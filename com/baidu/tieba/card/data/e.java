package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes8.dex */
public class e extends k {
    public static final BdUniqueId fMx = BdUniqueId.gen();

    public e(bj bjVar) {
        this.cRe = bjVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fMx;
    }

    public static boolean aa(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cRv;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAe() {
        return this.cRe;
    }
}
