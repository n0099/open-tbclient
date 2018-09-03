package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOu = BdUniqueId.gen();
    private bb buy;

    public void setData(bb bbVar) {
        this.buy = bbVar;
    }

    public bb Tg() {
        return this.buy;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOu;
    }
}
