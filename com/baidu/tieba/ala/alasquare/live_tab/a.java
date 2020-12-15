package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView Yf;
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private e grk;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c grl;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b grm;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a grn;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Yf = bdTypeRecyclerView;
        this.tabType = i;
        Nt();
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.grk = new e(this.mPageContext, this.tabType);
        this.grl = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.grm = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.grn = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bnf.add(this.grk);
        this.bnf.add(this.grl);
        this.bnf.add(this.grm);
        this.bnf.add(this.grn);
        this.Yf.addAdapters(this.bnf);
    }

    public void setData(List<q> list) {
        this.Yf.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Yf != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
    }
}
