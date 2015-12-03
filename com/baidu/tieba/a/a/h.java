package com.baidu.tieba.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId aML = BdUniqueId.gen();
    private final List<com.baidu.tbadk.widget.horizonalScrollListView.f> aMt = new ArrayList();

    public void a(com.baidu.tbadk.widget.horizonalScrollListView.f fVar) {
        this.aMt.add(fVar);
    }

    public List<com.baidu.tbadk.widget.horizonalScrollListView.f> Ed() {
        return this.aMt;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aML;
    }
}
