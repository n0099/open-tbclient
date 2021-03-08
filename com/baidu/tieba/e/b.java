package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId iFQ = BdUniqueId.gen();
    private cb amn;

    public void setData(cb cbVar) {
        this.amn = cbVar;
    }

    public cb blp() {
        return this.amn;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iFQ;
    }
}
