package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bj bbv;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bj bjVar) {
        this.bbv = bjVar;
    }

    public static boolean n(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 49;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj JN() {
        return this.bbv;
    }
}
