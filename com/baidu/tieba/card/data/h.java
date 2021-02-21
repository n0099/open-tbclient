package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId iAE = BdUniqueId.gen();
    public static BdUniqueId iAF = BdUniqueId.gen();
    public MetaData eRz;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return iAE;
            case 1:
                return iAF;
            default:
                return iAE;
        }
    }
}
