package com.baidu.tieba.homepage.gamevideo.a;

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
    private LinkedList<com.baidu.adp.widget.ListView.a> jtX = new LinkedList<>();
    private f jtY;
    private c jtZ;
    private d jua;
    private e jub;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xe = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.jtY = new f(this.mPageContext, l.hVC);
        this.jtZ = new c(this.mPageContext, m.eyg);
        this.jua = new d(this.mPageContext, l.hVJ);
        this.jub = new e(this.mPageContext, l.hVH);
        this.jtY.a(this.Xe);
        this.jtZ.a(this.Xe);
        this.jua.a(this.Xe);
        this.jub.a(this.Xe);
        this.jtX.add(this.jtY);
        this.jtX.add(this.jtZ);
        this.jtX.add(this.jua);
        this.jtX.add(this.jub);
        this.Xe.addAdapters(this.jtX);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jtY != null) {
            this.jtY.setPageUniqueId(bdUniqueId);
        }
        if (this.jtZ != null) {
            this.jtZ.setPageUniqueId(bdUniqueId);
        }
        if (this.jua != null) {
            this.jua.setPageUniqueId(bdUniqueId);
        }
        if (this.jub != null) {
            this.jub.setPageUniqueId(bdUniqueId);
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
        if (this.jub != null) {
            this.jub.setEventCallback(aVar);
        }
    }

    public void Bq(int i) {
        if (this.jtY != null) {
            this.jtY.Bq(i);
        }
        if (this.jtZ != null) {
            this.jtZ.Bq(i);
        }
        if (this.jua != null) {
            this.jua.Bq(i);
        }
        if (this.jub != null) {
            this.jub.Bq(i);
        }
    }

    public void onPause() {
        if (this.jtZ != null) {
            this.jtZ.onPause();
        }
    }

    public void onDestroy() {
    }
}
