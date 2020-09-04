package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes15.dex */
public class i extends b {
    public static BdUniqueId hmK = BdUniqueId.gen();
    public static BdUniqueId hmL = BdUniqueId.gen();
    public MetaData ecf;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return hmK;
            case 1:
                return hmL;
            default:
                return hmK;
        }
    }
}
