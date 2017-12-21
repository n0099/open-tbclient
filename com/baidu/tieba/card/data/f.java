package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class f extends b {
    public static BdUniqueId cdH = BdUniqueId.gen();
    public static BdUniqueId cdI = BdUniqueId.gen();
    public MetaData YZ;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cdH;
            case 1:
                return cdI;
            default:
                return cdH;
        }
    }
}
