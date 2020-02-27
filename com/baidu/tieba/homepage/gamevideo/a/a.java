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
    private LinkedList<com.baidu.adp.widget.ListView.a> has = new LinkedList<>();
    private f hat;
    private c hau;
    private d hav;
    private e haw;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.hat = new f(this.mPageContext, k.fMW);
        this.hau = new c(this.mPageContext, l.cRy);
        this.hav = new d(this.mPageContext, k.fNe);
        this.haw = new e(this.mPageContext, k.fNf);
        this.hat.b((r) this.BK);
        this.hau.b((r) this.BK);
        this.hav.b((r) this.BK);
        this.haw.b((r) this.BK);
        this.has.add(this.hat);
        this.has.add(this.hau);
        this.has.add(this.hav);
        this.has.add(this.haw);
        this.BK.addAdapters(this.has);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hat != null) {
            this.hat.setPageUniqueId(bdUniqueId);
        }
        if (this.hau != null) {
            this.hau.setPageUniqueId(bdUniqueId);
        }
        if (this.hav != null) {
            this.hav.setPageUniqueId(bdUniqueId);
        }
        if (this.haw != null) {
            this.haw.setPageUniqueId(bdUniqueId);
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
        if (this.haw != null) {
            this.haw.setEventCallback(aVar);
        }
    }

    public void vl(int i) {
        if (this.hat != null) {
            this.hat.vl(i);
        }
        if (this.hau != null) {
            this.hau.vl(i);
        }
        if (this.hav != null) {
            this.hav.vl(i);
        }
        if (this.haw != null) {
            this.haw.vl(i);
        }
    }

    public void onPause() {
        if (this.hau != null) {
            this.hau.onPause();
        }
    }

    public void onDestroy() {
    }
}
