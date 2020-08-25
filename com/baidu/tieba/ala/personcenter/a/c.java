package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView fCP;
    private com.baidu.tieba.ala.personcenter.d.a gST;
    private i gSU;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.fCP = bdTypeListView;
        this.gST = aVar;
        Jv();
    }

    private void Jv() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.gSU = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.gST);
        j jVar = new j(this.mPageContext);
        this.bbu.add(bVar);
        this.bbu.add(this.gSU);
        this.bbu.add(fVar);
        this.bbu.add(gVar);
        this.bbu.add(eVar);
        this.bbu.add(hVar);
        this.bbu.add(dVar);
        this.bbu.add(aVar);
        this.bbu.add(kVar);
        this.bbu.add(jVar);
        this.fCP.addAdapters(this.bbu);
    }

    public void setData(List<q> list) {
        if (this.fCP != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.fCP.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.gSU != null) {
            this.gSU.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gSU != null) {
            this.gSU.setForumName(str);
        }
    }

    public void kA(boolean z) {
        if (this.gSU != null) {
            this.gSU.kA(z);
        }
    }

    public void GI(String str) {
        if (this.gSU != null) {
            this.gSU.GI(str);
        }
    }
}
