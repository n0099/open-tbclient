package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView VT;
    private LinkedList<com.baidu.adp.widget.ListView.a> ivB = new LinkedList<>();
    private f ivC;
    private c ivD;
    private d ivE;
    private e ivF;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.VT = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.ivC = new f(this.mPageContext, k.haj);
        this.ivD = new c(this.mPageContext, l.dRS);
        this.ivE = new d(this.mPageContext, k.har);
        this.ivF = new e(this.mPageContext, k.hap);
        this.ivC.a(this.VT);
        this.ivD.a(this.VT);
        this.ivE.a(this.VT);
        this.ivF.a(this.VT);
        this.ivB.add(this.ivC);
        this.ivB.add(this.ivD);
        this.ivB.add(this.ivE);
        this.ivB.add(this.ivF);
        this.VT.addAdapters(this.ivB);
    }

    public void notifyDataSetChanged() {
        if (this.VT != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ivC != null) {
            this.ivC.setPageUniqueId(bdUniqueId);
        }
        if (this.ivD != null) {
            this.ivD.setPageUniqueId(bdUniqueId);
        }
        if (this.ivE != null) {
            this.ivE.setPageUniqueId(bdUniqueId);
        }
        if (this.ivF != null) {
            this.ivF.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.VT.setData(list);
    }

    public List<q> getDataList() {
        if (this.VT != null) {
            return this.VT.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.ivF != null) {
            this.ivF.setEventCallback(aVar);
        }
    }

    public void xw(int i) {
        if (this.ivC != null) {
            this.ivC.xw(i);
        }
        if (this.ivD != null) {
            this.ivD.xw(i);
        }
        if (this.ivE != null) {
            this.ivE.xw(i);
        }
        if (this.ivF != null) {
            this.ivF.xw(i);
        }
    }

    public void onPause() {
        if (this.ivD != null) {
            this.ivD.onPause();
        }
    }

    public void onDestroy() {
    }
}
