package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a {
    public static final BdUniqueId aSh = BdUniqueId.gen();
    private List<h> aQh = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aSh;
    }

    public List<h> Fm() {
        return this.aQh;
    }
}
