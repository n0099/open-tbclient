package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView eOj;
    private com.baidu.tieba.ala.personcenter.d.a fYZ;
    private i fZa;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private List<m> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.eOj = bdTypeListView;
        this.fYZ = aVar;
        BB();
    }

    private void BB() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.fZa = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.fYZ);
        j jVar = new j(this.mPageContext);
        this.aMj.add(bVar);
        this.aMj.add(this.fZa);
        this.aMj.add(fVar);
        this.aMj.add(gVar);
        this.aMj.add(eVar);
        this.aMj.add(hVar);
        this.aMj.add(dVar);
        this.aMj.add(aVar);
        this.aMj.add(kVar);
        this.aMj.add(jVar);
        this.eOj.addAdapters(this.aMj);
    }

    public void setData(List<m> list) {
        if (this.eOj != null && !v.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.eOj.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.fZa != null) {
            this.fZa.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.fZa != null) {
            this.fZa.setForumName(str);
        }
    }

    public void ld(boolean z) {
        if (this.fZa != null) {
            this.fZa.ld(z);
        }
    }

    public void Bo(String str) {
        if (this.fZa != null) {
            this.fZa.Bo(str);
        }
    }
}
