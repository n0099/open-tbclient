package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes20.dex */
public class i extends b {
    public static BdUniqueId htN = BdUniqueId.gen();
    public static BdUniqueId htO = BdUniqueId.gen();
    public MetaData eep;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return htN;
            case 1:
                return htO;
            default:
                return htN;
        }
    }
}
