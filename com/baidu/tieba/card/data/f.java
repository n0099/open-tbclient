package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes3.dex */
public class f extends b {
    public static BdUniqueId elf = BdUniqueId.gen();
    public static BdUniqueId elg = BdUniqueId.gen();
    public MetaData bBE;
    public int type = 0;
    public int rank = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.type) {
            case 0:
                return elf;
            case 1:
                return elg;
            default:
                return elf;
        }
    }
}
