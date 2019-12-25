package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView efM;
    private com.baidu.tieba.ala.personcenter.d.a fnW;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.efM = bdTypeListView;
        this.fnW = aVar;
        uR();
    }

    private void uR() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        i iVar = new i(this.mPageContext, this.fnW);
        this.aoz.add(bVar);
        this.aoz.add(fVar);
        this.aoz.add(gVar);
        this.aoz.add(eVar);
        this.aoz.add(hVar);
        this.aoz.add(dVar);
        this.aoz.add(aVar);
        this.aoz.add(iVar);
        this.efM.addAdapters(this.aoz);
    }

    public void setData(List<m> list) {
        if (this.efM != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.efM.setData(this.mDataList);
        }
    }
}
