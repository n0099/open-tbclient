package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends a {
    public static BdUniqueId OB = BdUniqueId.gen();
    private List<com.baidu.tieba.horizonalList.widget.l> mList = new ArrayList();

    public void a(l lVar) {
        this.mList.add(lVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.l> Ea() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return OB;
    }
}
