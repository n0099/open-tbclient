package com.baidu.tieba.homepage.hotTopic.tab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.FrsTabInfoData;
/* loaded from: classes22.dex */
public class b implements q {
    private FrsTabInfoData jjx;

    public b(FrsTabInfoData frsTabInfoData) {
        this.jjx = frsTabInfoData;
    }

    public FrsTabInfoData ctm() {
        return this.jjx;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jjw;
    }
}
