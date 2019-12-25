package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes5.dex */
public class h extends b {
    public static BdUniqueId fGT = BdUniqueId.gen();
    public static BdUniqueId fGU = BdUniqueId.gen();
    public MetaData cNZ;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return fGT;
            case 1:
                return fGU;
            default:
                return fGT;
        }
    }
}
