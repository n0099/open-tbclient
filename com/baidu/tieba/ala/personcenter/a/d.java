package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private BdTypeListView gAY;
    private com.baidu.tieba.ala.personcenter.d.a hZj;
    private j hZk;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private List<n> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.gAY = bdTypeListView;
        this.hZj = aVar;
        MT();
    }

    private void MT() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hZk = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hZj);
        k kVar = new k(this.mPageContext);
        this.boM.add(cVar);
        this.boM.add(this.hZk);
        this.boM.add(gVar);
        this.boM.add(hVar);
        this.boM.add(aVar);
        this.boM.add(fVar);
        this.boM.add(iVar);
        this.boM.add(eVar);
        this.boM.add(bVar);
        this.boM.add(lVar);
        this.boM.add(kVar);
        this.gAY.addAdapters(this.boM);
    }

    public void setData(List<n> list) {
        if (this.gAY != null && !x.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.gAY.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hZk != null) {
            this.hZk.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hZk != null) {
            this.hZk.setForumName(str);
        }
    }

    public void mw(boolean z) {
        if (this.hZk != null) {
            this.hZk.mw(z);
        }
    }

    public void IU(String str) {
        if (this.hZk != null) {
            this.hZk.IU(str);
        }
    }
}
