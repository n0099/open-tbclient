package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes21.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId imQ = BdUniqueId.gen();
    public static BdUniqueId imR = BdUniqueId.gen();
    public MetaData eKe;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return imQ;
            case 1:
                return imR;
            default:
                return imQ;
        }
    }
}
