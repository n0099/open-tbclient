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
    private LinkedList<com.baidu.adp.widget.ListView.a> hau = new LinkedList<>();
    private f hjb;
    private b hjc;
    private d hjd;
    private e hje;
    private c hjf;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.hjb = new f(this.mPageContext, k.fMY);
        this.hjc = new b(this.mPageContext, l.cRz);
        this.hjd = new d(this.mPageContext, k.fNg);
        this.hje = new e(this.mPageContext, k.fNh);
        this.hjf = new c(this.mPageContext, k.fNf);
        this.hjb.b((r) this.BK);
        this.hjc.b((r) this.BK);
        this.hjd.b((r) this.BK);
        this.hje.b((r) this.BK);
        this.hjf.b((r) this.BK);
        this.hau.add(this.hjb);
        this.hau.add(this.hjc);
        this.hau.add(this.hjd);
        this.hau.add(this.hje);
        this.hau.add(this.hjf);
        this.BK.addAdapters(this.hau);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hjb != null) {
            this.hjb.setPageUniqueId(bdUniqueId);
        }
        if (this.hjc != null) {
            this.hjc.setPageUniqueId(bdUniqueId);
        }
        if (this.hjd != null) {
            this.hjd.setPageUniqueId(bdUniqueId);
        }
        if (this.hje != null) {
            this.hje.setPageUniqueId(bdUniqueId);
        }
        if (this.hjf != null) {
            this.hjf.setPageUniqueId(bdUniqueId);
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
        if (this.hje != null) {
            this.hje.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hjc != null) {
            this.hjc.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hjc != null) {
            this.hjc.b(eVar);
        }
    }
}
