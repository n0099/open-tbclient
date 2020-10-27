package com.baidu.tieba.homepage.hotTopic.tab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.FrsTabInfoData;
/* loaded from: classes22.dex */
public class b implements q {
    private FrsTabInfoData jvU;

    public b(FrsTabInfoData frsTabInfoData) {
        this.jvU = frsTabInfoData;
    }

    public FrsTabInfoData cwt() {
        return this.jvU;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jvT;
    }
}
