package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId cXk = BdUniqueId.gen();
    private String cTe;
    private List<com.baidu.tieba.horizonalList.widget.d> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return cXk;
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

    public String akZ() {
        return this.cTe;
    }

    public void setYuelaouLocate(String str) {
        this.cTe = str;
    }
}
