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
    private v iyv;
    private g jQd;
    private l jQe;
    private b jQf;
    private d jQg;
    private c jQh;
    private e jQi;
    private f jQj;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.iyv = vVar;
        Nt();
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.bnf.add(new j(this.mPageContext));
        this.bnf.add(new k(this.mPageContext));
        this.bnf.add(new i(this.mPageContext));
        this.bnf.add(new w(this.mPageContext));
        this.jQd = new g(this.mPageContext);
        this.jQd.a(this.iyv);
        this.bnf.add(this.jQd);
        this.jQe = new l(this.mPageContext);
        this.jQe.a(this.iyv);
        this.bnf.add(this.jQe);
        this.jQf = new b(this.mPageContext);
        this.jQf.a(this.iyv);
        this.bnf.add(this.jQf);
        this.jQg = new d(this.mPageContext);
        this.jQg.a(this.iyv);
        this.bnf.add(this.jQg);
        this.jQh = new c(this.mPageContext);
        this.jQh.a(this.iyv);
        this.bnf.add(this.jQh);
        this.jQi = new e(this.mPageContext);
        this.jQi.a(this.iyv);
        this.bnf.add(this.jQi);
        this.jQj = new f(this.mPageContext);
        this.jQj.a(this.iyv);
        this.bnf.add(this.jQj);
        this.iyv.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        if (this.iyv != null) {
            this.iyv.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.iyv.setData(list);
    }

    public List<q> getData() {
        return this.iyv.getData();
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
