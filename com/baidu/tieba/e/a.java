package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dnT = BdUniqueId.gen();
    private bb bOk;

    public void setData(bb bbVar) {
        this.bOk = bbVar;
    }

    public bb aaq() {
        return this.bOk;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnT;
    }
}
