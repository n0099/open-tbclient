package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends a {
    public static final BdUniqueId aVO = BdUniqueId.gen();
    private String aSY;
    private List<com.baidu.tieba.horizonalList.widget.l> mList = new ArrayList();
    private String stType;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aVO;
    }

    public void b(com.baidu.tieba.horizonalList.widget.l lVar) {
        this.mList.add(lVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.l> FZ() {
        return this.mList;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String LL() {
        return this.aSY;
    }

    public void setYuelaouLocate(String str) {
        this.aSY = str;
    }
}
