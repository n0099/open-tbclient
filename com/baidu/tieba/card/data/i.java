package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class i extends a {
    public static final BdUniqueId gZP = BdUniqueId.gen();
    private String gWk;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gZP;
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

    public String bSg() {
        return this.gWk;
    }

    public void setYuelaouLocate(String str) {
        this.gWk = str;
    }
}
