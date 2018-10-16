package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes6.dex */
public class f extends b {
    public static BdUniqueId cQc = BdUniqueId.gen();
    public static BdUniqueId cQd = BdUniqueId.gen();
    public MetaData apx;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cQc;
            case 1:
                return cQd;
            default:
                return cQc;
        }
    }
}
