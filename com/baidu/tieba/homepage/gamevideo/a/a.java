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
    private LinkedList<com.baidu.adp.widget.ListView.a> jzU = new LinkedList<>();
    private f jzV;
    private c jzW;
    private d jzX;
    private e jzY;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xe = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.jzV = new f(this.mPageContext, l.ibz);
        this.jzW = new c(this.mPageContext, m.eDW);
        this.jzX = new d(this.mPageContext, l.ibG);
        this.jzY = new e(this.mPageContext, l.ibE);
        this.jzV.a(this.Xe);
        this.jzW.a(this.Xe);
        this.jzX.a(this.Xe);
        this.jzY.a(this.Xe);
        this.jzU.add(this.jzV);
        this.jzU.add(this.jzW);
        this.jzU.add(this.jzX);
        this.jzU.add(this.jzY);
        this.Xe.addAdapters(this.jzU);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jzV != null) {
            this.jzV.setPageUniqueId(bdUniqueId);
        }
        if (this.jzW != null) {
            this.jzW.setPageUniqueId(bdUniqueId);
        }
        if (this.jzX != null) {
            this.jzX.setPageUniqueId(bdUniqueId);
        }
        if (this.jzY != null) {
            this.jzY.setPageUniqueId(bdUniqueId);
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
        if (this.jzY != null) {
            this.jzY.setEventCallback(aVar);
        }
    }

    public void BD(int i) {
        if (this.jzV != null) {
            this.jzV.BD(i);
        }
        if (this.jzW != null) {
            this.jzW.BD(i);
        }
        if (this.jzX != null) {
            this.jzX.BD(i);
        }
        if (this.jzY != null) {
            this.jzY.BD(i);
        }
    }

    public void onPause() {
        if (this.jzW != null) {
            this.jzW.onPause();
        }
    }

    public void onDestroy() {
    }
}
