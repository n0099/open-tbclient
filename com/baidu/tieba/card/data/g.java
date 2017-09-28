package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId bNs = BdUniqueId.gen();
    private String bJQ;
    private List<com.baidu.tieba.horizonalList.widget.d> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bNs;
    }

    public void b(com.baidu.tieba.horizonalList.widget.d dVar) {
        this.mList.add(dVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.d> getDataList() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String Yb() {
        return this.bJQ;
    }

    public void setYuelaouLocate(String str) {
        this.bJQ = str;
    }
}
