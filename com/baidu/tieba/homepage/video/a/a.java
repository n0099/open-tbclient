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
    private LinkedList<com.baidu.adp.widget.ListView.a> jOu = new LinkedList<>();
    private f kaE;
    private b kaF;
    private d kaG;
    private e kaH;
    private c kaI;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Yf = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.kaE = new f(this.mPageContext, k.inp);
        this.kaF = new b(this.mPageContext, l.eJq);
        this.kaG = new d(this.mPageContext, k.inx);
        this.kaH = new e(this.mPageContext, k.inv);
        this.kaI = new c(this.mPageContext, k.eIX);
        this.kaE.a(this.Yf);
        this.kaF.a(this.Yf);
        this.kaG.a(this.Yf);
        this.kaH.a(this.Yf);
        this.kaI.a(this.Yf);
        this.jOu.add(this.kaE);
        this.jOu.add(this.kaF);
        this.jOu.add(this.kaG);
        this.jOu.add(this.kaH);
        this.jOu.add(this.kaI);
        this.Yf.addAdapters(this.jOu);
    }

    public void notifyDataSetChanged() {
        if (this.Yf != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kaE != null) {
            this.kaE.setPageUniqueId(bdUniqueId);
        }
        if (this.kaF != null) {
            this.kaF.setPageUniqueId(bdUniqueId);
        }
        if (this.kaG != null) {
            this.kaG.setPageUniqueId(bdUniqueId);
        }
        if (this.kaH != null) {
            this.kaH.setPageUniqueId(bdUniqueId);
        }
        if (this.kaI != null) {
            this.kaI.setPageUniqueId(bdUniqueId);
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
        if (this.kaH != null) {
            this.kaH.setEventCallback(aVar);
        }
        if (this.kaE != null) {
            this.kaE.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.kaF != null) {
            this.kaF.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.kaF != null) {
            this.kaF.b(eVar);
        }
    }
}
