package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView XW;
    private LinkedList<com.baidu.adp.widget.ListView.a> keF = new LinkedList<>();
    private f krr;
    private b krs;
    private d krt;
    private e kru;
    private c krv;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.XW = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.krr = new f(this.mPageContext, k.iAN);
        this.krs = new b(this.mPageContext, l.eQK);
        this.krt = new d(this.mPageContext, k.iAU);
        this.kru = new e(this.mPageContext, k.iAS);
        this.krv = new c(this.mPageContext, k.eQr);
        this.krr.a(this.XW);
        this.krs.a(this.XW);
        this.krt.a(this.XW);
        this.kru.a(this.XW);
        this.krv.a(this.XW);
        this.keF.add(this.krr);
        this.keF.add(this.krs);
        this.keF.add(this.krt);
        this.keF.add(this.kru);
        this.keF.add(this.krv);
        this.XW.addAdapters(this.keF);
    }

    public void notifyDataSetChanged() {
        if (this.XW != null) {
            this.XW.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.krr != null) {
            this.krr.setPageUniqueId(bdUniqueId);
        }
        if (this.krs != null) {
            this.krs.setPageUniqueId(bdUniqueId);
        }
        if (this.krt != null) {
            this.krt.setPageUniqueId(bdUniqueId);
        }
        if (this.kru != null) {
            this.kru.setPageUniqueId(bdUniqueId);
        }
        if (this.krv != null) {
            this.krv.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<n> list) {
        this.XW.setData(list);
    }

    public List<n> getDataList() {
        if (this.XW != null) {
            return this.XW.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kru != null) {
            this.kru.setEventCallback(aVar);
        }
        if (this.krr != null) {
            this.krr.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.krs != null) {
            this.krs.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.krs != null) {
            this.krs.b(eVar);
        }
    }
}
