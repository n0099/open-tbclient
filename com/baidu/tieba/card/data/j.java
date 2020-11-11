package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class j extends a {
    public static final BdUniqueId ibd = BdUniqueId.gen();
    private String hXx;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ibd;
    }

    public void b(com.baidu.tieba.horizonalList.widget.c cVar) {
        this.mList.add(cVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.c> getDataList() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String coM() {
        return this.hXx;
    }

    public void setYuelaouLocate(String str) {
        this.hXx = str;
    }
}
