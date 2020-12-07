package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Yf;
    private LinkedList<com.baidu.adp.widget.ListView.a> jOs = new LinkedList<>();
    private f jOt;
    private c jOu;
    private d jOv;
    private e jOw;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Yf = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.jOt = new f(this.mPageContext, k.inn);
        this.jOu = new c(this.mPageContext, l.eJq);
        this.jOv = new d(this.mPageContext, k.inv);
        this.jOw = new e(this.mPageContext, k.f4int);
        this.jOt.a(this.Yf);
        this.jOu.a(this.Yf);
        this.jOv.a(this.Yf);
        this.jOw.a(this.Yf);
        this.jOs.add(this.jOt);
        this.jOs.add(this.jOu);
        this.jOs.add(this.jOv);
        this.jOs.add(this.jOw);
        this.Yf.addAdapters(this.jOs);
    }

    public void notifyDataSetChanged() {
        if (this.Yf != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jOt != null) {
            this.jOt.setPageUniqueId(bdUniqueId);
        }
        if (this.jOu != null) {
            this.jOu.setPageUniqueId(bdUniqueId);
        }
        if (this.jOv != null) {
            this.jOv.setPageUniqueId(bdUniqueId);
        }
        if (this.jOw != null) {
            this.jOw.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Yf.setData(list);
    }

    public List<q> getDataList() {
        if (this.Yf != null) {
            return this.Yf.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jOw != null) {
            this.jOw.setEventCallback(aVar);
        }
    }

    public void CQ(int i) {
        if (this.jOt != null) {
            this.jOt.CQ(i);
        }
        if (this.jOu != null) {
            this.jOu.CQ(i);
        }
        if (this.jOv != null) {
            this.jOv.CQ(i);
        }
        if (this.jOw != null) {
            this.jOw.CQ(i);
        }
    }

    public void onPause() {
        if (this.jOu != null) {
            this.jOu.onPause();
        }
    }

    public void onDestroy() {
    }
}
