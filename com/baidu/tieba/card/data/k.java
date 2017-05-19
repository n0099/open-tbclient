package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class k extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bk bcB;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bk bkVar) {
        this.bcB = bkVar;
    }

    public static boolean s(bk bkVar) {
        return bkVar != null && bkVar.getThreadType() == 49;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk JB() {
        return this.bcB;
    }
}
