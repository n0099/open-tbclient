package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> biN;
    private v inB;
    private l jCA;
    private b jCB;
    private d jCC;
    private c jCD;
    private e jCE;
    private f jCF;
    private g jCz;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.inB = vVar;
        Lp();
    }

    private void Lp() {
        this.biN = new ArrayList();
        this.biN.add(new j(this.mPageContext));
        this.biN.add(new k(this.mPageContext));
        this.biN.add(new i(this.mPageContext));
        this.biN.add(new w(this.mPageContext));
        this.jCz = new g(this.mPageContext);
        this.jCz.a(this.inB);
        this.biN.add(this.jCz);
        this.jCA = new l(this.mPageContext);
        this.jCA.a(this.inB);
        this.biN.add(this.jCA);
        this.jCB = new b(this.mPageContext);
        this.jCB.a(this.inB);
        this.biN.add(this.jCB);
        this.jCC = new d(this.mPageContext);
        this.jCC.a(this.inB);
        this.biN.add(this.jCC);
        this.jCD = new c(this.mPageContext);
        this.jCD.a(this.inB);
        this.biN.add(this.jCD);
        this.jCE = new e(this.mPageContext);
        this.jCE.a(this.inB);
        this.biN.add(this.jCE);
        this.jCF = new f(this.mPageContext);
        this.jCF.a(this.inB);
        this.biN.add(this.jCF);
        this.inB.addAdapters(this.biN);
    }

    public void notifyDataSetChanged() {
        if (this.inB != null) {
            this.inB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.inB.setData(list);
    }

    public List<q> getData() {
        return this.inB.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
