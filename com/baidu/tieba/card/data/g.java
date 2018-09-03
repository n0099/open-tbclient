package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends a {
    public static final BdUniqueId cBU = BdUniqueId.gen();
    private String cyh;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cBU;
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

    public String aju() {
        return this.cyh;
    }

    public void setYuelaouLocate(String str) {
        this.cyh = str;
    }
}
