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
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView WM;
    private LinkedList<com.baidu.adp.widget.ListView.a> iSC = new LinkedList<>();
    private f iSD;
    private c iSE;
    private d iSF;
    private e iSG;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.WM = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.iSD = new f(this.mPageContext, l.huk);
        this.iSE = new c(this.mPageContext, m.edC);
        this.iSF = new d(this.mPageContext, l.hur);
        this.iSG = new e(this.mPageContext, l.hup);
        this.iSD.a(this.WM);
        this.iSE.a(this.WM);
        this.iSF.a(this.WM);
        this.iSG.a(this.WM);
        this.iSC.add(this.iSD);
        this.iSC.add(this.iSE);
        this.iSC.add(this.iSF);
        this.iSC.add(this.iSG);
        this.WM.addAdapters(this.iSC);
    }

    public void notifyDataSetChanged() {
        if (this.WM != null) {
            this.WM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iSD != null) {
            this.iSD.setPageUniqueId(bdUniqueId);
        }
        if (this.iSE != null) {
            this.iSE.setPageUniqueId(bdUniqueId);
        }
        if (this.iSF != null) {
            this.iSF.setPageUniqueId(bdUniqueId);
        }
        if (this.iSG != null) {
            this.iSG.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.WM.setData(list);
    }

    public List<q> getDataList() {
        if (this.WM != null) {
            return this.WM.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iSG != null) {
            this.iSG.setEventCallback(aVar);
        }
    }

    public void Ar(int i) {
        if (this.iSD != null) {
            this.iSD.Ar(i);
        }
        if (this.iSE != null) {
            this.iSE.Ar(i);
        }
        if (this.iSF != null) {
            this.iSF.Ar(i);
        }
        if (this.iSG != null) {
            this.iSG.Ar(i);
        }
    }

    public void onPause() {
        if (this.iSE != null) {
            this.iSE.onPause();
        }
    }

    public void onDestroy() {
    }
}
