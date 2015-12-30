package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId aPP = BdUniqueId.gen();
    private final List<com.baidu.tbadk.widget.a.g> aOe = new ArrayList();

    public void a(com.baidu.tbadk.widget.a.g gVar) {
        this.aOe.add(gVar);
    }

    public List<com.baidu.tbadk.widget.a.g> DS() {
        return this.aOe;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aPP;
    }
}
