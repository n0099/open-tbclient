package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private BdTypeListView ghN;
    private com.baidu.tieba.ala.personcenter.d.a hDd;
    private j hDe;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.ghN = bdTypeListView;
        this.hDd = aVar;
        Lp();
    }

    private void Lp() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hDe = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hDd);
        k kVar = new k(this.mPageContext);
        this.biN.add(cVar);
        this.biN.add(this.hDe);
        this.biN.add(gVar);
        this.biN.add(hVar);
        this.biN.add(aVar);
        this.biN.add(fVar);
        this.biN.add(iVar);
        this.biN.add(eVar);
        this.biN.add(bVar);
        this.biN.add(lVar);
        this.biN.add(kVar);
        this.ghN.addAdapters(this.biN);
    }

    public void setData(List<q> list) {
        if (this.ghN != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.ghN.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hDe != null) {
            this.hDe.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hDe != null) {
            this.hDe.setForumName(str);
        }
    }

    public void lE(boolean z) {
        if (this.hDe != null) {
            this.hDe.lE(z);
        }
    }

    public void Ih(String str) {
        if (this.hDe != null) {
            this.hDe.Ih(str);
        }
    }
}
