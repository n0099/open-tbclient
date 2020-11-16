package com.baidu.tieba.homepage.hotTopic.tab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.FrsTabInfoData;
/* loaded from: classes21.dex */
public class b implements q {
    private FrsTabInfoData jCO;

    public b(FrsTabInfoData frsTabInfoData) {
        this.jCO = frsTabInfoData;
    }

    public FrsTabInfoData cyx() {
        return this.jCO;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jCN;
    }
}
