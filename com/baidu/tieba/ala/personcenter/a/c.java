package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView eko;
    private com.baidu.tieba.ala.personcenter.d.a ftW;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.eko = bdTypeListView;
        this.ftW = aVar;
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
        i iVar = new i(this.mPageContext, this.ftW);
        this.asF.add(bVar);
        this.asF.add(fVar);
        this.asF.add(gVar);
        this.asF.add(eVar);
        this.asF.add(hVar);
        this.asF.add(dVar);
        this.asF.add(aVar);
        this.asF.add(iVar);
        this.eko.addAdapters(this.asF);
    }

    public void setData(List<m> list) {
        if (this.eko != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.eko.setData(this.mDataList);
        }
    }
}
