package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gXI = BdUniqueId.gen();
    private bu aiq;

    public void setData(bu buVar) {
        this.aiq = buVar;
    }

    public bu aPS() {
        return this.aiq;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gXI;
    }
}
