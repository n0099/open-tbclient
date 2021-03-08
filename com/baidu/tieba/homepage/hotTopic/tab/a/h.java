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
    private List<com.baidu.adp.widget.ListView.a> boS;
    private s iNH;
    private g kiG;
    private k kiH;
    private b kiI;
    private d kiJ;
    private c kiK;
    private e kiL;
    private f kiM;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iNH = sVar;
        Kz();
    }

    private void Kz() {
        this.boS = new ArrayList();
        this.boS.add(new j(this.mPageContext));
        this.boS.add(new i(this.mPageContext));
        this.boS.add(new LoadingViewAdapter(this.mPageContext));
        this.kiG = new g(this.mPageContext);
        this.kiG.a(this.iNH);
        this.boS.add(this.kiG);
        this.kiH = new k(this.mPageContext);
        this.kiH.a(this.iNH);
        this.boS.add(this.kiH);
        this.kiI = new b(this.mPageContext);
        this.kiI.a(this.iNH);
        this.boS.add(this.kiI);
        this.kiJ = new d(this.mPageContext);
        this.kiJ.a(this.iNH);
        this.boS.add(this.kiJ);
        this.kiK = new c(this.mPageContext);
        this.kiK.a(this.iNH);
        this.boS.add(this.kiK);
        this.kiL = new e(this.mPageContext);
        this.kiL.a(this.iNH);
        this.boS.add(this.kiL);
        this.kiM = new f(this.mPageContext);
        this.kiM.a(this.iNH);
        this.boS.add(this.kiM);
        this.iNH.addAdapters(this.boS);
    }

    public void notifyDataSetChanged() {
        if (this.iNH != null) {
            this.iNH.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iNH.setData(list);
    }

    public List<n> getData() {
        return this.iNH.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
