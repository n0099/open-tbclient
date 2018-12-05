package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dkq = BdUniqueId.gen();
    private bb bNv;

    public void setData(bb bbVar) {
        this.bNv = bbVar;
    }

    public bb ZR() {
        return this.bNv;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkq;
    }
}
