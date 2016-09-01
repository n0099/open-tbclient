package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class g extends b {
    public static final BdUniqueId Ro = BdUniqueId.gen();
    public bg threadData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ro;
    }
}
