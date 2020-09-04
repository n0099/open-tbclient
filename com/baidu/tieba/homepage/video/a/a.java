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
    private LinkedList<com.baidu.adp.widget.ListView.a> iJW = new LinkedList<>();
    private f iWm;
    private b iWn;
    private d iWo;
    private e iWp;
    private c iWq;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Wu = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.iWm = new f(this.mPageContext, l.hng);
        this.iWn = new b(this.mPageContext, m.ebs);
        this.iWo = new d(this.mPageContext, l.hnn);
        this.iWp = new e(this.mPageContext, l.hnl);
        this.iWq = new c(this.mPageContext, l.eba);
        this.iWm.a(this.Wu);
        this.iWn.a(this.Wu);
        this.iWo.a(this.Wu);
        this.iWp.a(this.Wu);
        this.iWq.a(this.Wu);
        this.iJW.add(this.iWm);
        this.iJW.add(this.iWn);
        this.iJW.add(this.iWo);
        this.iJW.add(this.iWp);
        this.iJW.add(this.iWq);
        this.Wu.addAdapters(this.iJW);
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iWm != null) {
            this.iWm.setPageUniqueId(bdUniqueId);
        }
        if (this.iWn != null) {
            this.iWn.setPageUniqueId(bdUniqueId);
        }
        if (this.iWo != null) {
            this.iWo.setPageUniqueId(bdUniqueId);
        }
        if (this.iWp != null) {
            this.iWp.setPageUniqueId(bdUniqueId);
        }
        if (this.iWq != null) {
            this.iWq.setPageUniqueId(bdUniqueId);
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
        if (this.iWp != null) {
            this.iWp.setEventCallback(aVar);
        }
        if (this.iWm != null) {
            this.iWm.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.iWn != null) {
            this.iWn.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.iWn != null) {
            this.iWn.b(eVar);
        }
    }
}
