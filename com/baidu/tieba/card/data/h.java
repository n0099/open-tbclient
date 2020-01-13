package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes6.dex */
public class h extends b {
    public static BdUniqueId fKd = BdUniqueId.gen();
    public static BdUniqueId fKe = BdUniqueId.gen();
    public MetaData cOj;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return fKd;
            case 1:
                return fKe;
            default:
                return fKd;
        }
    }
}
