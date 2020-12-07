package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class z extends com.baidu.tieba.card.data.a {
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();

    public void a(bb bbVar) {
        this.mList.add(bbVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.c> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return bn.eHW;
    }
}
