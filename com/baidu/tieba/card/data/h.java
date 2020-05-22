package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes8.dex */
public class h extends b {
    public static BdUniqueId gGY = BdUniqueId.gen();
    public static BdUniqueId gGZ = BdUniqueId.gen();
    public MetaData dFJ;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return gGY;
            case 1:
                return gGZ;
            default:
                return gGY;
        }
    }
}
