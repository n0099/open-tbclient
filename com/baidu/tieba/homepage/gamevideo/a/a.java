package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Op;
    private LinkedList<com.baidu.adp.widget.ListView.a> ggl = new LinkedList<>();
    private f ggm;
    private c ggn;
    private d ggo;
    private e ggp;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Op = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.ggm = new f(this.mPageContext, k.eFU);
        this.ggn = new c(this.mPageContext, l.bJx);
        this.ggo = new d(this.mPageContext, k.eGa);
        this.ggp = new e(this.mPageContext, k.eGb);
        this.ggm.b(this.Op);
        this.ggn.b(this.Op);
        this.ggo.b(this.Op);
        this.ggp.b(this.Op);
        this.ggl.add(this.ggm);
        this.ggl.add(this.ggn);
        this.ggl.add(this.ggo);
        this.ggl.add(this.ggp);
        this.Op.addAdapters(this.ggl);
    }

    public void notifyDataSetChanged() {
        if (this.Op != null) {
            this.Op.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ggm != null) {
            this.ggm.setPageUniqueId(bdUniqueId);
        }
        if (this.ggn != null) {
            this.ggn.setPageUniqueId(bdUniqueId);
        }
        if (this.ggo != null) {
            this.ggo.setPageUniqueId(bdUniqueId);
        }
        if (this.ggp != null) {
            this.ggp.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Op.setData(list);
    }

    public List<m> getDataList() {
        if (this.Op != null) {
            return this.Op.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.ggm != null) {
            this.ggm.setEventCallback(aVar);
        }
    }

    public void tX(int i) {
        if (this.ggm != null) {
            this.ggm.tX(i);
        }
        if (this.ggn != null) {
            this.ggn.tX(i);
        }
        if (this.ggo != null) {
            this.ggo.tX(i);
        }
        if (this.ggp != null) {
            this.ggp.tX(i);
        }
    }

    public void onPause() {
        if (this.ggn != null) {
            this.ggn.onPause();
        }
    }

    public void onDestroy() {
    }
}
