package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView fbb;
    private com.baidu.tieba.ala.personcenter.d.a goe;
    private i gof;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private List<o> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.fbb = bdTypeListView;
        this.goe = aVar;
        CY();
    }

    private void CY() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.gof = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.goe);
        j jVar = new j(this.mPageContext);
        this.aSj.add(bVar);
        this.aSj.add(this.gof);
        this.aSj.add(fVar);
        this.aSj.add(gVar);
        this.aSj.add(eVar);
        this.aSj.add(hVar);
        this.aSj.add(dVar);
        this.aSj.add(aVar);
        this.aSj.add(kVar);
        this.aSj.add(jVar);
        this.fbb.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        if (this.fbb != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.fbb.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.gof != null) {
            this.gof.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gof != null) {
            this.gof.setForumName(str);
        }
    }

    public void jl(boolean z) {
        if (this.gof != null) {
            this.gof.jl(z);
        }
    }

    public void CX(String str) {
        if (this.gof != null) {
            this.gof.CX(str);
        }
    }
}
