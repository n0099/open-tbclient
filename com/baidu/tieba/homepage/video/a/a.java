package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private LinkedList<com.baidu.adp.widget.ListView.a> jAQ = new LinkedList<>();
    private f jMZ;
    private b jNa;
    private d jNb;
    private e jNc;
    private c jNd;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xi = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.jMZ = new f(this.mPageContext, k.icq);
        this.jNa = new b(this.mPageContext, l.eCo);
        this.jNb = new d(this.mPageContext, k.icx);
        this.jNc = new e(this.mPageContext, k.icv);
        this.jNd = new c(this.mPageContext, k.eBW);
        this.jMZ.a(this.Xi);
        this.jNa.a(this.Xi);
        this.jNb.a(this.Xi);
        this.jNc.a(this.Xi);
        this.jNd.a(this.Xi);
        this.jAQ.add(this.jMZ);
        this.jAQ.add(this.jNa);
        this.jAQ.add(this.jNb);
        this.jAQ.add(this.jNc);
        this.jAQ.add(this.jNd);
        this.Xi.addAdapters(this.jAQ);
    }

    public void notifyDataSetChanged() {
        if (this.Xi != null) {
            this.Xi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jMZ != null) {
            this.jMZ.setPageUniqueId(bdUniqueId);
        }
        if (this.jNa != null) {
            this.jNa.setPageUniqueId(bdUniqueId);
        }
        if (this.jNb != null) {
            this.jNb.setPageUniqueId(bdUniqueId);
        }
        if (this.jNc != null) {
            this.jNc.setPageUniqueId(bdUniqueId);
        }
        if (this.jNd != null) {
            this.jNd.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Xi.setData(list);
    }

    public List<q> getDataList() {
        if (this.Xi != null) {
            return this.Xi.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jNc != null) {
            this.jNc.setEventCallback(aVar);
        }
        if (this.jMZ != null) {
            this.jMZ.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.jNa != null) {
            this.jNa.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.jNa != null) {
            this.jNa.b(eVar);
        }
    }
}
