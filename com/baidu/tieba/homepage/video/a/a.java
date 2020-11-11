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
    private f jMp;
    private b jMq;
    private d jMr;
    private e jMs;
    private c jMt;
    private LinkedList<com.baidu.adp.widget.ListView.a> jzU = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xe = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.jMp = new f(this.mPageContext, l.ibz);
        this.jMq = new b(this.mPageContext, m.eDW);
        this.jMr = new d(this.mPageContext, l.ibG);
        this.jMs = new e(this.mPageContext, l.ibE);
        this.jMt = new c(this.mPageContext, l.eDE);
        this.jMp.a(this.Xe);
        this.jMq.a(this.Xe);
        this.jMr.a(this.Xe);
        this.jMs.a(this.Xe);
        this.jMt.a(this.Xe);
        this.jzU.add(this.jMp);
        this.jzU.add(this.jMq);
        this.jzU.add(this.jMr);
        this.jzU.add(this.jMs);
        this.jzU.add(this.jMt);
        this.Xe.addAdapters(this.jzU);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jMp != null) {
            this.jMp.setPageUniqueId(bdUniqueId);
        }
        if (this.jMq != null) {
            this.jMq.setPageUniqueId(bdUniqueId);
        }
        if (this.jMr != null) {
            this.jMr.setPageUniqueId(bdUniqueId);
        }
        if (this.jMs != null) {
            this.jMs.setPageUniqueId(bdUniqueId);
        }
        if (this.jMt != null) {
            this.jMt.setPageUniqueId(bdUniqueId);
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
        if (this.jMs != null) {
            this.jMs.setEventCallback(aVar);
        }
        if (this.jMp != null) {
            this.jMp.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.jMq != null) {
            this.jMq.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.jMq != null) {
            this.jMq.b(eVar);
        }
    }
}
