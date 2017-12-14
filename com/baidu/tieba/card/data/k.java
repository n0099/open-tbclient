package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bd bdVar) {
        this.threadData = bdVar;
    }

    public static boolean F(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 49;
    }

    public ak jV(String str) {
        ak jW = jW(str);
        jW.dO("obj_type");
        jW.dO("obj_type");
        jW.r("obj_type", 3);
        return jW;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.threadData;
    }
}
