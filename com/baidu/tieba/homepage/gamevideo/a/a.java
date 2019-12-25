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
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private LinkedList<com.baidu.adp.widget.ListView.a> gUU = new LinkedList<>();
    private f gUV;
    private c gUW;
    private d gUX;
    private e gUY;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Bn = bdTypeRecyclerView;
        uR();
    }

    private void uR() {
        this.gUV = new f(this.mPageContext, k.fHq);
        this.gUW = new c(this.mPageContext, l.cNl);
        this.gUX = new d(this.mPageContext, k.fHy);
        this.gUY = new e(this.mPageContext, k.fHz);
        this.gUV.b((r) this.Bn);
        this.gUW.b((r) this.Bn);
        this.gUX.b((r) this.Bn);
        this.gUY.b((r) this.Bn);
        this.gUU.add(this.gUV);
        this.gUU.add(this.gUW);
        this.gUU.add(this.gUX);
        this.gUU.add(this.gUY);
        this.Bn.addAdapters(this.gUU);
    }

    public void notifyDataSetChanged() {
        if (this.Bn != null) {
            this.Bn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gUV != null) {
            this.gUV.setPageUniqueId(bdUniqueId);
        }
        if (this.gUW != null) {
            this.gUW.setPageUniqueId(bdUniqueId);
        }
        if (this.gUX != null) {
            this.gUX.setPageUniqueId(bdUniqueId);
        }
        if (this.gUY != null) {
            this.gUY.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Bn.setData(list);
    }

    public List<m> getDataList() {
        if (this.Bn != null) {
            return this.Bn.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gUY != null) {
            this.gUY.setEventCallback(aVar);
        }
    }

    public void va(int i) {
        if (this.gUV != null) {
            this.gUV.va(i);
        }
        if (this.gUW != null) {
            this.gUW.va(i);
        }
        if (this.gUX != null) {
            this.gUX.va(i);
        }
        if (this.gUY != null) {
            this.gUY.va(i);
        }
    }

    public void onPause() {
        if (this.gUW != null) {
            this.gUW.onPause();
        }
    }

    public void onDestroy() {
    }
}
