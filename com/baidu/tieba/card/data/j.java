package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bd bdVar) {
        this.threadData = bdVar;
    }

    public static boolean M(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 49;
    }

    public ak ky(String str) {
        ak kz = kz(str);
        kz.em("obj_type");
        kz.em("obj_type");
        kz.s("obj_type", 3);
        return kz;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c
    public bd WD() {
        return this.threadData;
    }
}
