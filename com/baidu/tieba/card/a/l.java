package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId aQb = BdUniqueId.gen();
    private List<f> aOe = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aQb;
    }

    public List<f> DS() {
        return this.aOe;
    }
}
