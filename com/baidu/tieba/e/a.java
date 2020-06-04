package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gKK = BdUniqueId.gen();
    private bk ahg;

    public void setData(bk bkVar) {
        this.ahg = bkVar;
    }

    public bk aOi() {
        return this.ahg;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKK;
    }
}
