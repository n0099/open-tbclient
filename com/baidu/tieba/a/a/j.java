package com.baidu.tieba.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId aMX = BdUniqueId.gen();
    private List<e> aMt = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aMX;
    }

    public List<e> Ed() {
        return this.aMt;
    }
}
