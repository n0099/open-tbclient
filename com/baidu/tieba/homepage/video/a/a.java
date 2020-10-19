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
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xc;
    private LinkedList<com.baidu.adp.widget.ListView.a> jhz = new LinkedList<>();
    private f jtR;
    private b jtS;
    private d jtT;
    private e jtU;
    private c jtV;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xc = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.jtR = new f(this.mPageContext, l.hJf);
        this.jtS = new b(this.mPageContext, m.epH);
        this.jtT = new d(this.mPageContext, l.hJm);
        this.jtU = new e(this.mPageContext, l.hJk);
        this.jtV = new c(this.mPageContext, l.epp);
        this.jtR.a(this.Xc);
        this.jtS.a(this.Xc);
        this.jtT.a(this.Xc);
        this.jtU.a(this.Xc);
        this.jtV.a(this.Xc);
        this.jhz.add(this.jtR);
        this.jhz.add(this.jtS);
        this.jhz.add(this.jtT);
        this.jhz.add(this.jtU);
        this.jhz.add(this.jtV);
        this.Xc.addAdapters(this.jhz);
    }

    public void notifyDataSetChanged() {
        if (this.Xc != null) {
            this.Xc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jtR != null) {
            this.jtR.setPageUniqueId(bdUniqueId);
        }
        if (this.jtS != null) {
            this.jtS.setPageUniqueId(bdUniqueId);
        }
        if (this.jtT != null) {
            this.jtT.setPageUniqueId(bdUniqueId);
        }
        if (this.jtU != null) {
            this.jtU.setPageUniqueId(bdUniqueId);
        }
        if (this.jtV != null) {
            this.jtV.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Xc.setData(list);
    }

    public List<q> getDataList() {
        if (this.Xc != null) {
            return this.Xc.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jtU != null) {
            this.jtU.setEventCallback(aVar);
        }
        if (this.jtR != null) {
            this.jtR.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.jtS != null) {
            this.jtS.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.jtS != null) {
            this.jtS.b(eVar);
        }
    }
}
