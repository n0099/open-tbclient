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
    private List<com.baidu.adp.widget.ListView.a> boM;
    private s iKI;
    private g kdr;
    private k kds;
    private b kdt;
    private d kdu;
    private c kdv;
    private e kdw;
    private f kdx;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iKI = sVar;
        MT();
    }

    private void MT() {
        this.boM = new ArrayList();
        this.boM.add(new j(this.mPageContext));
        this.boM.add(new i(this.mPageContext));
        this.boM.add(new LoadingViewAdapter(this.mPageContext));
        this.kdr = new g(this.mPageContext);
        this.kdr.a(this.iKI);
        this.boM.add(this.kdr);
        this.kds = new k(this.mPageContext);
        this.kds.a(this.iKI);
        this.boM.add(this.kds);
        this.kdt = new b(this.mPageContext);
        this.kdt.a(this.iKI);
        this.boM.add(this.kdt);
        this.kdu = new d(this.mPageContext);
        this.kdu.a(this.iKI);
        this.boM.add(this.kdu);
        this.kdv = new c(this.mPageContext);
        this.kdv.a(this.iKI);
        this.boM.add(this.kdv);
        this.kdw = new e(this.mPageContext);
        this.kdw.a(this.iKI);
        this.boM.add(this.kdw);
        this.kdx = new f(this.mPageContext);
        this.kdx.a(this.iKI);
        this.boM.add(this.kdx);
        this.iKI.addAdapters(this.boM);
    }

    public void notifyDataSetChanged() {
        if (this.iKI != null) {
            this.iKI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iKI.setData(list);
    }

    public List<n> getData() {
        return this.iKI.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
