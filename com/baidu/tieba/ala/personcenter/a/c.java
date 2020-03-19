package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView ekE;
    private com.baidu.tieba.ala.personcenter.d.a fuw;
    private i fux;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.ekE = bdTypeListView;
        this.fuw = aVar;
        wR();
    }

    private void wR() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.fux = new i(this.mPageContext);
        j jVar = new j(this.mPageContext, this.fuw);
        this.asP.add(bVar);
        this.asP.add(this.fux);
        this.asP.add(fVar);
        this.asP.add(gVar);
        this.asP.add(eVar);
        this.asP.add(hVar);
        this.asP.add(dVar);
        this.asP.add(aVar);
        this.asP.add(jVar);
        this.ekE.addAdapters(this.asP);
    }

    public void setData(List<m> list) {
        if (this.ekE != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.ekE.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.fux != null) {
            this.fux.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.fux != null) {
            this.fux.setForumName(str);
        }
    }

    public void jZ(boolean z) {
        if (this.fux != null) {
            this.fux.jZ(z);
        }
    }

    public void zG(String str) {
        if (this.fux != null) {
            this.fux.zG(str);
        }
    }
}
