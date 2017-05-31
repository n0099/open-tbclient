package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class k extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bl aYA;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bl blVar) {
        this.aYA = blVar;
    }

    public static boolean w(bl blVar) {
        return blVar != null && blVar.getThreadType() == 49;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl LH() {
        return this.aYA;
    }
}
