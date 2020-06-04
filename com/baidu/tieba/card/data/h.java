package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes8.dex */
public class h extends b {
    public static BdUniqueId gHj = BdUniqueId.gen();
    public static BdUniqueId gHk = BdUniqueId.gen();
    public MetaData dFJ;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return gHj;
            case 1:
                return gHk;
            default:
                return gHj;
        }
    }
}
