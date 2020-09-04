package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView fCT;
    private com.baidu.tieba.ala.personcenter.d.a gSX;
    private i gSY;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.fCT = bdTypeListView;
        this.gSX = aVar;
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
        this.gSY = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.gSX);
        j jVar = new j(this.mPageContext);
        this.bbw.add(bVar);
        this.bbw.add(this.gSY);
        this.bbw.add(fVar);
        this.bbw.add(gVar);
        this.bbw.add(eVar);
        this.bbw.add(hVar);
        this.bbw.add(dVar);
        this.bbw.add(aVar);
        this.bbw.add(kVar);
        this.bbw.add(jVar);
        this.fCT.addAdapters(this.bbw);
    }

    public void setData(List<q> list) {
        if (this.fCT != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.fCT.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.gSY != null) {
            this.gSY.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gSY != null) {
            this.gSY.setForumName(str);
        }
    }

    public void kC(boolean z) {
        if (this.gSY != null) {
            this.gSY.kC(z);
        }
    }

    public void GJ(String str) {
        if (this.gSY != null) {
            this.gSY.GJ(str);
        }
    }
}
