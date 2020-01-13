package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView efW;
    private com.baidu.tieba.ala.personcenter.d.a frf;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.efW = bdTypeListView;
        this.frf = aVar;
        vi();
    }

    private void vi() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        i iVar = new i(this.mPageContext, this.frf);
        this.apl.add(bVar);
        this.apl.add(fVar);
        this.apl.add(gVar);
        this.apl.add(eVar);
        this.apl.add(hVar);
        this.apl.add(dVar);
        this.apl.add(aVar);
        this.apl.add(iVar);
        this.efW.addAdapters(this.apl);
    }

    public void setData(List<m> list) {
        if (this.efW != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.efW.setData(this.mDataList);
        }
    }
}
