package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class g extends b {
    public static final BdUniqueId RQ = BdUniqueId.gen();
    public bk threadData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RQ;
    }
}
