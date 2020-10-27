package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private f jGr;
    private b jGs;
    private d jGt;
    private e jGu;
    private c jGv;
    private LinkedList<com.baidu.adp.widget.ListView.a> jtX = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xe = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.jGr = new f(this.mPageContext, l.hVC);
        this.jGs = new b(this.mPageContext, m.eyg);
        this.jGt = new d(this.mPageContext, l.hVJ);
        this.jGu = new e(this.mPageContext, l.hVH);
        this.jGv = new c(this.mPageContext, l.exN);
        this.jGr.a(this.Xe);
        this.jGs.a(this.Xe);
        this.jGt.a(this.Xe);
        this.jGu.a(this.Xe);
        this.jGv.a(this.Xe);
        this.jtX.add(this.jGr);
        this.jtX.add(this.jGs);
        this.jtX.add(this.jGt);
        this.jtX.add(this.jGu);
        this.jtX.add(this.jGv);
        this.Xe.addAdapters(this.jtX);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jGr != null) {
            this.jGr.setPageUniqueId(bdUniqueId);
        }
        if (this.jGs != null) {
            this.jGs.setPageUniqueId(bdUniqueId);
        }
        if (this.jGt != null) {
            this.jGt.setPageUniqueId(bdUniqueId);
        }
        if (this.jGu != null) {
            this.jGu.setPageUniqueId(bdUniqueId);
        }
        if (this.jGv != null) {
            this.jGv.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Xe.setData(list);
    }

    public List<q> getDataList() {
        if (this.Xe != null) {
            return this.Xe.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jGu != null) {
            this.jGu.setEventCallback(aVar);
        }
        if (this.jGr != null) {
            this.jGr.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.jGs != null) {
            this.jGs.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.jGs != null) {
            this.jGs.b(eVar);
        }
    }
}
