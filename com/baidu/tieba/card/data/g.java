package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends a {
    public static final BdUniqueId ePf = BdUniqueId.gen();
    private String eLv;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ePf;
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

    public String baM() {
        return this.eLv;
    }

    public void setYuelaouLocate(String str) {
        this.eLv = str;
    }
}
