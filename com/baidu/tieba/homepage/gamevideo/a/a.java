package com.baidu.tieba.homepage.gamevideo.a;

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
    private f iJR;
    private c iJS;
    private d iJT;
    private e iJU;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Wu = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.iJR = new f(this.mPageContext, l.hnc);
        this.iJS = new c(this.mPageContext, m.ebo);
        this.iJT = new d(this.mPageContext, l.hnj);
        this.iJU = new e(this.mPageContext, l.hnh);
        this.iJR.a(this.Wu);
        this.iJS.a(this.Wu);
        this.iJT.a(this.Wu);
        this.iJU.a(this.Wu);
        this.iJQ.add(this.iJR);
        this.iJQ.add(this.iJS);
        this.iJQ.add(this.iJT);
        this.iJQ.add(this.iJU);
        this.Wu.addAdapters(this.iJQ);
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iJR != null) {
            this.iJR.setPageUniqueId(bdUniqueId);
        }
        if (this.iJS != null) {
            this.iJS.setPageUniqueId(bdUniqueId);
        }
        if (this.iJT != null) {
            this.iJT.setPageUniqueId(bdUniqueId);
        }
        if (this.iJU != null) {
            this.iJU.setPageUniqueId(bdUniqueId);
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
        if (this.iJU != null) {
            this.iJU.setEventCallback(aVar);
        }
    }

    public void zQ(int i) {
        if (this.iJR != null) {
            this.iJR.zQ(i);
        }
        if (this.iJS != null) {
            this.iJS.zQ(i);
        }
        if (this.iJT != null) {
            this.iJT.zQ(i);
        }
        if (this.iJU != null) {
            this.iJU.zQ(i);
        }
    }

    public void onPause() {
        if (this.iJS != null) {
            this.iJS.onPause();
        }
    }

    public void onDestroy() {
    }
}
