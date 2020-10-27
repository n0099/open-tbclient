package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private List<com.baidu.adp.widget.ListView.a> bje;
    private e gdC;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c gdD;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b gdE;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gdF;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xe = bdTypeRecyclerView;
        this.tabType = i;
        Ly();
    }

    private void Ly() {
        this.bje = new ArrayList();
        this.gdC = new e(this.mPageContext, this.tabType);
        this.gdD = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gdE = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gdF = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bje.add(this.gdC);
        this.bje.add(this.gdD);
        this.bje.add(this.gdE);
        this.bje.add(this.gdF);
        this.Xe.addAdapters(this.bje);
    }

    public void setData(List<q> list) {
        this.Xe.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }
}
