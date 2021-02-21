package com.baidu.tieba.homepage.video.a;

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
    private f krF;
    private b krG;
    private d krH;
    private e krI;
    private c krJ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.XW = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.krF = new f(this.mPageContext, k.iBb);
        this.krG = new b(this.mPageContext, l.eQK);
        this.krH = new d(this.mPageContext, k.iBi);
        this.krI = new e(this.mPageContext, k.iBg);
        this.krJ = new c(this.mPageContext, k.eQr);
        this.krF.a(this.XW);
        this.krG.a(this.XW);
        this.krH.a(this.XW);
        this.krI.a(this.XW);
        this.krJ.a(this.XW);
        this.keT.add(this.krF);
        this.keT.add(this.krG);
        this.keT.add(this.krH);
        this.keT.add(this.krI);
        this.keT.add(this.krJ);
        this.XW.addAdapters(this.keT);
    }

    public void notifyDataSetChanged() {
        if (this.XW != null) {
            this.XW.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.krF != null) {
            this.krF.setPageUniqueId(bdUniqueId);
        }
        if (this.krG != null) {
            this.krG.setPageUniqueId(bdUniqueId);
        }
        if (this.krH != null) {
            this.krH.setPageUniqueId(bdUniqueId);
        }
        if (this.krI != null) {
            this.krI.setPageUniqueId(bdUniqueId);
        }
        if (this.krJ != null) {
            this.krJ.setPageUniqueId(bdUniqueId);
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
        if (this.krI != null) {
            this.krI.setEventCallback(aVar);
        }
        if (this.krF != null) {
            this.krF.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.krG != null) {
            this.krG.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.krG != null) {
            this.krG.b(eVar);
        }
    }
}
