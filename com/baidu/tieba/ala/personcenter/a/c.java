package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView eOe;
    private com.baidu.tieba.ala.personcenter.d.a fYU;
    private i fYV;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.eOe = bdTypeListView;
        this.fYU = aVar;
        BC();
    }

    private void BC() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.fYV = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.fYU);
        j jVar = new j(this.mPageContext);
        this.aMd.add(bVar);
        this.aMd.add(this.fYV);
        this.aMd.add(fVar);
        this.aMd.add(gVar);
        this.aMd.add(eVar);
        this.aMd.add(hVar);
        this.aMd.add(dVar);
        this.aMd.add(aVar);
        this.aMd.add(kVar);
        this.aMd.add(jVar);
        this.eOe.addAdapters(this.aMd);
    }

    public void setData(List<m> list) {
        if (this.eOe != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.eOe.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.fYV != null) {
            this.fYV.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.fYV != null) {
            this.fYV.setForumName(str);
        }
    }

    public void ld(boolean z) {
        if (this.fYV != null) {
            this.fYV.ld(z);
        }
    }

    public void Bl(String str) {
        if (this.fYV != null) {
            this.fYV.Bl(str);
        }
    }
}
