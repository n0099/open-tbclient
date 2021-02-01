package com.baidu.tieba.homepage.lowFlows.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private s iLK;
    private c khb;
    private h khc;
    private b khd;
    private f khe;
    private e khf;
    private g khg;
    private i khh;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLK = sVar;
        Kw();
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.khb = new c(this.mPageContext);
        this.khb.a(this.iLK);
        this.bns.add(this.khb);
        this.khc = new h(this.mPageContext);
        this.khc.a(this.iLK);
        this.bns.add(this.khc);
        this.khd = new b(this.mPageContext);
        this.khd.a(this.iLK);
        this.bns.add(this.khd);
        this.khe = new f(this.mPageContext);
        this.khe.a(this.iLK);
        this.bns.add(this.khe);
        this.khf = new e(this.mPageContext);
        this.khf.a(this.iLK);
        this.bns.add(this.khf);
        this.khg = new g(this.mPageContext);
        this.khg.a(this.iLK);
        this.bns.add(this.khg);
        this.khh = new i(this.mPageContext);
        this.khh.a(this.iLK);
        this.bns.add(this.khh);
        this.iLK.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        if (this.iLK != null) {
            this.iLK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        if (this.iLK != null) {
            this.iLK.setData(list);
            notifyDataSetChanged();
        }
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
