package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Oo;
    private LinkedList<com.baidu.adp.widget.ListView.a> giU = new LinkedList<>();
    private f giV;
    private c giW;
    private d giX;
    private e giY;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Oo = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.giV = new f(this.mPageContext, k.eHK);
        this.giW = new c(this.mPageContext, l.bKa);
        this.giX = new d(this.mPageContext, k.eHQ);
        this.giY = new e(this.mPageContext, k.eHR);
        this.giV.b(this.Oo);
        this.giW.b(this.Oo);
        this.giX.b(this.Oo);
        this.giY.b(this.Oo);
        this.giU.add(this.giV);
        this.giU.add(this.giW);
        this.giU.add(this.giX);
        this.giU.add(this.giY);
        this.Oo.addAdapters(this.giU);
    }

    public void notifyDataSetChanged() {
        if (this.Oo != null) {
            this.Oo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.giV != null) {
            this.giV.setPageUniqueId(bdUniqueId);
        }
        if (this.giW != null) {
            this.giW.setPageUniqueId(bdUniqueId);
        }
        if (this.giX != null) {
            this.giX.setPageUniqueId(bdUniqueId);
        }
        if (this.giY != null) {
            this.giY.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Oo.setData(list);
    }

    public List<m> getDataList() {
        if (this.Oo != null) {
            return this.Oo.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.giV != null) {
            this.giV.setEventCallback(aVar);
        }
    }

    public void ud(int i) {
        if (this.giV != null) {
            this.giV.ud(i);
        }
        if (this.giW != null) {
            this.giW.ud(i);
        }
        if (this.giX != null) {
            this.giX.ud(i);
        }
        if (this.giY != null) {
            this.giY.ud(i);
        }
    }

    public void onPause() {
        if (this.giW != null) {
            this.giW.onPause();
        }
    }

    public void onDestroy() {
    }
}
