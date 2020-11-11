package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private BdTypeListView gih;
    private com.baidu.tieba.ala.personcenter.d.a hDw;
    private j hDx;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private List<q> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.gih = bdTypeListView;
        this.hDw = aVar;
        LY();
    }

    private void LY() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hDx = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hDw);
        k kVar = new k(this.mPageContext);
        this.bky.add(cVar);
        this.bky.add(this.hDx);
        this.bky.add(gVar);
        this.bky.add(hVar);
        this.bky.add(aVar);
        this.bky.add(fVar);
        this.bky.add(iVar);
        this.bky.add(eVar);
        this.bky.add(bVar);
        this.bky.add(lVar);
        this.bky.add(kVar);
        this.gih.addAdapters(this.bky);
    }

    public void setData(List<q> list) {
        if (this.gih != null && !y.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.gih.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hDx != null) {
            this.hDx.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hDx != null) {
            this.hDx.setForumName(str);
        }
    }

    public void lD(boolean z) {
        if (this.hDx != null) {
            this.hDx.lD(z);
        }
    }

    public void IG(String str) {
        if (this.hDx != null) {
            this.hDx.IG(str);
        }
    }
}
