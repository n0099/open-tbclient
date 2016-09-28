package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId bbT = BdUniqueId.gen();
    public bi bbU;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bbT;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Jv() {
        return this.bbU;
    }
}
