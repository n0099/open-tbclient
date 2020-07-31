package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes15.dex */
public class h extends b {
    public static BdUniqueId gZN = BdUniqueId.gen();
    public static BdUniqueId gZO = BdUniqueId.gen();
    public MetaData dSF;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return gZN;
            case 1:
                return gZO;
            default:
                return gZN;
        }
    }
}
