package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private BdTypeListView gAY;
    private com.baidu.tieba.ala.personcenter.d.a iaU;
    private j iaV;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private List<n> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.gAY = bdTypeListView;
        this.iaU = aVar;
        Kz();
    }

    private void Kz() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.iaV = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.iaU);
        k kVar = new k(this.mPageContext);
        this.boS.add(cVar);
        this.boS.add(this.iaV);
        this.boS.add(gVar);
        this.boS.add(hVar);
        this.boS.add(aVar);
        this.boS.add(fVar);
        this.boS.add(iVar);
        this.boS.add(eVar);
        this.boS.add(bVar);
        this.boS.add(lVar);
        this.boS.add(kVar);
        this.gAY.addAdapters(this.boS);
    }

    public void setData(List<n> list) {
        if (this.gAY != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.gAY.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.iaV != null) {
            this.iaV.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.iaV != null) {
            this.iaV.setForumName(str);
        }
    }

    public void mw(boolean z) {
        if (this.iaV != null) {
            this.iaV.mw(z);
        }
    }

    public void Iw(String str) {
        if (this.iaV != null) {
            this.iaV.Iw(str);
        }
    }
}
