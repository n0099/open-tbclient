package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends a {
    public static final BdUniqueId aQc = BdUniqueId.gen();
    private List<g> aOe = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aQc;
    }

    public List<g> DS() {
        return this.aOe;
    }
}
