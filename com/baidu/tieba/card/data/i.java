package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends a {
    public static final BdUniqueId iAG = BdUniqueId.gen();
    private String iwC;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iAG;
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

    public String cta() {
        return this.iwC;
    }

    public void setYuelaouLocate(String str) {
        this.iwC = str;
    }
}
