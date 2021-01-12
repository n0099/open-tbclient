package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Ya;
    private LinkedList<com.baidu.adp.widget.ListView.a> jXd = new LinkedList<>();
    private f kjk;
    private b kjl;
    private d kjm;
    private e kjn;
    private c kjo;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Ya = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.kjk = new f(this.mPageContext, k.ivd);
        this.kjl = new b(this.mPageContext, l.eOy);
        this.kjm = new d(this.mPageContext, k.ivk);
        this.kjn = new e(this.mPageContext, k.ivi);
        this.kjo = new c(this.mPageContext, k.eOf);
        this.kjk.a(this.Ya);
        this.kjl.a(this.Ya);
        this.kjm.a(this.Ya);
        this.kjn.a(this.Ya);
        this.kjo.a(this.Ya);
        this.jXd.add(this.kjk);
        this.jXd.add(this.kjl);
        this.jXd.add(this.kjm);
        this.jXd.add(this.kjn);
        this.jXd.add(this.kjo);
        this.Ya.addAdapters(this.jXd);
    }

    public void notifyDataSetChanged() {
        if (this.Ya != null) {
            this.Ya.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kjk != null) {
            this.kjk.setPageUniqueId(bdUniqueId);
        }
        if (this.kjl != null) {
            this.kjl.setPageUniqueId(bdUniqueId);
        }
        if (this.kjm != null) {
            this.kjm.setPageUniqueId(bdUniqueId);
        }
        if (this.kjn != null) {
            this.kjn.setPageUniqueId(bdUniqueId);
        }
        if (this.kjo != null) {
            this.kjo.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<n> list) {
        this.Ya.setData(list);
    }

    public List<n> getDataList() {
        if (this.Ya != null) {
            return this.Ya.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kjn != null) {
            this.kjn.setEventCallback(aVar);
        }
        if (this.kjk != null) {
            this.kjk.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.kjl != null) {
            this.kjl.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.kjl != null) {
            this.kjl.b(eVar);
        }
    }
}
