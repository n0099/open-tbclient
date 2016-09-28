package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class i extends b {
    public static BdUniqueId bbW = BdUniqueId.gen();
    public static BdUniqueId bbX = BdUniqueId.gen();
    public MetaData author;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return bbW;
            case 1:
                return bbX;
            default:
                return bbW;
        }
    }
}
