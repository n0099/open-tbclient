package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes15.dex */
public class i extends b {
    public static BdUniqueId hmG = BdUniqueId.gen();
    public static BdUniqueId hmH = BdUniqueId.gen();
    public MetaData ecb;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return hmG;
            case 1:
                return hmH;
            default:
                return hmG;
        }
    }
}
