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
/* loaded from: classes4.dex */
public class a {
    private LinkedList<com.baidu.adp.widget.ListView.a> gis = new LinkedList<>();
    private f git;
    private c giu;
    private d giv;
    private e giw;
    private TbPageContext mPageContext;
    private BdTypeRecyclerView zj;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.zj = bdTypeRecyclerView;
        sX();
    }

    private void sX() {
        this.git = new f(this.mPageContext, k.eQp);
        this.giu = new c(this.mPageContext, l.cbI);
        this.giv = new d(this.mPageContext, k.eQv);
        this.giw = new e(this.mPageContext, k.eQw);
        this.git.b((r) this.zj);
        this.giu.b((r) this.zj);
        this.giv.b((r) this.zj);
        this.giw.b((r) this.zj);
        this.gis.add(this.git);
        this.gis.add(this.giu);
        this.gis.add(this.giv);
        this.gis.add(this.giw);
        this.zj.addAdapters(this.gis);
    }

    public void notifyDataSetChanged() {
        if (this.zj != null) {
            this.zj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.git != null) {
            this.git.setPageUniqueId(bdUniqueId);
        }
        if (this.giu != null) {
            this.giu.setPageUniqueId(bdUniqueId);
        }
        if (this.giv != null) {
            this.giv.setPageUniqueId(bdUniqueId);
        }
        if (this.giw != null) {
            this.giw.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.zj.setData(list);
    }

    public List<m> getDataList() {
        if (this.zj != null) {
            return this.zj.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.git != null) {
            this.git.setEventCallback(aVar);
        }
    }

    public void sY(int i) {
        if (this.git != null) {
            this.git.sY(i);
        }
        if (this.giu != null) {
            this.giu.sY(i);
        }
        if (this.giv != null) {
            this.giv.sY(i);
        }
        if (this.giw != null) {
            this.giw.sY(i);
        }
    }

    public void onPause() {
        if (this.giu != null) {
            this.giu.onPause();
        }
    }

    public void onDestroy() {
    }
}
