package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId bUK = BdUniqueId.gen();
    private String bRk;
    private List<com.baidu.tieba.horizonalList.widget.d> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bUK;
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

    public String aah() {
        return this.bRk;
    }

    public void setYuelaouLocate(String str) {
        this.bRk = str;
    }
}
