package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes8.dex */
public class h extends b {
    public static BdUniqueId gUj = BdUniqueId.gen();
    public static BdUniqueId gUk = BdUniqueId.gen();
    public MetaData dMu;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return gUj;
            case 1:
                return gUk;
            default:
                return gUj;
        }
    }
}
