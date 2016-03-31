package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class k extends b {
    public static BdUniqueId aVL = BdUniqueId.gen();
    public static BdUniqueId aVM = BdUniqueId.gen();
    public MetaData author;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return aVL;
            case 1:
                return aVM;
            default:
                return aVL;
        }
    }
}
