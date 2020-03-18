package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes8.dex */
public class h extends b {
    public static BdUniqueId fNw = BdUniqueId.gen();
    public static BdUniqueId fNx = BdUniqueId.gen();
    public MetaData cSB;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return fNw;
            case 1:
                return fNx;
            default:
                return fNw;
        }
    }
}
