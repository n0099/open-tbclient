package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes6.dex */
public class f extends k {
    public static final BdUniqueId fKc = BdUniqueId.gen();

    public f(bj bjVar) {
        this.cNb = bjVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKc;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axQ() {
        return this.cNb;
    }

    public static boolean aa(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.aBT();
    }
}
