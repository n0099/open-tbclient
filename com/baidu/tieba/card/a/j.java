package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends a {
    public static BdUniqueId Oq = BdUniqueId.gen();
    private List<com.baidu.tieba.horizonalList.widget.l> mList = new ArrayList();

    public void a(k kVar) {
        this.mList.add(kVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.l> DR() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Oq;
    }
}
