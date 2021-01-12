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
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private s iGb;
    private g jYM;
    private k jYN;
    private b jYO;
    private d jYP;
    private c jYQ;
    private e jYR;
    private f jYS;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iGb = sVar;
        IY();
    }

    private void IY() {
        this.bjZ = new ArrayList();
        this.bjZ.add(new j(this.mPageContext));
        this.bjZ.add(new i(this.mPageContext));
        this.bjZ.add(new LoadingViewAdapter(this.mPageContext));
        this.jYM = new g(this.mPageContext);
        this.jYM.a(this.iGb);
        this.bjZ.add(this.jYM);
        this.jYN = new k(this.mPageContext);
        this.jYN.a(this.iGb);
        this.bjZ.add(this.jYN);
        this.jYO = new b(this.mPageContext);
        this.jYO.a(this.iGb);
        this.bjZ.add(this.jYO);
        this.jYP = new d(this.mPageContext);
        this.jYP.a(this.iGb);
        this.bjZ.add(this.jYP);
        this.jYQ = new c(this.mPageContext);
        this.jYQ.a(this.iGb);
        this.bjZ.add(this.jYQ);
        this.jYR = new e(this.mPageContext);
        this.jYR.a(this.iGb);
        this.bjZ.add(this.jYR);
        this.jYS = new f(this.mPageContext);
        this.jYS.a(this.iGb);
        this.bjZ.add(this.jYS);
        this.iGb.addAdapters(this.bjZ);
    }

    public void notifyDataSetChanged() {
        if (this.iGb != null) {
            this.iGb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iGb.setData(list);
    }

    public List<n> getData() {
        return this.iGb.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
