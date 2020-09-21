package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView fGf;
    private com.baidu.tieba.ala.personcenter.d.a gWF;
    private i gWG;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.fGf = bdTypeListView;
        this.gWF = aVar;
        JZ();
    }

    private void JZ() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.gWG = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.gWF);
        j jVar = new j(this.mPageContext);
        this.bdV.add(bVar);
        this.bdV.add(this.gWG);
        this.bdV.add(fVar);
        this.bdV.add(gVar);
        this.bdV.add(eVar);
        this.bdV.add(hVar);
        this.bdV.add(dVar);
        this.bdV.add(aVar);
        this.bdV.add(kVar);
        this.bdV.add(jVar);
        this.fGf.addAdapters(this.bdV);
    }

    public void setData(List<q> list) {
        if (this.fGf != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.fGf.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.gWG != null) {
            this.gWG.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gWG != null) {
            this.gWG.setForumName(str);
        }
    }

    public void kE(boolean z) {
        if (this.gWG != null) {
            this.gWG.kE(z);
        }
    }

    public void Hc(String str) {
        if (this.gWG != null) {
            this.gWG.Hc(str);
        }
    }
}
