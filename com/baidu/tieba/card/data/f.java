package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes8.dex */
public class f extends k {
    public static final BdUniqueId fMN = BdUniqueId.gen();

    public f(bj bjVar) {
        this.cRg = bjVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fMN;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAg() {
        return this.cRg;
    }

    public static boolean ab(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.aEg();
    }
}
