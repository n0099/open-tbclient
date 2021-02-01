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
    private e gAm;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c gAn;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b gAo;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gAp;
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
        this.gAm = new e(this.mPageContext, this.tabType);
        this.gAn = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gAo = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gAp = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bns.add(this.gAm);
        this.bns.add(this.gAn);
        this.bns.add(this.gAo);
        this.bns.add(this.gAp);
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
