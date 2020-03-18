package com.baidu.tieba.homepage.video.a;

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
    private LinkedList<com.baidu.adp.widget.ListView.a> hbO = new LinkedList<>();
    private f hkN;
    private b hkO;
    private d hkP;
    private e hkQ;
    private c hkR;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.BK = bdTypeRecyclerView;
        wR();
    }

    private void wR() {
        this.hkN = new f(this.mPageContext, k.fNT);
        this.hkO = new b(this.mPageContext, l.cRN);
        this.hkP = new d(this.mPageContext, k.fOb);
        this.hkQ = new e(this.mPageContext, k.fOc);
        this.hkR = new c(this.mPageContext, k.fOa);
        this.hkN.b((r) this.BK);
        this.hkO.b((r) this.BK);
        this.hkP.b((r) this.BK);
        this.hkQ.b((r) this.BK);
        this.hkR.b((r) this.BK);
        this.hbO.add(this.hkN);
        this.hbO.add(this.hkO);
        this.hbO.add(this.hkP);
        this.hbO.add(this.hkQ);
        this.hbO.add(this.hkR);
        this.BK.addAdapters(this.hbO);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hkN != null) {
            this.hkN.setPageUniqueId(bdUniqueId);
        }
        if (this.hkO != null) {
            this.hkO.setPageUniqueId(bdUniqueId);
        }
        if (this.hkP != null) {
            this.hkP.setPageUniqueId(bdUniqueId);
        }
        if (this.hkQ != null) {
            this.hkQ.setPageUniqueId(bdUniqueId);
        }
        if (this.hkR != null) {
            this.hkR.setPageUniqueId(bdUniqueId);
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
        if (this.hkQ != null) {
            this.hkQ.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hkO != null) {
            this.hkO.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hkO != null) {
            this.hkO.b(eVar);
        }
    }
}
