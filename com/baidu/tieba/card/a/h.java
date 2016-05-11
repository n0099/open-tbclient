package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class h extends b {
    public static BdUniqueId aRI = BdUniqueId.gen();
    public static BdUniqueId aRJ = BdUniqueId.gen();
    public MetaData author;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return aRI;
            case 1:
                return aRJ;
            default:
                return aRI;
        }
    }
}
