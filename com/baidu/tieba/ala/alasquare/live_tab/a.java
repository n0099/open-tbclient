package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView Wa;
    private List<com.baidu.adp.widget.ListView.a> aUP;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fnA;
    private e fnx;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fny;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fnz;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Wa = bdTypeRecyclerView;
        this.tabType = i;
        Dz();
    }

    private void Dz() {
        this.aUP = new ArrayList();
        this.fnx = new e(this.mPageContext, this.tabType);
        this.fny = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fnz = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fnA = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aUP.add(this.fnx);
        this.aUP.add(this.fny);
        this.aUP.add(this.fnz);
        this.aUP.add(this.fnA);
        this.Wa.addAdapters(this.aUP);
    }

    public void setData(List<q> list) {
        this.Wa.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Wa != null) {
            this.Wa.getListAdapter().notifyDataSetChanged();
        }
    }
}
