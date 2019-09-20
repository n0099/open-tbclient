package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bh bhVar) {
        this.threadData = bhVar;
    }

    public static boolean X(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 49;
    }

    public an wc(String str) {
        an wd = wd(str);
        wd.nX("obj_type");
        wd.nX("obj_type");
        wd.P("obj_type", 3);
        return wd;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh acC() {
        return this.threadData;
    }
}
