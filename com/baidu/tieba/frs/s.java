package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ax;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class s extends com.baidu.tieba.card.data.a {
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();

    public void a(an anVar) {
        this.mList.add(anVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.c> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ax.bHz;
    }
}
