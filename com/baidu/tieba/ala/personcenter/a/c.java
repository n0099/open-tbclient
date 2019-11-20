package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdTypeListView duK;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.duK = bdTypeListView;
        sY();
    }

    private void sY() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.agy.add(bVar);
        this.agy.add(fVar);
        this.agy.add(gVar);
        this.agy.add(eVar);
        this.agy.add(hVar);
        this.agy.add(dVar);
        this.agy.add(aVar);
        this.duK.addAdapters(this.agy);
    }

    public void setData(List<m> list) {
        if (this.duK != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.duK.setData(this.mDataList);
        }
    }
}
