package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iEg = BdUniqueId.gen();
    private cb akU;

    public void setData(cb cbVar) {
        this.akU = cbVar;
    }

    public cb bln() {
        return this.akU;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEg;
    }
}
