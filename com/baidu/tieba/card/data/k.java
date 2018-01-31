package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bd bdVar) {
        this.threadData = bdVar;
    }

    public static boolean J(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 49;
    }

    public ak kq(String str) {
        ak kr = kr(str);
        kr.ea("obj_type");
        kr.ea("obj_type");
        kr.s("obj_type", 3);
        return kr;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c
    public bd VM() {
        return this.threadData;
    }
}
