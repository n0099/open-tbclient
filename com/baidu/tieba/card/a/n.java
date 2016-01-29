package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends a {
    public static final BdUniqueId aRS = BdUniqueId.gen();
    private final List<com.baidu.tbadk.widget.a.g> aQh = new ArrayList();

    public void a(com.baidu.tbadk.widget.a.g gVar) {
        this.aQh.add(gVar);
    }

    public List<com.baidu.tbadk.widget.a.g> Fm() {
        return this.aQh;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRS;
    }
}
