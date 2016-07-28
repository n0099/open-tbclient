package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class i extends b {
    public static BdUniqueId aWc = BdUniqueId.gen();
    public static BdUniqueId aWd = BdUniqueId.gen();
    public MetaData author;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return aWc;
            case 1:
                return aWd;
            default:
                return aWc;
        }
    }
}
