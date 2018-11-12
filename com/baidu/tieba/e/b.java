package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ddJ = BdUniqueId.gen();
    private bb bJG;

    public void setData(bb bbVar) {
        this.bJG = bbVar;
    }

    public bb YL() {
        return this.bJG;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ddJ;
    }
}
