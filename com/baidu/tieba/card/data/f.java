package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class f extends b {
    public static BdUniqueId cdD = BdUniqueId.gen();
    public static BdUniqueId cdE = BdUniqueId.gen();
    public MetaData YW;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return cdD;
            case 1:
                return cdE;
            default:
                return cdD;
        }
    }
}
