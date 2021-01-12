package com.baidu.tieba.ala.personcenter.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private BdTypeListView gwr;
    private com.baidu.tieba.ala.personcenter.d.a hUC;
    private j hUD;
    private TbPageContext mPageContext;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private List<n> mDataList = new ArrayList();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, com.baidu.tieba.ala.personcenter.d.a aVar) {
        this.mPageContext = tbPageContext;
        this.gwr = bdTypeListView;
        this.hUC = aVar;
        IY();
    }

    private void IY() {
        c cVar = new c(this.mPageContext);
        g gVar = new g(this.mPageContext);
        h hVar = new h(this.mPageContext);
        a aVar = new a(this.mPageContext);
        f fVar = new f(this.mPageContext);
        i iVar = new i(this.mPageContext);
        e eVar = new e(this.mPageContext);
        b bVar = new b(this.mPageContext);
        this.hUD = new j(this.mPageContext);
        l lVar = new l(this.mPageContext, this.hUC);
        k kVar = new k(this.mPageContext);
        this.bjZ.add(cVar);
        this.bjZ.add(this.hUD);
        this.bjZ.add(gVar);
        this.bjZ.add(hVar);
        this.bjZ.add(aVar);
        this.bjZ.add(fVar);
        this.bjZ.add(iVar);
        this.bjZ.add(eVar);
        this.bjZ.add(bVar);
        this.bjZ.add(lVar);
        this.bjZ.add(kVar);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setData(List<n> list) {
        if (this.gwr != null && !x.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.gwr.setData(this.mDataList);
        }
    }

    public void setForumId(String str) {
        if (this.hUD != null) {
            this.hUD.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hUD != null) {
            this.hUD.setForumName(str);
        }
    }

    public void ms(boolean z) {
        if (this.hUD != null) {
            this.hUD.ms(z);
        }
    }

    public void HI(String str) {
        if (this.hUD != null) {
            this.hUD.HI(str);
        }
    }
}
