package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bi bck;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bi biVar) {
        this.bck = biVar;
    }

    public static boolean n(bi biVar) {
        return biVar != null && biVar.getThreadType() == 49;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Kn() {
        return this.bck;
    }
}
