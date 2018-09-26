package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cUk = BdUniqueId.gen();
    private bb bAn;

    public void setData(bb bbVar) {
        this.bAn = bbVar;
    }

    public bb UT() {
        return this.bAn;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUk;
    }
}
