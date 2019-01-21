package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes6.dex */
public class f extends b {
    public static BdUniqueId dbt = BdUniqueId.gen();
    public static BdUniqueId dbu = BdUniqueId.gen();
    public MetaData aun;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return dbt;
            case 1:
                return dbu;
            default:
                return dbt;
        }
    }
}
