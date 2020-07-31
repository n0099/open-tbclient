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
    private f ivA;
    private c ivB;
    private d ivC;
    private e ivD;
    private LinkedList<com.baidu.adp.widget.ListView.a> ivz = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.VT = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.ivA = new f(this.mPageContext, k.haj);
        this.ivB = new c(this.mPageContext, l.dRS);
        this.ivC = new d(this.mPageContext, k.har);
        this.ivD = new e(this.mPageContext, k.hap);
        this.ivA.a(this.VT);
        this.ivB.a(this.VT);
        this.ivC.a(this.VT);
        this.ivD.a(this.VT);
        this.ivz.add(this.ivA);
        this.ivz.add(this.ivB);
        this.ivz.add(this.ivC);
        this.ivz.add(this.ivD);
        this.VT.addAdapters(this.ivz);
    }

    public void notifyDataSetChanged() {
        if (this.VT != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ivA != null) {
            this.ivA.setPageUniqueId(bdUniqueId);
        }
        if (this.ivB != null) {
            this.ivB.setPageUniqueId(bdUniqueId);
        }
        if (this.ivC != null) {
            this.ivC.setPageUniqueId(bdUniqueId);
        }
        if (this.ivD != null) {
            this.ivD.setPageUniqueId(bdUniqueId);
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
        if (this.ivD != null) {
            this.ivD.setEventCallback(aVar);
        }
    }

    public void xw(int i) {
        if (this.ivA != null) {
            this.ivA.xw(i);
        }
        if (this.ivB != null) {
            this.ivB.xw(i);
        }
        if (this.ivC != null) {
            this.ivC.xw(i);
        }
        if (this.ivD != null) {
            this.ivD.xw(i);
        }
    }

    public void onPause() {
        if (this.ivB != null) {
            this.ivB.onPause();
        }
    }

    public void onDestroy() {
    }
}
