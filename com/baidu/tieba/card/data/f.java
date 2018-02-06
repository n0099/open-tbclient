package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class f extends b {
    public static BdUniqueId cZV = BdUniqueId.gen();
    public static BdUniqueId cZW = BdUniqueId.gen();
    public MetaData aOQ;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cZV;
            case 1:
                return cZW;
            default:
                return cZV;
        }
    }
}
