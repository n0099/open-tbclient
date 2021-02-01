package com.baidu.tieba.homepage.hotTopic.tab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.FrsTabInfoData;
/* loaded from: classes2.dex */
public class b implements n {
    private FrsTabInfoData kgE;

    public b(FrsTabInfoData frsTabInfoData) {
        this.kgE = frsTabInfoData;
    }

    public FrsTabInfoData cDe() {
        return this.kgE;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.kgD;
    }
}
