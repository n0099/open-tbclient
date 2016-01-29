package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends a {
    public static final BdUniqueId aSf = BdUniqueId.gen();
    private String aQd;
    private List<com.baidu.tieba.horizonalList.widget.m> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aSf;
    }

    public void b(com.baidu.tieba.horizonalList.widget.m mVar) {
        this.mList.add(mVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.m> Fm() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String Kr() {
        return this.aQd;
    }

    public void setYuelaouLocate(String str) {
        this.aQd = str;
    }
}
