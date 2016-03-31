package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s extends a {
    public static final BdUniqueId aVQ = BdUniqueId.gen();
    private List<h> aTc = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aVQ;
    }

    public List<h> FZ() {
        return this.aTc;
    }
}
