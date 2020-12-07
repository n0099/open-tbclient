package com.baidu.tieba.homepage.video.a;

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
    private LinkedList<com.baidu.adp.widget.ListView.a> jOs = new LinkedList<>();
    private f kaC;
    private b kaD;
    private d kaE;
    private e kaF;
    private c kaG;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Yf = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.kaC = new f(this.mPageContext, k.inn);
        this.kaD = new b(this.mPageContext, l.eJq);
        this.kaE = new d(this.mPageContext, k.inv);
        this.kaF = new e(this.mPageContext, k.f4int);
        this.kaG = new c(this.mPageContext, k.eIX);
        this.kaC.a(this.Yf);
        this.kaD.a(this.Yf);
        this.kaE.a(this.Yf);
        this.kaF.a(this.Yf);
        this.kaG.a(this.Yf);
        this.jOs.add(this.kaC);
        this.jOs.add(this.kaD);
        this.jOs.add(this.kaE);
        this.jOs.add(this.kaF);
        this.jOs.add(this.kaG);
        this.Yf.addAdapters(this.jOs);
    }

    public void notifyDataSetChanged() {
        if (this.Yf != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kaC != null) {
            this.kaC.setPageUniqueId(bdUniqueId);
        }
        if (this.kaD != null) {
            this.kaD.setPageUniqueId(bdUniqueId);
        }
        if (this.kaE != null) {
            this.kaE.setPageUniqueId(bdUniqueId);
        }
        if (this.kaF != null) {
            this.kaF.setPageUniqueId(bdUniqueId);
        }
        if (this.kaG != null) {
            this.kaG.setPageUniqueId(bdUniqueId);
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
        if (this.kaF != null) {
            this.kaF.setEventCallback(aVar);
        }
        if (this.kaC != null) {
            this.kaC.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.kaD != null) {
            this.kaD.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.kaD != null) {
            this.kaD.b(eVar);
        }
    }
}
