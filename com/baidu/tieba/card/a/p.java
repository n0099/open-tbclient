package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a {
    public static final BdUniqueId aVP = BdUniqueId.gen();
    private List<g> aTc = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aVP;
    }

    public List<g> FZ() {
        return this.aTc;
    }
}
