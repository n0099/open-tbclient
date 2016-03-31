package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends a {
    public static BdUniqueId TC = BdUniqueId.gen();
    private List<com.baidu.tieba.horizonalList.widget.l> mList = new ArrayList();

    public void a(r rVar) {
        this.mList.add(rVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.l> FZ() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return TC;
    }
}
