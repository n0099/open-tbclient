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
    private BdTypeRecyclerView Vf;
    private LinkedList<com.baidu.adp.widget.ListView.a> hLE = new LinkedList<>();
    private f hLF;
    private c hLG;
    private d hLH;
    private e hLI;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vf = bdTypeRecyclerView;
        BC();
    }

    private void BC() {
        this.hLF = new f(this.mPageContext, k.gsA);
        this.hLG = new c(this.mPageContext, l.dqV);
        this.hLH = new d(this.mPageContext, k.gsI);
        this.hLI = new e(this.mPageContext, k.gsJ);
        this.hLF.a(this.Vf);
        this.hLG.a(this.Vf);
        this.hLH.a(this.Vf);
        this.hLI.a(this.Vf);
        this.hLE.add(this.hLF);
        this.hLE.add(this.hLG);
        this.hLE.add(this.hLH);
        this.hLE.add(this.hLI);
        this.Vf.addAdapters(this.hLE);
    }

    public void notifyDataSetChanged() {
        if (this.Vf != null) {
            this.Vf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hLF != null) {
            this.hLF.setPageUniqueId(bdUniqueId);
        }
        if (this.hLG != null) {
            this.hLG.setPageUniqueId(bdUniqueId);
        }
        if (this.hLH != null) {
            this.hLH.setPageUniqueId(bdUniqueId);
        }
        if (this.hLI != null) {
            this.hLI.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Vf.setData(list);
    }

    public List<m> getDataList() {
        if (this.Vf != null) {
            return this.Vf.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hLI != null) {
            this.hLI.setEventCallback(aVar);
        }
    }

    public void vQ(int i) {
        if (this.hLF != null) {
            this.hLF.vQ(i);
        }
        if (this.hLG != null) {
            this.hLG.vQ(i);
        }
        if (this.hLH != null) {
            this.hLH.vQ(i);
        }
        if (this.hLI != null) {
            this.hLI.vQ(i);
        }
    }

    public void onPause() {
        if (this.hLG != null) {
            this.hLG.onPause();
        }
    }

    public void onDestroy() {
    }
}
