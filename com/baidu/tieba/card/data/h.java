package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class h extends b {
    public static BdUniqueId bxj = BdUniqueId.gen();
    public static BdUniqueId bxk = BdUniqueId.gen();
    public MetaData author;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return bxj;
            case 1:
                return bxk;
            default:
                return bxj;
        }
    }
}
