package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bc;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cLO = BdUniqueId.gen();
    private bc btP;

    public void setData(bc bcVar) {
        this.btP = bcVar;
    }

    public bc SV() {
        return this.btP;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cLO;
    }
}
