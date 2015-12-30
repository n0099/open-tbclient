package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId aQa = BdUniqueId.gen();
    private String aOa;
    private List<com.baidu.tieba.horizonalList.widget.n> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aQa;
    }

    public void b(com.baidu.tieba.horizonalList.widget.n nVar) {
        this.mList.add(nVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.n> DS() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String Iy() {
        return this.aOa;
    }

    public void setYuelaouLocate(String str) {
        this.aOa = str;
    }
}
