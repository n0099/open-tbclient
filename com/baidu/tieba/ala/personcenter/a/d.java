package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private BdTypeListView fSo;
    private com.baidu.tieba.ala.personcenter.d.a hlE;
    private j hlF;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.fSo = bdTypeListView;
        this.hlE = aVar;
        Le();
    }

    private void Le() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hlF = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hlE);
        k kVar = new k(this.mPageContext);
        this.bhH.add(cVar);
        this.bhH.add(this.hlF);
        this.bhH.add(gVar);
        this.bhH.add(hVar);
        this.bhH.add(aVar);
        this.bhH.add(fVar);
        this.bhH.add(iVar);
        this.bhH.add(eVar);
        this.bhH.add(bVar);
        this.bhH.add(lVar);
        this.bhH.add(kVar);
        this.fSo.addAdapters(this.bhH);
    }

    public void setData(List<q> list) {
        if (this.fSo != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.fSo.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hlF != null) {
            this.hlF.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hlF != null) {
            this.hlF.setForumName(str);
        }
    }

    public void lc(boolean z) {
        if (this.hlF != null) {
            this.hlF.lc(z);
        }
    }

    public void HQ(String str) {
        if (this.hlF != null) {
            this.hlF.HQ(str);
        }
    }
}
