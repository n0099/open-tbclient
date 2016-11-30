package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId beR = BdUniqueId.gen();
    public bk beS;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return beR;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk Jz() {
        return this.beS;
    }
}
