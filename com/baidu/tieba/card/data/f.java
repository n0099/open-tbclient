package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes5.dex */
public class f extends k {
    public static final BdUniqueId fGS = BdUniqueId.gen();

    public f(bj bjVar) {
        this.cMR = bjVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fGS;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axx() {
        return this.cMR;
    }

    public static boolean Z(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.aBA();
    }
}
