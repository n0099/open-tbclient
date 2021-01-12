package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iyi = BdUniqueId.gen();
    private bz ale;

    public void setData(bz bzVar) {
        this.ale = bzVar;
    }

    public bz bkV() {
        return this.ale;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iyi;
    }
}
