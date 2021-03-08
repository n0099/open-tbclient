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
    private BdTypeRecyclerView Zq;
    private LinkedList<com.baidu.adp.widget.ListView.a> kgV = new LinkedList<>();
    private f ktH;
    private b ktI;
    private d ktJ;
    private e ktK;
    private c ktL;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Zq = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.ktH = new f(this.mPageContext, k.iCK);
        this.ktI = new b(this.mPageContext, l.eSl);
        this.ktJ = new d(this.mPageContext, k.iCR);
        this.ktK = new e(this.mPageContext, k.iCP);
        this.ktL = new c(this.mPageContext, k.eRS);
        this.ktH.a(this.Zq);
        this.ktI.a(this.Zq);
        this.ktJ.a(this.Zq);
        this.ktK.a(this.Zq);
        this.ktL.a(this.Zq);
        this.kgV.add(this.ktH);
        this.kgV.add(this.ktI);
        this.kgV.add(this.ktJ);
        this.kgV.add(this.ktK);
        this.kgV.add(this.ktL);
        this.Zq.addAdapters(this.kgV);
    }

    public void notifyDataSetChanged() {
        if (this.Zq != null) {
            this.Zq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ktH != null) {
            this.ktH.setPageUniqueId(bdUniqueId);
        }
        if (this.ktI != null) {
            this.ktI.setPageUniqueId(bdUniqueId);
        }
        if (this.ktJ != null) {
            this.ktJ.setPageUniqueId(bdUniqueId);
        }
        if (this.ktK != null) {
            this.ktK.setPageUniqueId(bdUniqueId);
        }
        if (this.ktL != null) {
            this.ktL.setPageUniqueId(bdUniqueId);
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
        if (this.ktK != null) {
            this.ktK.setEventCallback(aVar);
        }
        if (this.ktH != null) {
            this.ktH.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.ktI != null) {
            this.ktI.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.ktI != null) {
            this.ktI.b(eVar);
        }
    }
}
