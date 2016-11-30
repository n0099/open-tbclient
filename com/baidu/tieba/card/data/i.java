package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class i extends b {
    public static BdUniqueId beU = BdUniqueId.gen();
    public static BdUniqueId beV = BdUniqueId.gen();
    public MetaData author;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return beU;
            case 1:
                return beV;
            default:
                return beU;
        }
    }
}
