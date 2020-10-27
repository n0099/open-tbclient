package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> bje;
    private v igO;
    private g jvF;
    private l jvG;
    private b jvH;
    private d jvI;
    private c jvJ;
    private e jvK;
    private f jvL;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.igO = vVar;
        Ly();
    }

    private void Ly() {
        this.bje = new ArrayList();
        this.bje.add(new j(this.mPageContext));
        this.bje.add(new k(this.mPageContext));
        this.bje.add(new i(this.mPageContext));
        this.bje.add(new w(this.mPageContext));
        this.jvF = new g(this.mPageContext);
        this.jvF.a(this.igO);
        this.bje.add(this.jvF);
        this.jvG = new l(this.mPageContext);
        this.jvG.a(this.igO);
        this.bje.add(this.jvG);
        this.jvH = new b(this.mPageContext);
        this.jvH.a(this.igO);
        this.bje.add(this.jvH);
        this.jvI = new d(this.mPageContext);
        this.jvI.a(this.igO);
        this.bje.add(this.jvI);
        this.jvJ = new c(this.mPageContext);
        this.jvJ.a(this.igO);
        this.bje.add(this.jvJ);
        this.jvK = new e(this.mPageContext);
        this.jvK.a(this.igO);
        this.bje.add(this.jvK);
        this.jvL = new f(this.mPageContext);
        this.jvL.a(this.igO);
        this.bje.add(this.jvL);
        this.igO.addAdapters(this.bje);
    }

    public void notifyDataSetChanged() {
        if (this.igO != null) {
            this.igO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.igO.setData(list);
    }

    public List<q> getData() {
        return this.igO.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
