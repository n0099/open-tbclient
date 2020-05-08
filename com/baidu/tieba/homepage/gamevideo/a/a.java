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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vi;
    private LinkedList<com.baidu.adp.widget.ListView.a> hLK = new LinkedList<>();
    private f hLL;
    private c hLM;
    private d hLN;
    private e hLO;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vi = bdTypeRecyclerView;
        BB();
    }

    private void BB() {
        this.hLL = new f(this.mPageContext, k.gsG);
        this.hLM = new c(this.mPageContext, l.dqZ);
        this.hLN = new d(this.mPageContext, k.gsO);
        this.hLO = new e(this.mPageContext, k.gsP);
        this.hLL.a(this.Vi);
        this.hLM.a(this.Vi);
        this.hLN.a(this.Vi);
        this.hLO.a(this.Vi);
        this.hLK.add(this.hLL);
        this.hLK.add(this.hLM);
        this.hLK.add(this.hLN);
        this.hLK.add(this.hLO);
        this.Vi.addAdapters(this.hLK);
    }

    public void notifyDataSetChanged() {
        if (this.Vi != null) {
            this.Vi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hLL != null) {
            this.hLL.setPageUniqueId(bdUniqueId);
        }
        if (this.hLM != null) {
            this.hLM.setPageUniqueId(bdUniqueId);
        }
        if (this.hLN != null) {
            this.hLN.setPageUniqueId(bdUniqueId);
        }
        if (this.hLO != null) {
            this.hLO.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Vi.setData(list);
    }

    public List<m> getDataList() {
        if (this.Vi != null) {
            return this.Vi.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hLO != null) {
            this.hLO.setEventCallback(aVar);
        }
    }

    public void vQ(int i) {
        if (this.hLL != null) {
            this.hLL.vQ(i);
        }
        if (this.hLM != null) {
            this.hLM.vQ(i);
        }
        if (this.hLN != null) {
            this.hLN.vQ(i);
        }
        if (this.hLO != null) {
            this.hLO.vQ(i);
        }
    }

    public void onPause() {
        if (this.hLM != null) {
            this.hLM.onPause();
        }
    }

    public void onDestroy() {
    }
}
