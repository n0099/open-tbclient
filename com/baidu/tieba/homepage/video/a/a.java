package com.baidu.tieba.homepage.video.a;

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
    private f jeS;
    private b jeT;
    private d jeU;
    private e jeV;
    private c jeW;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.WM = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.jeS = new f(this.mPageContext, l.huk);
        this.jeT = new b(this.mPageContext, m.edC);
        this.jeU = new d(this.mPageContext, l.hur);
        this.jeV = new e(this.mPageContext, l.hup);
        this.jeW = new c(this.mPageContext, l.edk);
        this.jeS.a(this.WM);
        this.jeT.a(this.WM);
        this.jeU.a(this.WM);
        this.jeV.a(this.WM);
        this.jeW.a(this.WM);
        this.iSC.add(this.jeS);
        this.iSC.add(this.jeT);
        this.iSC.add(this.jeU);
        this.iSC.add(this.jeV);
        this.iSC.add(this.jeW);
        this.WM.addAdapters(this.iSC);
    }

    public void notifyDataSetChanged() {
        if (this.WM != null) {
            this.WM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jeS != null) {
            this.jeS.setPageUniqueId(bdUniqueId);
        }
        if (this.jeT != null) {
            this.jeT.setPageUniqueId(bdUniqueId);
        }
        if (this.jeU != null) {
            this.jeU.setPageUniqueId(bdUniqueId);
        }
        if (this.jeV != null) {
            this.jeV.setPageUniqueId(bdUniqueId);
        }
        if (this.jeW != null) {
            this.jeW.setPageUniqueId(bdUniqueId);
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
        if (this.jeV != null) {
            this.jeV.setEventCallback(aVar);
        }
        if (this.jeS != null) {
            this.jeS.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.jeT != null) {
            this.jeT.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.jeT != null) {
            this.jeT.b(eVar);
        }
    }
}
