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

    public static boolean V(bg bgVar) {
        return bgVar != null && bgVar.getThreadType() == 49;
    }

    public am uX(String str) {
        am uY = uY(str);
        uY.delete("obj_type");
        uY.delete("obj_type");
        uY.P("obj_type", 3);
        return uY;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg abv() {
        return this.threadData;
    }
}
