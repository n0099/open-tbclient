package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private LinkedList<com.baidu.adp.widget.ListView.a> iJQ = new LinkedList<>();
    private f iWg;
    private b iWh;
    private d iWi;
    private e iWj;
    private c iWk;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Wu = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.iWg = new f(this.mPageContext, l.hnc);
        this.iWh = new b(this.mPageContext, m.ebo);
        this.iWi = new d(this.mPageContext, l.hnj);
        this.iWj = new e(this.mPageContext, l.hnh);
        this.iWk = new c(this.mPageContext, l.eaW);
        this.iWg.a(this.Wu);
        this.iWh.a(this.Wu);
        this.iWi.a(this.Wu);
        this.iWj.a(this.Wu);
        this.iWk.a(this.Wu);
        this.iJQ.add(this.iWg);
        this.iJQ.add(this.iWh);
        this.iJQ.add(this.iWi);
        this.iJQ.add(this.iWj);
        this.iJQ.add(this.iWk);
        this.Wu.addAdapters(this.iJQ);
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iWg != null) {
            this.iWg.setPageUniqueId(bdUniqueId);
        }
        if (this.iWh != null) {
            this.iWh.setPageUniqueId(bdUniqueId);
        }
        if (this.iWi != null) {
            this.iWi.setPageUniqueId(bdUniqueId);
        }
        if (this.iWj != null) {
            this.iWj.setPageUniqueId(bdUniqueId);
        }
        if (this.iWk != null) {
            this.iWk.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Wu.setData(list);
    }

    public List<q> getDataList() {
        if (this.Wu != null) {
            return this.Wu.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iWj != null) {
            this.iWj.setEventCallback(aVar);
        }
        if (this.iWg != null) {
            this.iWg.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.iWh != null) {
            this.iWh.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.iWh != null) {
            this.iWh.b(eVar);
        }
    }
}
