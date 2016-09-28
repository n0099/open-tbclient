package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class g extends b {
    public static final BdUniqueId Ru = BdUniqueId.gen();
    public bi threadData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ru;
    }
}
