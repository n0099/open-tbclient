package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends a {
    public static BdUniqueId RQ = BdUniqueId.gen();
    private List<com.baidu.tieba.horizonalList.widget.l> mList = new ArrayList();

    public void a(l lVar) {
        this.mList.add(lVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.l> Fy() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RQ;
    }
}
