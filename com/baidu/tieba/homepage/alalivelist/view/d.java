package com.baidu.tieba.homepage.alalivelist.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bm bai;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
