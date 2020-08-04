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
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView VT;
    private f iHi;
    private b iHj;
    private d iHk;
    private e iHl;
    private c iHm;
    private LinkedList<com.baidu.adp.widget.ListView.a> ivB = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.VT = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.iHi = new f(this.mPageContext, k.haj);
        this.iHj = new b(this.mPageContext, l.dRS);
        this.iHk = new d(this.mPageContext, k.har);
        this.iHl = new e(this.mPageContext, k.hap);
        this.iHm = new c(this.mPageContext, k.hak);
        this.iHi.a(this.VT);
        this.iHj.a(this.VT);
        this.iHk.a(this.VT);
        this.iHl.a(this.VT);
        this.iHm.a(this.VT);
        this.ivB.add(this.iHi);
        this.ivB.add(this.iHj);
        this.ivB.add(this.iHk);
        this.ivB.add(this.iHl);
        this.ivB.add(this.iHm);
        this.VT.addAdapters(this.ivB);
    }

    public void notifyDataSetChanged() {
        if (this.VT != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iHi != null) {
            this.iHi.setPageUniqueId(bdUniqueId);
        }
        if (this.iHj != null) {
            this.iHj.setPageUniqueId(bdUniqueId);
        }
        if (this.iHk != null) {
            this.iHk.setPageUniqueId(bdUniqueId);
        }
        if (this.iHl != null) {
            this.iHl.setPageUniqueId(bdUniqueId);
        }
        if (this.iHm != null) {
            this.iHm.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.VT.setData(list);
    }

    public List<q> getDataList() {
        if (this.VT != null) {
            return this.VT.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iHl != null) {
            this.iHl.setEventCallback(aVar);
        }
        if (this.iHi != null) {
            this.iHi.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.iHj != null) {
            this.iHj.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.iHj != null) {
            this.iHj.b(eVar);
        }
    }
}
