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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Wa;
    private f iBc;
    private b iBd;
    private d iBe;
    private e iBf;
    private c iBg;
    private LinkedList<com.baidu.adp.widget.ListView.a> ipv = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Wa = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.iBc = new f(this.mPageContext, k.gUF);
        this.iBd = new b(this.mPageContext, l.dLH);
        this.iBe = new d(this.mPageContext, k.gUN);
        this.iBf = new e(this.mPageContext, k.gUL);
        this.iBg = new c(this.mPageContext, k.gUG);
        this.iBc.a(this.Wa);
        this.iBd.a(this.Wa);
        this.iBe.a(this.Wa);
        this.iBf.a(this.Wa);
        this.iBg.a(this.Wa);
        this.ipv.add(this.iBc);
        this.ipv.add(this.iBd);
        this.ipv.add(this.iBe);
        this.ipv.add(this.iBf);
        this.ipv.add(this.iBg);
        this.Wa.addAdapters(this.ipv);
    }

    public void notifyDataSetChanged() {
        if (this.Wa != null) {
            this.Wa.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iBc != null) {
            this.iBc.setPageUniqueId(bdUniqueId);
        }
        if (this.iBd != null) {
            this.iBd.setPageUniqueId(bdUniqueId);
        }
        if (this.iBe != null) {
            this.iBe.setPageUniqueId(bdUniqueId);
        }
        if (this.iBf != null) {
            this.iBf.setPageUniqueId(bdUniqueId);
        }
        if (this.iBg != null) {
            this.iBg.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Wa.setData(list);
    }

    public List<q> getDataList() {
        if (this.Wa != null) {
            return this.Wa.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iBf != null) {
            this.iBf.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.iBd != null) {
            this.iBd.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.iBd != null) {
            this.iBd.b(eVar);
        }
    }
}
