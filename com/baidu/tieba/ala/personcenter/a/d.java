package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private BdTypeListView gpX;
    private com.baidu.tieba.ala.personcenter.d.a hMK;
    private j hML;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.gpX = bdTypeListView;
        this.hMK = aVar;
        Nt();
    }

    private void Nt() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hML = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hMK);
        k kVar = new k(this.mPageContext);
        this.bnf.add(cVar);
        this.bnf.add(this.hML);
        this.bnf.add(gVar);
        this.bnf.add(hVar);
        this.bnf.add(aVar);
        this.bnf.add(fVar);
        this.bnf.add(iVar);
        this.bnf.add(eVar);
        this.bnf.add(bVar);
        this.bnf.add(lVar);
        this.bnf.add(kVar);
        this.gpX.addAdapters(this.bnf);
    }

    public void setData(List<q> list) {
        if (this.gpX != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.gpX.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hML != null) {
            this.hML.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hML != null) {
            this.hML.setForumName(str);
        }
    }

    public void lZ(boolean z) {
        if (this.hML != null) {
            this.hML.lZ(z);
        }
    }

    public void IW(String str) {
        if (this.hML != null) {
            this.hML.IW(str);
        }
    }
}
