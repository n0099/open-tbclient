package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.au;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class q extends com.baidu.tieba.card.data.a {
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();

    public void a(an anVar) {
        this.mList.add(anVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.c> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return au.Zj;
    }
}
