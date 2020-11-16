package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes20.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId ibT = BdUniqueId.gen();
    public static BdUniqueId ibU = BdUniqueId.gen();
    public MetaData eDc;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return ibT;
            case 1:
                return ibU;
            default:
                return ibT;
        }
    }
}
