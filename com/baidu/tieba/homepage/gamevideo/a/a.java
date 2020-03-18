package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private LinkedList<com.baidu.adp.widget.ListView.a> hbO = new LinkedList<>();
    private f hbP;
    private c hbQ;
    private d hbR;
    private e hbS;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wR();
    }

    private void wR() {
        this.hbP = new f(this.mPageContext, k.fNT);
        this.hbQ = new c(this.mPageContext, l.cRN);
        this.hbR = new d(this.mPageContext, k.fOb);
        this.hbS = new e(this.mPageContext, k.fOc);
        this.hbP.b((r) this.BK);
        this.hbQ.b((r) this.BK);
        this.hbR.b((r) this.BK);
        this.hbS.b((r) this.BK);
        this.hbO.add(this.hbP);
        this.hbO.add(this.hbQ);
        this.hbO.add(this.hbR);
        this.hbO.add(this.hbS);
        this.BK.addAdapters(this.hbO);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hbP != null) {
            this.hbP.setPageUniqueId(bdUniqueId);
        }
        if (this.hbQ != null) {
            this.hbQ.setPageUniqueId(bdUniqueId);
        }
        if (this.hbR != null) {
            this.hbR.setPageUniqueId(bdUniqueId);
        }
        if (this.hbS != null) {
            this.hbS.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.BK.setData(list);
    }

    public List<m> getDataList() {
        if (this.BK != null) {
            return this.BK.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hbS != null) {
            this.hbS.setEventCallback(aVar);
        }
    }

    public void vs(int i) {
        if (this.hbP != null) {
            this.hbP.vs(i);
        }
        if (this.hbQ != null) {
            this.hbQ.vs(i);
        }
        if (this.hbR != null) {
            this.hbR.vs(i);
        }
        if (this.hbS != null) {
            this.hbS.vs(i);
        }
    }

    public void onPause() {
        if (this.hbQ != null) {
            this.hbQ.onPause();
        }
    }

    public void onDestroy() {
    }
}
