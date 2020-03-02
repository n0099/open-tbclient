package com.baidu.tieba.homepage.gamevideo.a;

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
    private f hav;
    private c haw;
    private d hax;
    private e hay;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.hav = new f(this.mPageContext, k.fMY);
        this.haw = new c(this.mPageContext, l.cRz);
        this.hax = new d(this.mPageContext, k.fNg);
        this.hay = new e(this.mPageContext, k.fNh);
        this.hav.b((r) this.BK);
        this.haw.b((r) this.BK);
        this.hax.b((r) this.BK);
        this.hay.b((r) this.BK);
        this.hau.add(this.hav);
        this.hau.add(this.haw);
        this.hau.add(this.hax);
        this.hau.add(this.hay);
        this.BK.addAdapters(this.hau);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hav != null) {
            this.hav.setPageUniqueId(bdUniqueId);
        }
        if (this.haw != null) {
            this.haw.setPageUniqueId(bdUniqueId);
        }
        if (this.hax != null) {
            this.hax.setPageUniqueId(bdUniqueId);
        }
        if (this.hay != null) {
            this.hay.setPageUniqueId(bdUniqueId);
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
        if (this.hay != null) {
            this.hay.setEventCallback(aVar);
        }
    }

    public void vl(int i) {
        if (this.hav != null) {
            this.hav.vl(i);
        }
        if (this.haw != null) {
            this.haw.vl(i);
        }
        if (this.hax != null) {
            this.hax.vl(i);
        }
        if (this.hay != null) {
            this.hay.vl(i);
        }
    }

    public void onPause() {
        if (this.haw != null) {
            this.haw.onPause();
        }
    }

    public void onDestroy() {
    }
}
