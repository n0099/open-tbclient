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
    private LinkedList<com.baidu.adp.widget.ListView.a> jOu = new LinkedList<>();
    private f jOv;
    private c jOw;
    private d jOx;
    private e jOy;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Yf = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.jOv = new f(this.mPageContext, k.inp);
        this.jOw = new c(this.mPageContext, l.eJq);
        this.jOx = new d(this.mPageContext, k.inx);
        this.jOy = new e(this.mPageContext, k.inv);
        this.jOv.a(this.Yf);
        this.jOw.a(this.Yf);
        this.jOx.a(this.Yf);
        this.jOy.a(this.Yf);
        this.jOu.add(this.jOv);
        this.jOu.add(this.jOw);
        this.jOu.add(this.jOx);
        this.jOu.add(this.jOy);
        this.Yf.addAdapters(this.jOu);
    }

    public void notifyDataSetChanged() {
        if (this.Yf != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jOv != null) {
            this.jOv.setPageUniqueId(bdUniqueId);
        }
        if (this.jOw != null) {
            this.jOw.setPageUniqueId(bdUniqueId);
        }
        if (this.jOx != null) {
            this.jOx.setPageUniqueId(bdUniqueId);
        }
        if (this.jOy != null) {
            this.jOy.setPageUniqueId(bdUniqueId);
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
        if (this.jOy != null) {
            this.jOy.setEventCallback(aVar);
        }
    }

    public void CQ(int i) {
        if (this.jOv != null) {
            this.jOv.CQ(i);
        }
        if (this.jOw != null) {
            this.jOw.CQ(i);
        }
        if (this.jOx != null) {
            this.jOx.CQ(i);
        }
        if (this.jOy != null) {
            this.jOy.CQ(i);
        }
    }

    public void onPause() {
        if (this.jOw != null) {
            this.jOw.onPause();
        }
    }

    public void onDestroy() {
    }
}
