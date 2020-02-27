package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends a {
    public static final BdUniqueId fMB = BdUniqueId.gen();
    private String fJa;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fMB;
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

    public String bvw() {
        return this.fJa;
    }

    public void setYuelaouLocate(String str) {
        this.fJa = str;
    }
}
