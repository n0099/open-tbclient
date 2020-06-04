package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends a {
    public static final BdUniqueId gHl = BdUniqueId.gen();
    private String gDO;
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gHl;
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

    public String bLK() {
        return this.gDO;
    }

    public void setYuelaouLocate(String str) {
        this.gDO = str;
    }
}
