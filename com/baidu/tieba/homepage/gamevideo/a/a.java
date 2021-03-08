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
    private BdTypeRecyclerView Zq;
    private LinkedList<com.baidu.adp.widget.ListView.a> kgV = new LinkedList<>();
    private f kgW;
    private c kgX;
    private d kgY;
    private e kgZ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Zq = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.kgW = new f(this.mPageContext, k.iCK);
        this.kgX = new c(this.mPageContext, l.eSl);
        this.kgY = new d(this.mPageContext, k.iCR);
        this.kgZ = new e(this.mPageContext, k.iCP);
        this.kgW.a(this.Zq);
        this.kgX.a(this.Zq);
        this.kgY.a(this.Zq);
        this.kgZ.a(this.Zq);
        this.kgV.add(this.kgW);
        this.kgV.add(this.kgX);
        this.kgV.add(this.kgY);
        this.kgV.add(this.kgZ);
        this.Zq.addAdapters(this.kgV);
    }

    public void notifyDataSetChanged() {
        if (this.Zq != null) {
            this.Zq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kgW != null) {
            this.kgW.setPageUniqueId(bdUniqueId);
        }
        if (this.kgX != null) {
            this.kgX.setPageUniqueId(bdUniqueId);
        }
        if (this.kgY != null) {
            this.kgY.setPageUniqueId(bdUniqueId);
        }
        if (this.kgZ != null) {
            this.kgZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<n> list) {
        this.Zq.setData(list);
    }

    public List<n> getDataList() {
        if (this.Zq != null) {
            return this.Zq.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kgZ != null) {
            this.kgZ.setEventCallback(aVar);
        }
    }

    public void BQ(int i) {
        if (this.kgW != null) {
            this.kgW.BQ(i);
        }
        if (this.kgX != null) {
            this.kgX.BQ(i);
        }
        if (this.kgY != null) {
            this.kgY.BQ(i);
        }
        if (this.kgZ != null) {
            this.kgZ.BQ(i);
        }
    }

    public void onPause() {
        if (this.kgX != null) {
            this.kgX.onPause();
        }
    }

    public void onDestroy() {
    }
}
