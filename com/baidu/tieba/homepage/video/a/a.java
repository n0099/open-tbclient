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
    private f iHg;
    private b iHh;
    private d iHi;
    private e iHj;
    private c iHk;
    private LinkedList<com.baidu.adp.widget.ListView.a> ivz = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.VT = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.iHg = new f(this.mPageContext, k.haj);
        this.iHh = new b(this.mPageContext, l.dRS);
        this.iHi = new d(this.mPageContext, k.har);
        this.iHj = new e(this.mPageContext, k.hap);
        this.iHk = new c(this.mPageContext, k.hak);
        this.iHg.a(this.VT);
        this.iHh.a(this.VT);
        this.iHi.a(this.VT);
        this.iHj.a(this.VT);
        this.iHk.a(this.VT);
        this.ivz.add(this.iHg);
        this.ivz.add(this.iHh);
        this.ivz.add(this.iHi);
        this.ivz.add(this.iHj);
        this.ivz.add(this.iHk);
        this.VT.addAdapters(this.ivz);
    }

    public void notifyDataSetChanged() {
        if (this.VT != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iHg != null) {
            this.iHg.setPageUniqueId(bdUniqueId);
        }
        if (this.iHh != null) {
            this.iHh.setPageUniqueId(bdUniqueId);
        }
        if (this.iHi != null) {
            this.iHi.setPageUniqueId(bdUniqueId);
        }
        if (this.iHj != null) {
            this.iHj.setPageUniqueId(bdUniqueId);
        }
        if (this.iHk != null) {
            this.iHk.setPageUniqueId(bdUniqueId);
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
        if (this.iHj != null) {
            this.iHj.setEventCallback(aVar);
        }
        if (this.iHg != null) {
            this.iHg.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.iHh != null) {
            this.iHh.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.iHh != null) {
            this.iHh.b(eVar);
        }
    }
}
