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
    private LinkedList<com.baidu.adp.widget.ListView.a> ghb = new LinkedList<>();
    private f ghc;
    private c ghd;
    private d ghe;
    private e ghf;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Op = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.ghc = new f(this.mPageContext, k.eGb);
        this.ghd = new c(this.mPageContext, l.bJC);
        this.ghe = new d(this.mPageContext, k.eGh);
        this.ghf = new e(this.mPageContext, k.eGi);
        this.ghc.b(this.Op);
        this.ghd.b(this.Op);
        this.ghe.b(this.Op);
        this.ghf.b(this.Op);
        this.ghb.add(this.ghc);
        this.ghb.add(this.ghd);
        this.ghb.add(this.ghe);
        this.ghb.add(this.ghf);
        this.Op.addAdapters(this.ghb);
    }

    public void notifyDataSetChanged() {
        if (this.Op != null) {
            this.Op.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ghc != null) {
            this.ghc.setPageUniqueId(bdUniqueId);
        }
        if (this.ghd != null) {
            this.ghd.setPageUniqueId(bdUniqueId);
        }
        if (this.ghe != null) {
            this.ghe.setPageUniqueId(bdUniqueId);
        }
        if (this.ghf != null) {
            this.ghf.setPageUniqueId(bdUniqueId);
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
        if (this.ghc != null) {
            this.ghc.setEventCallback(aVar);
        }
    }

    public void tZ(int i) {
        if (this.ghc != null) {
            this.ghc.tZ(i);
        }
        if (this.ghd != null) {
            this.ghd.tZ(i);
        }
        if (this.ghe != null) {
            this.ghe.tZ(i);
        }
        if (this.ghf != null) {
            this.ghf.tZ(i);
        }
    }

    public void onPause() {
        if (this.ghd != null) {
            this.ghd.onPause();
        }
    }

    public void onDestroy() {
    }
}
