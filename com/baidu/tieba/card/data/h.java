package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends a {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    private List<com.baidu.tieba.horizonalList.widget.d> mList = new ArrayList();

    public void a(i iVar) {
        this.mList.add(iVar);
    }

    public List<com.baidu.tieba.horizonalList.widget.d> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
