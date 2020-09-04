package com.baidu.tieba.homepage.hotTopic.tab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.FrsTabInfoData;
/* loaded from: classes16.dex */
public class b implements q {
    private FrsTabInfoData iLT;

    public b(FrsTabInfoData frsTabInfoData) {
        this.iLT = frsTabInfoData;
    }

    public FrsTabInfoData cmC() {
        return this.iLT;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.iLS;
    }
}
