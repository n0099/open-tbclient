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
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private v hFt;
    private g iUk;
    private l iUl;
    private b iUm;
    private d iUn;
    private c iUo;
    private e iUp;
    private f iUq;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hFt = vVar;
        JZ();
    }

    private void JZ() {
        this.bdV = new ArrayList();
        this.bdV.add(new j(this.mPageContext));
        this.bdV.add(new k(this.mPageContext));
        this.bdV.add(new i(this.mPageContext));
        this.bdV.add(new w(this.mPageContext));
        this.iUk = new g(this.mPageContext);
        this.iUk.a(this.hFt);
        this.bdV.add(this.iUk);
        this.iUl = new l(this.mPageContext);
        this.iUl.a(this.hFt);
        this.bdV.add(this.iUl);
        this.iUm = new b(this.mPageContext);
        this.iUm.a(this.hFt);
        this.bdV.add(this.iUm);
        this.iUn = new d(this.mPageContext);
        this.iUn.a(this.hFt);
        this.bdV.add(this.iUn);
        this.iUo = new c(this.mPageContext);
        this.iUo.a(this.hFt);
        this.bdV.add(this.iUo);
        this.iUp = new e(this.mPageContext);
        this.iUp.a(this.hFt);
        this.bdV.add(this.iUp);
        this.iUq = new f(this.mPageContext);
        this.iUq.a(this.hFt);
        this.bdV.add(this.iUq);
        this.hFt.addAdapters(this.bdV);
    }

    public void notifyDataSetChanged() {
        if (this.hFt != null) {
            this.hFt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hFt.setData(list);
    }

    public List<q> getData() {
        return this.hFt.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
