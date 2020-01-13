package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ba;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class t extends com.baidu.tieba.card.data.a {
    private List<com.baidu.tieba.horizonalList.widget.c> mList = new ArrayList();

    public void a(ao aoVar) {
        this.mList.add(aoVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.c> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ba.cMt;
    }
}
