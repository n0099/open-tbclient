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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private LinkedList<com.baidu.adp.widget.ListView.a> haG = new LinkedList<>();
    private f haH;
    private c haI;
    private d haJ;
    private e haK;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.haH = new f(this.mPageContext, k.fNl);
        this.haI = new c(this.mPageContext, l.cRA);
        this.haJ = new d(this.mPageContext, k.fNt);
        this.haK = new e(this.mPageContext, k.fNu);
        this.haH.b((r) this.BK);
        this.haI.b((r) this.BK);
        this.haJ.b((r) this.BK);
        this.haK.b((r) this.BK);
        this.haG.add(this.haH);
        this.haG.add(this.haI);
        this.haG.add(this.haJ);
        this.haG.add(this.haK);
        this.BK.addAdapters(this.haG);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.haH != null) {
            this.haH.setPageUniqueId(bdUniqueId);
        }
        if (this.haI != null) {
            this.haI.setPageUniqueId(bdUniqueId);
        }
        if (this.haJ != null) {
            this.haJ.setPageUniqueId(bdUniqueId);
        }
        if (this.haK != null) {
            this.haK.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.BK.setData(list);
    }

    public List<m> getDataList() {
        if (this.BK != null) {
            return this.BK.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.haK != null) {
            this.haK.setEventCallback(aVar);
        }
    }

    public void vl(int i) {
        if (this.haH != null) {
            this.haH.vl(i);
        }
        if (this.haI != null) {
            this.haI.vl(i);
        }
        if (this.haJ != null) {
            this.haJ.vl(i);
        }
        if (this.haK != null) {
            this.haK.vl(i);
        }
    }

    public void onPause() {
        if (this.haI != null) {
            this.haI.onPause();
        }
    }

    public void onDestroy() {
    }
}
