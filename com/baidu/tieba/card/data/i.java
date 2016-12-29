package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends a {
    public static final BdUniqueId bel = BdUniqueId.gen();
    private String bby;
    private List<com.baidu.tieba.horizonalList.widget.l> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bel;
    }

    public void b(com.baidu.tieba.horizonalList.widget.l lVar) {
        this.mList.add(lVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.l> getDataList() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String OX() {
        return this.bby;
    }

    public void setYuelaouLocate(String str) {
        this.bby = str;
    }
}
