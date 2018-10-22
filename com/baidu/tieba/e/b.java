package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dcD = BdUniqueId.gen();
    private bb bIV;

    public void setData(bb bbVar) {
        this.bIV = bbVar;
    }

    public bb YB() {
        return this.bIV;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcD;
    }
}
