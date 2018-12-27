package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dnh = BdUniqueId.gen();
    private bb bNy;

    public void setData(bb bbVar) {
        this.bNy = bbVar;
    }

    public bb ZT() {
        return this.bNy;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnh;
    }
}
