package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes8.dex */
public class h extends b {
    public static BdUniqueId fMO = BdUniqueId.gen();
    public static BdUniqueId fMP = BdUniqueId.gen();
    public MetaData cSo;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return fMO;
            case 1:
                return fMP;
            default:
                return fMO;
        }
    }
}
