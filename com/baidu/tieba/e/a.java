package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOw = BdUniqueId.gen();
    private bb buw;

    public void setData(bb bbVar) {
        this.buw = bbVar;
    }

    public bb Td() {
        return this.buw;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOw;
    }
}
