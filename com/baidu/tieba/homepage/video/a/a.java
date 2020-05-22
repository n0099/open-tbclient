package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private LinkedList<com.baidu.adp.widget.ListView.a> ial = new LinkedList<>();
    private f ijn;
    private b ijo;
    private d ijp;
    private e ijq;
    private c ijr;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vw = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.ijn = new f(this.mPageContext, k.gHu);
        this.ijo = new b(this.mPageContext, l.dEV);
        this.ijp = new d(this.mPageContext, k.gHC);
        this.ijq = new e(this.mPageContext, k.gHA);
        this.ijr = new c(this.mPageContext, k.gHv);
        this.ijn.a(this.Vw);
        this.ijo.a(this.Vw);
        this.ijp.a(this.Vw);
        this.ijq.a(this.Vw);
        this.ijr.a(this.Vw);
        this.ial.add(this.ijn);
        this.ial.add(this.ijo);
        this.ial.add(this.ijp);
        this.ial.add(this.ijq);
        this.ial.add(this.ijr);
        this.Vw.addAdapters(this.ial);
    }

    public void notifyDataSetChanged() {
        if (this.Vw != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ijn != null) {
            this.ijn.setPageUniqueId(bdUniqueId);
        }
        if (this.ijo != null) {
            this.ijo.setPageUniqueId(bdUniqueId);
        }
        if (this.ijp != null) {
            this.ijp.setPageUniqueId(bdUniqueId);
        }
        if (this.ijq != null) {
            this.ijq.setPageUniqueId(bdUniqueId);
        }
        if (this.ijr != null) {
            this.ijr.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<o> list) {
        this.Vw.setData(list);
    }

    public List<o> getDataList() {
        if (this.Vw != null) {
            return this.Vw.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.ijq != null) {
            this.ijq.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.ijo != null) {
            this.ijo.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.ijo != null) {
            this.ijo.b(eVar);
        }
    }
}
