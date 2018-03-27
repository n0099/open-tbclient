package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class u extends com.baidu.tieba.card.data.a {
    private List<com.baidu.tieba.horizonalList.widget.d> mList = new ArrayList();

    public void a(ar arVar) {
        this.mList.add(arVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.d> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return com.baidu.tbadk.core.data.au.aNM;
    }
}
