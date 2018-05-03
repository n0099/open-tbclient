package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes2.dex */
public class f extends b {
    public static BdUniqueId crH = BdUniqueId.gen();
    public static BdUniqueId crI = BdUniqueId.gen();
    public MetaData aae;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return crH;
            case 1:
                return crI;
            default:
                return crH;
        }
    }
}
