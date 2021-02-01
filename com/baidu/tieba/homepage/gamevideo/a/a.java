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
    private LinkedList<com.baidu.adp.widget.ListView.a> keF = new LinkedList<>();
    private f keG;
    private c keH;
    private d keI;
    private e keJ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.XW = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.keG = new f(this.mPageContext, k.iAN);
        this.keH = new c(this.mPageContext, l.eQK);
        this.keI = new d(this.mPageContext, k.iAU);
        this.keJ = new e(this.mPageContext, k.iAS);
        this.keG.a(this.XW);
        this.keH.a(this.XW);
        this.keI.a(this.XW);
        this.keJ.a(this.XW);
        this.keF.add(this.keG);
        this.keF.add(this.keH);
        this.keF.add(this.keI);
        this.keF.add(this.keJ);
        this.XW.addAdapters(this.keF);
    }

    public void notifyDataSetChanged() {
        if (this.XW != null) {
            this.XW.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.keG != null) {
            this.keG.setPageUniqueId(bdUniqueId);
        }
        if (this.keH != null) {
            this.keH.setPageUniqueId(bdUniqueId);
        }
        if (this.keI != null) {
            this.keI.setPageUniqueId(bdUniqueId);
        }
        if (this.keJ != null) {
            this.keJ.setPageUniqueId(bdUniqueId);
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
        if (this.keJ != null) {
            this.keJ.setEventCallback(aVar);
        }
    }

    public void BN(int i) {
        if (this.keG != null) {
            this.keG.BN(i);
        }
        if (this.keH != null) {
            this.keH.BN(i);
        }
        if (this.keI != null) {
            this.keI.BN(i);
        }
        if (this.keJ != null) {
            this.keJ.BN(i);
        }
    }

    public void onPause() {
        if (this.keH != null) {
            this.keH.onPause();
        }
    }

    public void onDestroy() {
    }
}
