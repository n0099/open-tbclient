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
    private s iLK;
    private g kgp;
    private k kgq;
    private b kgr;
    private d kgs;
    private c kgt;
    private e kgu;
    private f kgv;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLK = sVar;
        Kw();
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.bns.add(new j(this.mPageContext));
        this.bns.add(new i(this.mPageContext));
        this.bns.add(new LoadingViewAdapter(this.mPageContext));
        this.kgp = new g(this.mPageContext);
        this.kgp.a(this.iLK);
        this.bns.add(this.kgp);
        this.kgq = new k(this.mPageContext);
        this.kgq.a(this.iLK);
        this.bns.add(this.kgq);
        this.kgr = new b(this.mPageContext);
        this.kgr.a(this.iLK);
        this.bns.add(this.kgr);
        this.kgs = new d(this.mPageContext);
        this.kgs.a(this.iLK);
        this.bns.add(this.kgs);
        this.kgt = new c(this.mPageContext);
        this.kgt.a(this.iLK);
        this.bns.add(this.kgt);
        this.kgu = new e(this.mPageContext);
        this.kgu.a(this.iLK);
        this.bns.add(this.kgu);
        this.kgv = new f(this.mPageContext);
        this.kgv.a(this.iLK);
        this.bns.add(this.kgv);
        this.iLK.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        if (this.iLK != null) {
            this.iLK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iLK.setData(list);
    }

    public List<n> getData() {
        return this.iLK.getData();
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
