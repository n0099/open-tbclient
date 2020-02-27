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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private LinkedList<com.baidu.adp.widget.ListView.a> has = new LinkedList<>();
    private f hiZ;
    private b hja;
    private d hjb;
    private e hjc;
    private c hjd;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.hiZ = new f(this.mPageContext, k.fMW);
        this.hja = new b(this.mPageContext, l.cRy);
        this.hjb = new d(this.mPageContext, k.fNe);
        this.hjc = new e(this.mPageContext, k.fNf);
        this.hjd = new c(this.mPageContext, k.fNd);
        this.hiZ.b((r) this.BK);
        this.hja.b((r) this.BK);
        this.hjb.b((r) this.BK);
        this.hjc.b((r) this.BK);
        this.hjd.b((r) this.BK);
        this.has.add(this.hiZ);
        this.has.add(this.hja);
        this.has.add(this.hjb);
        this.has.add(this.hjc);
        this.has.add(this.hjd);
        this.BK.addAdapters(this.has);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hiZ != null) {
            this.hiZ.setPageUniqueId(bdUniqueId);
        }
        if (this.hja != null) {
            this.hja.setPageUniqueId(bdUniqueId);
        }
        if (this.hjb != null) {
            this.hjb.setPageUniqueId(bdUniqueId);
        }
        if (this.hjc != null) {
            this.hjc.setPageUniqueId(bdUniqueId);
        }
        if (this.hjd != null) {
            this.hjd.setPageUniqueId(bdUniqueId);
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
        if (this.hjc != null) {
            this.hjc.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hja != null) {
            this.hja.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hja != null) {
            this.hja.b(eVar);
        }
    }
}
