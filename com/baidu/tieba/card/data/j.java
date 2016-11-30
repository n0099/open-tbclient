package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId beW = BdUniqueId.gen();
    private String bcs;
    private List<com.baidu.tieba.horizonalList.widget.l> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return beW;
    }

    public void b(com.baidu.tieba.horizonalList.widget.l lVar) {
        this.mList.add(lVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.l> Fy() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String PB() {
        return this.bcs;
    }

    public void setYuelaouLocate(String str) {
        this.bcs = str;
    }
}
