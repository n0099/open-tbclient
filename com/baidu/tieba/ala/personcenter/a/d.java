package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private BdTypeListView gzb;
    private com.baidu.tieba.ala.personcenter.d.a hYX;
    private j hYY;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private List<n> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.gzb = bdTypeListView;
        this.hYX = aVar;
        Kw();
    }

    private void Kw() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hYY = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hYX);
        k kVar = new k(this.mPageContext);
        this.bns.add(cVar);
        this.bns.add(this.hYY);
        this.bns.add(gVar);
        this.bns.add(hVar);
        this.bns.add(aVar);
        this.bns.add(fVar);
        this.bns.add(iVar);
        this.bns.add(eVar);
        this.bns.add(bVar);
        this.bns.add(lVar);
        this.bns.add(kVar);
        this.gzb.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        if (this.gzb != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.gzb.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hYY != null) {
            this.hYY.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hYY != null) {
            this.hYY.setForumName(str);
        }
    }

    public void mw(boolean z) {
        if (this.hYY != null) {
            this.hYY.mw(z);
        }
    }

    public void Im(String str) {
        if (this.hYY != null) {
            this.hYY.Im(str);
        }
    }
}
