package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bh aVi;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bh bhVar) {
        this.aVi = bhVar;
    }

    public static boolean n(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 49;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Ji() {
        return this.aVi;
    }
}
