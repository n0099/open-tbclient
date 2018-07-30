package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends a {
    public static final BdUniqueId cBX = BdUniqueId.gen();
    private String cyk;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cBX;
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

    public String ajr() {
        return this.cyk;
    }

    public void setYuelaouLocate(String str) {
        this.cyk = str;
    }
}
