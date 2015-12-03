package com.baidu.tieba.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends a {
    public static final BdUniqueId aMW = BdUniqueId.gen();
    private List<d> aMt = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aMW;
    }

    public List<d> Ed() {
        return this.aMt;
    }
}
