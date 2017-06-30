package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class k extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bm bai;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bm bmVar) {
        this.bai = bmVar;
    }

    public static boolean x(bm bmVar) {
        return bmVar != null && bmVar.getThreadType() == 49;
    }

    @Override // com.baidu.tieba.card.data.c
    public bm Mv() {
        return this.bai;
    }
}
