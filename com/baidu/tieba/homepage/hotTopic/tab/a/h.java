package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> bbu;
    private v hyl;
    private b iLA;
    private d iLB;
    private c iLC;
    private e iLD;
    private f iLE;
    private g iLy;
    private l iLz;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hyl = vVar;
        Jv();
    }

    private void Jv() {
        this.bbu = new ArrayList();
        this.bbu.add(new j(this.mPageContext));
        this.bbu.add(new k(this.mPageContext));
        this.bbu.add(new i(this.mPageContext));
        this.bbu.add(new w(this.mPageContext));
        this.iLy = new g(this.mPageContext);
        this.iLy.a(this.hyl);
        this.bbu.add(this.iLy);
        this.iLz = new l(this.mPageContext);
        this.iLz.a(this.hyl);
        this.bbu.add(this.iLz);
        this.iLA = new b(this.mPageContext);
        this.iLA.a(this.hyl);
        this.bbu.add(this.iLA);
        this.iLB = new d(this.mPageContext);
        this.iLB.a(this.hyl);
        this.bbu.add(this.iLB);
        this.iLC = new c(this.mPageContext);
        this.iLC.a(this.hyl);
        this.bbu.add(this.iLC);
        this.iLD = new e(this.mPageContext);
        this.iLD.a(this.hyl);
        this.bbu.add(this.iLD);
        this.iLE = new f(this.mPageContext);
        this.iLE.a(this.hyl);
        this.bbu.add(this.iLE);
        this.hyl.addAdapters(this.bbu);
    }

    public void notifyDataSetChanged() {
        if (this.hyl != null) {
            this.hyl.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hyl.setData(list);
    }

    public List<q> getData() {
        return this.hyl.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
