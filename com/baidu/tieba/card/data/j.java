package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes2.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bd bdVar) {
        this.threadData = bdVar;
    }

    public static boolean N(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 49;
    }

    public am lh(String str) {
        am li = li(str);
        li.delete("obj_type");
        li.delete("obj_type");
        li.r("obj_type", 3);
        return li;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c
    public bd Sz() {
        return this.threadData;
    }
}
