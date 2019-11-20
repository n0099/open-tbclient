package com.baidu.tieba.homepage.gamevideo.a;

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
/* loaded from: classes4.dex */
public class a {
    private LinkedList<com.baidu.adp.widget.ListView.a> ghA = new LinkedList<>();
    private f ghB;
    private c ghC;
    private d ghD;
    private e ghE;
    private TbPageContext mPageContext;
    private BdTypeRecyclerView yJ;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.yJ = bdTypeRecyclerView;
        sY();
    }

    private void sY() {
        this.ghB = new f(this.mPageContext, k.ePy);
        this.ghC = new c(this.mPageContext, l.caR);
        this.ghD = new d(this.mPageContext, k.ePE);
        this.ghE = new e(this.mPageContext, k.ePF);
        this.ghB.b((r) this.yJ);
        this.ghC.b((r) this.yJ);
        this.ghD.b((r) this.yJ);
        this.ghE.b((r) this.yJ);
        this.ghA.add(this.ghB);
        this.ghA.add(this.ghC);
        this.ghA.add(this.ghD);
        this.ghA.add(this.ghE);
        this.yJ.addAdapters(this.ghA);
    }

    public void notifyDataSetChanged() {
        if (this.yJ != null) {
            this.yJ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ghB != null) {
            this.ghB.setPageUniqueId(bdUniqueId);
        }
        if (this.ghC != null) {
            this.ghC.setPageUniqueId(bdUniqueId);
        }
        if (this.ghD != null) {
            this.ghD.setPageUniqueId(bdUniqueId);
        }
        if (this.ghE != null) {
            this.ghE.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.yJ.setData(list);
    }

    public List<m> getDataList() {
        if (this.yJ != null) {
            return this.yJ.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.ghB != null) {
            this.ghB.setEventCallback(aVar);
        }
    }

    public void sX(int i) {
        if (this.ghB != null) {
            this.ghB.sX(i);
        }
        if (this.ghC != null) {
            this.ghC.sX(i);
        }
        if (this.ghD != null) {
            this.ghD.sX(i);
        }
        if (this.ghE != null) {
            this.ghE.sX(i);
        }
    }

    public void onPause() {
        if (this.ghC != null) {
            this.ghC.onPause();
        }
    }

    public void onDestroy() {
    }
}
