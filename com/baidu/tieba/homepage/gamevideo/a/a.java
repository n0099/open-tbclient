package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private LinkedList<com.baidu.adp.widget.ListView.a> ial = new LinkedList<>();
    private f iam;
    private c ian;
    private d iao;
    private e iap;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vw = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.iam = new f(this.mPageContext, k.gHu);
        this.ian = new c(this.mPageContext, l.dEV);
        this.iao = new d(this.mPageContext, k.gHC);
        this.iap = new e(this.mPageContext, k.gHA);
        this.iam.a(this.Vw);
        this.ian.a(this.Vw);
        this.iao.a(this.Vw);
        this.iap.a(this.Vw);
        this.ial.add(this.iam);
        this.ial.add(this.ian);
        this.ial.add(this.iao);
        this.ial.add(this.iap);
        this.Vw.addAdapters(this.ial);
    }

    public void notifyDataSetChanged() {
        if (this.Vw != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iam != null) {
            this.iam.setPageUniqueId(bdUniqueId);
        }
        if (this.ian != null) {
            this.ian.setPageUniqueId(bdUniqueId);
        }
        if (this.iao != null) {
            this.iao.setPageUniqueId(bdUniqueId);
        }
        if (this.iap != null) {
            this.iap.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<o> list) {
        this.Vw.setData(list);
    }

    public List<o> getDataList() {
        if (this.Vw != null) {
            return this.Vw.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iap != null) {
            this.iap.setEventCallback(aVar);
        }
    }

    public void ww(int i) {
        if (this.iam != null) {
            this.iam.ww(i);
        }
        if (this.ian != null) {
            this.ian.ww(i);
        }
        if (this.iao != null) {
            this.iao.ww(i);
        }
        if (this.iap != null) {
            this.iap.ww(i);
        }
    }

    public void onPause() {
        if (this.ian != null) {
            this.ian.onPause();
        }
    }

    public void onDestroy() {
    }
}
