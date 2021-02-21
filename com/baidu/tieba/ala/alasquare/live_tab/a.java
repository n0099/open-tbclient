package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private BdTypeRecyclerView XW;
    private List<com.baidu.adp.widget.ListView.a> bns;
    private e gAA;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c gAB;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b gAC;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gAD;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.XW = bdTypeRecyclerView;
        this.tabType = i;
        Kw();
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.gAA = new e(this.mPageContext, this.tabType);
        this.gAB = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gAC = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gAD = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bns.add(this.gAA);
        this.bns.add(this.gAB);
        this.bns.add(this.gAC);
        this.bns.add(this.gAD);
        this.XW.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        this.XW.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.XW != null) {
            this.XW.getListAdapter().notifyDataSetChanged();
        }
    }
}
