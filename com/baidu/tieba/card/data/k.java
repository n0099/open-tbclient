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

    public static boolean D(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 49;
    }

    public ak jX(String str) {
        ak jY = jY(str);
        jY.dO("obj_type");
        jY.dO("obj_type");
        jY.r("obj_type", 3);
        return jY;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.threadData;
    }
}
