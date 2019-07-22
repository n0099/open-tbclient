package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes3.dex */
public class f extends b {
    public MetaData bKb;
    public static BdUniqueId eFz = BdUniqueId.gen();
    public static BdUniqueId eFA = BdUniqueId.gen();
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return eFz;
            case 1:
                return eFA;
            default:
                return eFz;
        }
    }
}
