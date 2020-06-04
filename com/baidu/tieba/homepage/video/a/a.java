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
    private LinkedList<com.baidu.adp.widget.ListView.a> iaY = new LinkedList<>();
    private f ika;
    private b ikb;
    private d ikc;
    private e ikd;
    private c ike;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vw = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.ika = new f(this.mPageContext, k.gHF);
        this.ikb = new b(this.mPageContext, l.dEV);
        this.ikc = new d(this.mPageContext, k.gHN);
        this.ikd = new e(this.mPageContext, k.gHL);
        this.ike = new c(this.mPageContext, k.gHG);
        this.ika.a(this.Vw);
        this.ikb.a(this.Vw);
        this.ikc.a(this.Vw);
        this.ikd.a(this.Vw);
        this.ike.a(this.Vw);
        this.iaY.add(this.ika);
        this.iaY.add(this.ikb);
        this.iaY.add(this.ikc);
        this.iaY.add(this.ikd);
        this.iaY.add(this.ike);
        this.Vw.addAdapters(this.iaY);
    }

    public void notifyDataSetChanged() {
        if (this.Vw != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ika != null) {
            this.ika.setPageUniqueId(bdUniqueId);
        }
        if (this.ikb != null) {
            this.ikb.setPageUniqueId(bdUniqueId);
        }
        if (this.ikc != null) {
            this.ikc.setPageUniqueId(bdUniqueId);
        }
        if (this.ikd != null) {
            this.ikd.setPageUniqueId(bdUniqueId);
        }
        if (this.ike != null) {
            this.ike.setPageUniqueId(bdUniqueId);
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
        if (this.ikd != null) {
            this.ikd.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.ikb != null) {
            this.ikb.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.ikb != null) {
            this.ikb.b(eVar);
        }
    }
}
