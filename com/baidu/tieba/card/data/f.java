package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes2.dex */
public class f extends b {
    public static BdUniqueId cBV = BdUniqueId.gen();
    public static BdUniqueId cBW = BdUniqueId.gen();
    public MetaData aib;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cBV;
            case 1:
                return cBW;
            default:
                return cBV;
        }
    }
}
