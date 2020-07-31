package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class z extends com.baidu.tieba.card.data.a {
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();

    public void a(az azVar) {
        this.mList.add(azVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.c> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return bk.dQE;
    }
}
