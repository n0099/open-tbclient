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
    private List<com.baidu.adp.widget.ListView.a> bhH;
    private v hUo;
    private g jji;
    private l jjj;
    private b jjk;
    private d jjl;
    private c jjm;
    private e jjn;
    private f jjo;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hUo = vVar;
        Le();
    }

    private void Le() {
        this.bhH = new ArrayList();
        this.bhH.add(new j(this.mPageContext));
        this.bhH.add(new k(this.mPageContext));
        this.bhH.add(new i(this.mPageContext));
        this.bhH.add(new w(this.mPageContext));
        this.jji = new g(this.mPageContext);
        this.jji.a(this.hUo);
        this.bhH.add(this.jji);
        this.jjj = new l(this.mPageContext);
        this.jjj.a(this.hUo);
        this.bhH.add(this.jjj);
        this.jjk = new b(this.mPageContext);
        this.jjk.a(this.hUo);
        this.bhH.add(this.jjk);
        this.jjl = new d(this.mPageContext);
        this.jjl.a(this.hUo);
        this.bhH.add(this.jjl);
        this.jjm = new c(this.mPageContext);
        this.jjm.a(this.hUo);
        this.bhH.add(this.jjm);
        this.jjn = new e(this.mPageContext);
        this.jjn.a(this.hUo);
        this.bhH.add(this.jjn);
        this.jjo = new f(this.mPageContext);
        this.jjo.a(this.hUo);
        this.bhH.add(this.jjo);
        this.hUo.addAdapters(this.bhH);
    }

    public void notifyDataSetChanged() {
        if (this.hUo != null) {
            this.hUo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hUo.setData(list);
    }

    public List<q> getData() {
        return this.hUo.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
