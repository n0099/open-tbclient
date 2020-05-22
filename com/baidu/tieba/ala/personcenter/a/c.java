package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView faQ;
    private com.baidu.tieba.ala.personcenter.d.a gnT;
    private i gnU;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private List<o> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.faQ = bdTypeListView;
        this.gnT = aVar;
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
        this.gnU = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.gnT);
        j jVar = new j(this.mPageContext);
        this.aSj.add(bVar);
        this.aSj.add(this.gnU);
        this.aSj.add(fVar);
        this.aSj.add(gVar);
        this.aSj.add(eVar);
        this.aSj.add(hVar);
        this.aSj.add(dVar);
        this.aSj.add(aVar);
        this.aSj.add(kVar);
        this.aSj.add(jVar);
        this.faQ.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        if (this.faQ != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.faQ.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.gnU != null) {
            this.gnU.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gnU != null) {
            this.gnU.setForumName(str);
        }
    }

    public void jl(boolean z) {
        if (this.gnU != null) {
            this.gnU.jl(z);
        }
    }

    public void CX(String str) {
        if (this.gnU != null) {
            this.gnU.CX(str);
        }
    }
}
