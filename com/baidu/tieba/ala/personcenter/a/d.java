package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private BdTypeListView gcr;
    private j hxA;
    private com.baidu.tieba.ala.personcenter.d.a hxz;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.gcr = bdTypeListView;
        this.hxz = aVar;
        Ly();
    }

    private void Ly() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hxA = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hxz);
        k kVar = new k(this.mPageContext);
        this.bje.add(cVar);
        this.bje.add(this.hxA);
        this.bje.add(gVar);
        this.bje.add(hVar);
        this.bje.add(aVar);
        this.bje.add(fVar);
        this.bje.add(iVar);
        this.bje.add(eVar);
        this.bje.add(bVar);
        this.bje.add(lVar);
        this.bje.add(kVar);
        this.gcr.addAdapters(this.bje);
    }

    public void setData(List<q> list) {
        if (this.gcr != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.gcr.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hxA != null) {
            this.hxA.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hxA != null) {
            this.hxA.setForumName(str);
        }
    }

    public void lu(boolean z) {
        if (this.hxA != null) {
            this.hxA.lu(z);
        }
    }

    public void Ip(String str) {
        if (this.hxA != null) {
            this.hxA.Ip(str);
        }
    }
}
