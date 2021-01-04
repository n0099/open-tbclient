package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Yc;
    private LinkedList<com.baidu.adp.widget.ListView.a> kbI = new LinkedList<>();
    private f knP;
    private b knQ;
    private d knR;
    private e knS;
    private c knT;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Yc = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.knP = new f(this.mPageContext, k.izK);
        this.knQ = new b(this.mPageContext, l.eTj);
        this.knR = new d(this.mPageContext, k.izR);
        this.knS = new e(this.mPageContext, k.izP);
        this.knT = new c(this.mPageContext, k.eSQ);
        this.knP.a(this.Yc);
        this.knQ.a(this.Yc);
        this.knR.a(this.Yc);
        this.knS.a(this.Yc);
        this.knT.a(this.Yc);
        this.kbI.add(this.knP);
        this.kbI.add(this.knQ);
        this.kbI.add(this.knR);
        this.kbI.add(this.knS);
        this.kbI.add(this.knT);
        this.Yc.addAdapters(this.kbI);
    }

    public void notifyDataSetChanged() {
        if (this.Yc != null) {
            this.Yc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.knP != null) {
            this.knP.setPageUniqueId(bdUniqueId);
        }
        if (this.knQ != null) {
            this.knQ.setPageUniqueId(bdUniqueId);
        }
        if (this.knR != null) {
            this.knR.setPageUniqueId(bdUniqueId);
        }
        if (this.knS != null) {
            this.knS.setPageUniqueId(bdUniqueId);
        }
        if (this.knT != null) {
            this.knT.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<n> list) {
        this.Yc.setData(list);
    }

    public List<n> getDataList() {
        if (this.Yc != null) {
            return this.Yc.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.knS != null) {
            this.knS.setEventCallback(aVar);
        }
        if (this.knP != null) {
            this.knP.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.knQ != null) {
            this.knQ.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.knQ != null) {
            this.knQ.b(eVar);
        }
    }
}
