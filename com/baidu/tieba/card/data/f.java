package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class f extends b {
    public static BdUniqueId cZJ = BdUniqueId.gen();
    public static BdUniqueId cZK = BdUniqueId.gen();
    public MetaData aOF;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cZJ;
            case 1:
                return cZK;
            default:
                return cZJ;
        }
    }
}
