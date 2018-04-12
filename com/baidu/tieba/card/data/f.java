package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes2.dex */
public class f extends b {
    public static BdUniqueId crK = BdUniqueId.gen();
    public static BdUniqueId crL = BdUniqueId.gen();
    public MetaData aae;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return crK;
            case 1:
                return crL;
            default:
                return crK;
        }
    }
}
