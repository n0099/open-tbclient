package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView frv;
    private com.baidu.tieba.ala.personcenter.d.a gGr;
    private i gGs;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.frv = bdTypeListView;
        this.gGr = aVar;
        DS();
    }

    private void DS() {
        b bVar = new b(this.mPageContext);
        f fVar = new f(this.mPageContext);
        g gVar = new g(this.mPageContext);
        e eVar = new e(this.mPageContext);
        h hVar = new h(this.mPageContext);
        d dVar = new d(this.mPageContext);
        a aVar = new a(this.mPageContext);
        this.gGs = new i(this.mPageContext);
        k kVar = new k(this.mPageContext, this.gGr);
        j jVar = new j(this.mPageContext);
        this.aWf.add(bVar);
        this.aWf.add(this.gGs);
        this.aWf.add(fVar);
        this.aWf.add(gVar);
        this.aWf.add(eVar);
        this.aWf.add(hVar);
        this.aWf.add(dVar);
        this.aWf.add(aVar);
        this.aWf.add(kVar);
        this.aWf.add(jVar);
        this.frv.addAdapters(this.aWf);
    }

    public void setData(List<q> list) {
        if (this.frv != null && !x.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.frv.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.gGs != null) {
            this.gGs.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gGs != null) {
            this.gGs.setForumName(str);
        }
    }

    public void kc(boolean z) {
        if (this.gGs != null) {
            this.gGs.kc(z);
        }
    }

    public void Ej(String str) {
        if (this.gGs != null) {
            this.gGs.Ej(str);
        }
    }
}
