package com.baidu.tieba.homepage.lowFlows.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private List<com.baidu.adp.widget.ListView.a> boS;
    private s iNH;
    private c kjs;
    private h kjt;
    private b kju;
    private f kjv;
    private e kjw;
    private g kjx;
    private i kjy;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iNH = sVar;
        Kz();
    }

    private void Kz() {
        this.boS = new ArrayList();
        this.kjs = new c(this.mPageContext);
        this.kjs.a(this.iNH);
        this.boS.add(this.kjs);
        this.kjt = new h(this.mPageContext);
        this.kjt.a(this.iNH);
        this.boS.add(this.kjt);
        this.kju = new b(this.mPageContext);
        this.kju.a(this.iNH);
        this.boS.add(this.kju);
        this.kjv = new f(this.mPageContext);
        this.kjv.a(this.iNH);
        this.boS.add(this.kjv);
        this.kjw = new e(this.mPageContext);
        this.kjw.a(this.iNH);
        this.boS.add(this.kjw);
        this.kjx = new g(this.mPageContext);
        this.kjx.a(this.iNH);
        this.boS.add(this.kjx);
        this.kjy = new i(this.mPageContext);
        this.kjy.a(this.iNH);
        this.boS.add(this.kjy);
        this.iNH.addAdapters(this.boS);
    }

    public void notifyDataSetChanged() {
        if (this.iNH != null) {
            this.iNH.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        if (this.iNH != null) {
            this.iNH.setData(list);
            notifyDataSetChanged();
        }
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
