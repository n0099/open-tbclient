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
    private s iLY;
    private c khp;
    private h khq;
    private b khr;
    private f khs;
    private e kht;
    private g khu;
    private i khv;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLY = sVar;
        Kw();
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.khp = new c(this.mPageContext);
        this.khp.a(this.iLY);
        this.bns.add(this.khp);
        this.khq = new h(this.mPageContext);
        this.khq.a(this.iLY);
        this.bns.add(this.khq);
        this.khr = new b(this.mPageContext);
        this.khr.a(this.iLY);
        this.bns.add(this.khr);
        this.khs = new f(this.mPageContext);
        this.khs.a(this.iLY);
        this.bns.add(this.khs);
        this.kht = new e(this.mPageContext);
        this.kht.a(this.iLY);
        this.bns.add(this.kht);
        this.khu = new g(this.mPageContext);
        this.khu.a(this.iLY);
        this.bns.add(this.khu);
        this.khv = new i(this.mPageContext);
        this.khv.a(this.iLY);
        this.bns.add(this.khv);
        this.iLY.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        if (this.iLY != null) {
            this.iLY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        if (this.iLY != null) {
            this.iLY.setData(list);
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
