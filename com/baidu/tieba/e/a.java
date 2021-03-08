package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iFP = BdUniqueId.gen();
    private cb amn;

    public void setData(cb cbVar) {
        this.amn = cbVar;
    }

    public cb blp() {
        return this.amn;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iFP;
    }
}
