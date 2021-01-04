package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iCP = BdUniqueId.gen();
    private bz alW;

    public void setData(bz bzVar) {
        this.alW = bzVar;
    }

    public bz boO() {
        return this.alW;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iCP;
    }
}
