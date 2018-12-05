package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes6.dex */
public class f extends b {
    public static BdUniqueId cXP = BdUniqueId.gen();
    public static BdUniqueId cXQ = BdUniqueId.gen();
    public MetaData atK;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cXP;
            case 1:
                return cXQ;
            default:
                return cXP;
        }
    }
}
