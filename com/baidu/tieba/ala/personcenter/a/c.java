package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView fml;
    private com.baidu.tieba.ala.personcenter.d.a gAU;
    private i gAV;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.fml = bdTypeListView;
        this.gAU = aVar;
        Dz();
    }

    private void Dz() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.gAV = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.gAU);
        j jVar = new j(this.mPageContext);
        this.aUP.add(bVar);
        this.aUP.add(this.gAV);
        this.aUP.add(fVar);
        this.aUP.add(gVar);
        this.aUP.add(eVar);
        this.aUP.add(hVar);
        this.aUP.add(dVar);
        this.aUP.add(aVar);
        this.aUP.add(kVar);
        this.aUP.add(jVar);
        this.fml.addAdapters(this.aUP);
    }

    public void setData(List<q> list) {
        if (this.fml != null && !w.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.fml.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.gAV != null) {
            this.gAV.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gAV != null) {
            this.gAV.setForumName(str);
        }
    }

    public void jy(boolean z) {
        if (this.gAV != null) {
            this.gAV.jy(z);
        }
    }

    public void Dy(String str) {
        if (this.gAV != null) {
            this.gAV.Dy(str);
        }
    }
}
