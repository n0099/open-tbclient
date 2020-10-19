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
    private BdTypeRecyclerView Xc;
    private f jhA;
    private c jhB;
    private d jhC;
    private e jhD;
    private LinkedList<com.baidu.adp.widget.ListView.a> jhz = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xc = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.jhA = new f(this.mPageContext, l.hJf);
        this.jhB = new c(this.mPageContext, m.epH);
        this.jhC = new d(this.mPageContext, l.hJm);
        this.jhD = new e(this.mPageContext, l.hJk);
        this.jhA.a(this.Xc);
        this.jhB.a(this.Xc);
        this.jhC.a(this.Xc);
        this.jhD.a(this.Xc);
        this.jhz.add(this.jhA);
        this.jhz.add(this.jhB);
        this.jhz.add(this.jhC);
        this.jhz.add(this.jhD);
        this.Xc.addAdapters(this.jhz);
    }

    public void notifyDataSetChanged() {
        if (this.Xc != null) {
            this.Xc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jhA != null) {
            this.jhA.setPageUniqueId(bdUniqueId);
        }
        if (this.jhB != null) {
            this.jhB.setPageUniqueId(bdUniqueId);
        }
        if (this.jhC != null) {
            this.jhC.setPageUniqueId(bdUniqueId);
        }
        if (this.jhD != null) {
            this.jhD.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Xc.setData(list);
    }

    public List<q> getDataList() {
        if (this.Xc != null) {
            return this.Xc.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jhD != null) {
            this.jhD.setEventCallback(aVar);
        }
    }

    public void AX(int i) {
        if (this.jhA != null) {
            this.jhA.AX(i);
        }
        if (this.jhB != null) {
            this.jhB.AX(i);
        }
        if (this.jhC != null) {
            this.jhC.AX(i);
        }
        if (this.jhD != null) {
            this.jhD.AX(i);
        }
    }

    public void onPause() {
        if (this.jhB != null) {
            this.jhB.onPause();
        }
    }

    public void onDestroy() {
    }
}
