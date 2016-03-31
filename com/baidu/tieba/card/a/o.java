package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends a {
    public static final BdUniqueId TC = BdUniqueId.gen();
    private final List<com.baidu.tbadk.widget.a.g> aTc = new ArrayList();

    public void a(com.baidu.tbadk.widget.a.g gVar) {
        this.aTc.add(gVar);
    }

    public List<com.baidu.tbadk.widget.a.g> FZ() {
        return this.aTc;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return TC;
    }
}
