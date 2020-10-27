package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes21.dex */
public class i extends b {
    public static BdUniqueId hVe = BdUniqueId.gen();
    public static BdUniqueId hVf = BdUniqueId.gen();
    public MetaData eyV;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return hVe;
            case 1:
                return hVf;
            default:
                return hVe;
        }
    }
}
