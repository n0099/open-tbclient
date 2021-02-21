package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private s iLY;
    private g kgD;
    private k kgE;
    private b kgF;
    private d kgG;
    private c kgH;
    private e kgI;
    private f kgJ;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLY = sVar;
        Kw();
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.bns.add(new j(this.mPageContext));
        this.bns.add(new i(this.mPageContext));
        this.bns.add(new LoadingViewAdapter(this.mPageContext));
        this.kgD = new g(this.mPageContext);
        this.kgD.a(this.iLY);
        this.bns.add(this.kgD);
        this.kgE = new k(this.mPageContext);
        this.kgE.a(this.iLY);
        this.bns.add(this.kgE);
        this.kgF = new b(this.mPageContext);
        this.kgF.a(this.iLY);
        this.bns.add(this.kgF);
        this.kgG = new d(this.mPageContext);
        this.kgG.a(this.iLY);
        this.bns.add(this.kgG);
        this.kgH = new c(this.mPageContext);
        this.kgH.a(this.iLY);
        this.bns.add(this.kgH);
        this.kgI = new e(this.mPageContext);
        this.kgI.a(this.iLY);
        this.bns.add(this.kgI);
        this.kgJ = new f(this.mPageContext);
        this.kgJ.a(this.iLY);
        this.bns.add(this.kgJ);
        this.iLY.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        if (this.iLY != null) {
            this.iLY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iLY.setData(list);
    }

    public List<n> getData() {
        return this.iLY.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
