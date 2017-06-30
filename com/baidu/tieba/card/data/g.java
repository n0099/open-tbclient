package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId bDY = BdUniqueId.gen();
    private String bAR;
    private List<com.baidu.tieba.horizonalList.widget.k> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bDY;
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

    public String VZ() {
        return this.bAR;
    }

    public void setYuelaouLocate(String str) {
        this.bAR = str;
    }
}
