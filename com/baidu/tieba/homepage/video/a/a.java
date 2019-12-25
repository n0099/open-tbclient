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
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private LinkedList<com.baidu.adp.widget.ListView.a> gUU = new LinkedList<>();
    private f hdv;
    private b hdw;
    private d hdx;
    private e hdy;
    private c hdz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Bn = bdTypeRecyclerView;
        uR();
    }

    private void uR() {
        this.hdv = new f(this.mPageContext, k.fHq);
        this.hdw = new b(this.mPageContext, l.cNl);
        this.hdx = new d(this.mPageContext, k.fHy);
        this.hdy = new e(this.mPageContext, k.fHz);
        this.hdz = new c(this.mPageContext, k.fHx);
        this.hdv.b((r) this.Bn);
        this.hdw.b((r) this.Bn);
        this.hdx.b((r) this.Bn);
        this.hdy.b((r) this.Bn);
        this.hdz.b((r) this.Bn);
        this.gUU.add(this.hdv);
        this.gUU.add(this.hdw);
        this.gUU.add(this.hdx);
        this.gUU.add(this.hdy);
        this.gUU.add(this.hdz);
        this.Bn.addAdapters(this.gUU);
    }

    public void notifyDataSetChanged() {
        if (this.Bn != null) {
            this.Bn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hdv != null) {
            this.hdv.setPageUniqueId(bdUniqueId);
        }
        if (this.hdw != null) {
            this.hdw.setPageUniqueId(bdUniqueId);
        }
        if (this.hdx != null) {
            this.hdx.setPageUniqueId(bdUniqueId);
        }
        if (this.hdy != null) {
            this.hdy.setPageUniqueId(bdUniqueId);
        }
        if (this.hdz != null) {
            this.hdz.setPageUniqueId(bdUniqueId);
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
        if (this.hdy != null) {
            this.hdy.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hdw != null) {
            this.hdw.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hdw != null) {
            this.hdw.b(eVar);
        }
    }
}
