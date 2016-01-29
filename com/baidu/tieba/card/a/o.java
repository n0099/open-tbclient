package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends a {
    public static final BdUniqueId aSg = BdUniqueId.gen();
    private List<g> aQh = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aSg;
    }

    public List<g> Fm() {
        return this.aQh;
    }
}
