package com.baidu.tieba.homepage.gamevideo.a;

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
    private LinkedList<com.baidu.adp.widget.ListView.a> keT = new LinkedList<>();
    private f keU;
    private c keV;
    private d keW;
    private e keX;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.XW = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.keU = new f(this.mPageContext, k.iBb);
        this.keV = new c(this.mPageContext, l.eQK);
        this.keW = new d(this.mPageContext, k.iBi);
        this.keX = new e(this.mPageContext, k.iBg);
        this.keU.a(this.XW);
        this.keV.a(this.XW);
        this.keW.a(this.XW);
        this.keX.a(this.XW);
        this.keT.add(this.keU);
        this.keT.add(this.keV);
        this.keT.add(this.keW);
        this.keT.add(this.keX);
        this.XW.addAdapters(this.keT);
    }

    public void notifyDataSetChanged() {
        if (this.XW != null) {
            this.XW.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.keU != null) {
            this.keU.setPageUniqueId(bdUniqueId);
        }
        if (this.keV != null) {
            this.keV.setPageUniqueId(bdUniqueId);
        }
        if (this.keW != null) {
            this.keW.setPageUniqueId(bdUniqueId);
        }
        if (this.keX != null) {
            this.keX.setPageUniqueId(bdUniqueId);
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
        if (this.keX != null) {
            this.keX.setEventCallback(aVar);
        }
    }

    public void BN(int i) {
        if (this.keU != null) {
            this.keU.BN(i);
        }
        if (this.keV != null) {
            this.keV.BN(i);
        }
        if (this.keW != null) {
            this.keW.BN(i);
        }
        if (this.keX != null) {
            this.keX.BN(i);
        }
    }

    public void onPause() {
        if (this.keV != null) {
            this.keV.onPause();
        }
    }

    public void onDestroy() {
    }
}
