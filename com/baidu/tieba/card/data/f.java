package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes2.dex */
public class f extends b {
    public static BdUniqueId cBS = BdUniqueId.gen();
    public static BdUniqueId cBT = BdUniqueId.gen();
    public MetaData aib;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cBS;
            case 1:
                return cBT;
            default:
                return cBS;
        }
    }
}
