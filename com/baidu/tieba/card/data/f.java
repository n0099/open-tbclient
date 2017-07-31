package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class f extends b {
    public static BdUniqueId bJs = BdUniqueId.gen();
    public static BdUniqueId bJt = BdUniqueId.gen();
    public MetaData author;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return bJs;
            case 1:
                return bJt;
            default:
                return bJs;
        }
    }
}
