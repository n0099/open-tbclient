package com.baidu.tieba.homepage.video.a;

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
    private LinkedList<com.baidu.adp.widget.ListView.a> haG = new LinkedList<>();
    private f hjn;
    private b hjo;
    private d hjp;
    private e hjq;
    private c hjr;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.hjn = new f(this.mPageContext, k.fNl);
        this.hjo = new b(this.mPageContext, l.cRA);
        this.hjp = new d(this.mPageContext, k.fNt);
        this.hjq = new e(this.mPageContext, k.fNu);
        this.hjr = new c(this.mPageContext, k.fNs);
        this.hjn.b((r) this.BK);
        this.hjo.b((r) this.BK);
        this.hjp.b((r) this.BK);
        this.hjq.b((r) this.BK);
        this.hjr.b((r) this.BK);
        this.haG.add(this.hjn);
        this.haG.add(this.hjo);
        this.haG.add(this.hjp);
        this.haG.add(this.hjq);
        this.haG.add(this.hjr);
        this.BK.addAdapters(this.haG);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hjn != null) {
            this.hjn.setPageUniqueId(bdUniqueId);
        }
        if (this.hjo != null) {
            this.hjo.setPageUniqueId(bdUniqueId);
        }
        if (this.hjp != null) {
            this.hjp.setPageUniqueId(bdUniqueId);
        }
        if (this.hjq != null) {
            this.hjq.setPageUniqueId(bdUniqueId);
        }
        if (this.hjr != null) {
            this.hjr.setPageUniqueId(bdUniqueId);
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
        if (this.hjq != null) {
            this.hjq.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hjo != null) {
            this.hjo.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hjo != null) {
            this.hjo.b(eVar);
        }
    }
}
