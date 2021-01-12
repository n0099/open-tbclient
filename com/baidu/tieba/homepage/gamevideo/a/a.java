package com.baidu.tieba.homepage.gamevideo.a;

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
    private f jXe;
    private c jXf;
    private d jXg;
    private e jXh;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Ya = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.jXe = new f(this.mPageContext, k.ivd);
        this.jXf = new c(this.mPageContext, l.eOy);
        this.jXg = new d(this.mPageContext, k.ivk);
        this.jXh = new e(this.mPageContext, k.ivi);
        this.jXe.a(this.Ya);
        this.jXf.a(this.Ya);
        this.jXg.a(this.Ya);
        this.jXh.a(this.Ya);
        this.jXd.add(this.jXe);
        this.jXd.add(this.jXf);
        this.jXd.add(this.jXg);
        this.jXd.add(this.jXh);
        this.Ya.addAdapters(this.jXd);
    }

    public void notifyDataSetChanged() {
        if (this.Ya != null) {
            this.Ya.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jXe != null) {
            this.jXe.setPageUniqueId(bdUniqueId);
        }
        if (this.jXf != null) {
            this.jXf.setPageUniqueId(bdUniqueId);
        }
        if (this.jXg != null) {
            this.jXg.setPageUniqueId(bdUniqueId);
        }
        if (this.jXh != null) {
            this.jXh.setPageUniqueId(bdUniqueId);
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
        if (this.jXh != null) {
            this.jXh.setEventCallback(aVar);
        }
    }

    public void By(int i) {
        if (this.jXe != null) {
            this.jXe.By(i);
        }
        if (this.jXf != null) {
            this.jXf.By(i);
        }
        if (this.jXg != null) {
            this.jXg.By(i);
        }
        if (this.jXh != null) {
            this.jXh.By(i);
        }
    }

    public void onPause() {
        if (this.jXf != null) {
            this.jXf.onPause();
        }
    }

    public void onDestroy() {
    }
}
