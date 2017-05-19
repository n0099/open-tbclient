package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId bxj = BdUniqueId.gen();
    private String buk;
    private List<com.baidu.tieba.horizonalList.widget.k> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bxj;
    }

    public void b(com.baidu.tieba.horizonalList.widget.k kVar) {
        this.mList.add(kVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.k> getDataList() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String TE() {
        return this.buk;
    }

    public void setYuelaouLocate(String str) {
        this.buk = str;
    }
}
