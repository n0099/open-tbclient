package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bg bgVar) {
        this.threadData = bgVar;
    }

    public static boolean W(bg bgVar) {
        return bgVar != null && bgVar.getThreadType() == 49;
    }

    public am tH(String str) {
        am tI = tI(str);
        tI.delete("obj_type");
        tI.delete("obj_type");
        tI.T("obj_type", 3);
        return tI;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg WR() {
        return this.threadData;
    }
}
