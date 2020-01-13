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
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private LinkedList<com.baidu.adp.widget.ListView.a> gYs = new LinkedList<>();
    private f hgY;
    private b hgZ;
    private d hha;
    private e hhb;
    private c hhc;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Bs = bdTypeRecyclerView;
        vi();
    }

    private void vi() {
        this.hgY = new f(this.mPageContext, k.fKA);
        this.hgZ = new b(this.mPageContext, l.cNv);
        this.hha = new d(this.mPageContext, k.fKI);
        this.hhb = new e(this.mPageContext, k.fKJ);
        this.hhc = new c(this.mPageContext, k.fKH);
        this.hgY.b((r) this.Bs);
        this.hgZ.b((r) this.Bs);
        this.hha.b((r) this.Bs);
        this.hhb.b((r) this.Bs);
        this.hhc.b((r) this.Bs);
        this.gYs.add(this.hgY);
        this.gYs.add(this.hgZ);
        this.gYs.add(this.hha);
        this.gYs.add(this.hhb);
        this.gYs.add(this.hhc);
        this.Bs.addAdapters(this.gYs);
    }

    public void notifyDataSetChanged() {
        if (this.Bs != null) {
            this.Bs.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hgY != null) {
            this.hgY.setPageUniqueId(bdUniqueId);
        }
        if (this.hgZ != null) {
            this.hgZ.setPageUniqueId(bdUniqueId);
        }
        if (this.hha != null) {
            this.hha.setPageUniqueId(bdUniqueId);
        }
        if (this.hhb != null) {
            this.hhb.setPageUniqueId(bdUniqueId);
        }
        if (this.hhc != null) {
            this.hhc.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Bs.setData(list);
    }

    public List<m> getDataList() {
        if (this.Bs != null) {
            return this.Bs.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hhb != null) {
            this.hhb.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hgZ != null) {
            this.hgZ.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hgZ != null) {
            this.hgZ.b(eVar);
        }
    }
}
