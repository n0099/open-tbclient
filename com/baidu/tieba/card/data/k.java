package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bl blVar) {
        this.threadData = blVar;
    }

    public static boolean B(bl blVar) {
        return blVar != null && blVar.getThreadType() == 49;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c
    public bl MF() {
        return this.threadData;
    }
}
