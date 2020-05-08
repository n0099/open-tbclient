package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes8.dex */
public class e extends k {
    public static final BdUniqueId gsh = BdUniqueId.gen();

    public e(bj bjVar) {
        this.dqE = bjVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gsh;
    }

    public static boolean ab(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.dqV;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIu() {
        return this.dqE;
    }
}
