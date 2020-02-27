package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView eka;
    private com.baidu.tieba.ala.personcenter.d.a ftI;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.eka = bdTypeListView;
        this.ftI = aVar;
        wM();
    }

    private void wM() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        i iVar = new i(this.mPageContext, this.ftI);
        this.asE.add(bVar);
        this.asE.add(fVar);
        this.asE.add(gVar);
        this.asE.add(eVar);
        this.asE.add(hVar);
        this.asE.add(dVar);
        this.asE.add(aVar);
        this.asE.add(iVar);
        this.eka.addAdapters(this.asE);
    }

    public void setData(List<m> list) {
        if (this.eka != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.eka.setData(this.mDataList);
        }
    }
}
