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
    private LinkedList<com.baidu.adp.widget.ListView.a> iJW = new LinkedList<>();
    private f iJX;
    private c iJY;
    private d iJZ;
    private e iKa;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Wu = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.iJX = new f(this.mPageContext, l.hng);
        this.iJY = new c(this.mPageContext, m.ebs);
        this.iJZ = new d(this.mPageContext, l.hnn);
        this.iKa = new e(this.mPageContext, l.hnl);
        this.iJX.a(this.Wu);
        this.iJY.a(this.Wu);
        this.iJZ.a(this.Wu);
        this.iKa.a(this.Wu);
        this.iJW.add(this.iJX);
        this.iJW.add(this.iJY);
        this.iJW.add(this.iJZ);
        this.iJW.add(this.iKa);
        this.Wu.addAdapters(this.iJW);
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iJX != null) {
            this.iJX.setPageUniqueId(bdUniqueId);
        }
        if (this.iJY != null) {
            this.iJY.setPageUniqueId(bdUniqueId);
        }
        if (this.iJZ != null) {
            this.iJZ.setPageUniqueId(bdUniqueId);
        }
        if (this.iKa != null) {
            this.iKa.setPageUniqueId(bdUniqueId);
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
        if (this.iKa != null) {
            this.iKa.setEventCallback(aVar);
        }
    }

    public void zQ(int i) {
        if (this.iJX != null) {
            this.iJX.zQ(i);
        }
        if (this.iJY != null) {
            this.iJY.zQ(i);
        }
        if (this.iJZ != null) {
            this.iJZ.zQ(i);
        }
        if (this.iKa != null) {
            this.iKa.zQ(i);
        }
    }

    public void onPause() {
        if (this.iJY != null) {
            this.iJY.onPause();
        }
    }

    public void onDestroy() {
    }
}
