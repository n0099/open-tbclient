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
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private v iyt;
    private g jQb;
    private l jQc;
    private b jQd;
    private d jQe;
    private c jQf;
    private e jQg;
    private f jQh;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.iyt = vVar;
        Nt();
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.bnf.add(new j(this.mPageContext));
        this.bnf.add(new k(this.mPageContext));
        this.bnf.add(new i(this.mPageContext));
        this.bnf.add(new w(this.mPageContext));
        this.jQb = new g(this.mPageContext);
        this.jQb.a(this.iyt);
        this.bnf.add(this.jQb);
        this.jQc = new l(this.mPageContext);
        this.jQc.a(this.iyt);
        this.bnf.add(this.jQc);
        this.jQd = new b(this.mPageContext);
        this.jQd.a(this.iyt);
        this.bnf.add(this.jQd);
        this.jQe = new d(this.mPageContext);
        this.jQe.a(this.iyt);
        this.bnf.add(this.jQe);
        this.jQf = new c(this.mPageContext);
        this.jQf.a(this.iyt);
        this.bnf.add(this.jQf);
        this.jQg = new e(this.mPageContext);
        this.jQg.a(this.iyt);
        this.bnf.add(this.jQg);
        this.jQh = new f(this.mPageContext);
        this.jQh.a(this.iyt);
        this.bnf.add(this.jQh);
        this.iyt.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        if (this.iyt != null) {
            this.iyt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.iyt.setData(list);
    }

    public List<q> getData() {
        return this.iyt.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
