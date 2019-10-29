package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdTypeListView dvB;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.dvB = bdTypeListView;
        sX();
    }

    private void sX() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.agQ.add(bVar);
        this.agQ.add(fVar);
        this.agQ.add(gVar);
        this.agQ.add(eVar);
        this.agQ.add(hVar);
        this.agQ.add(dVar);
        this.agQ.add(aVar);
        this.dvB.addAdapters(this.agQ);
    }

    public void setData(List<m> list) {
        if (this.dvB != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.dvB.setData(this.mDataList);
        }
    }
}
