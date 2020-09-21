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
    private BdTypeRecyclerView WM;
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private e fHq;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fHr;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fHs;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fHt;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.WM = bdTypeRecyclerView;
        this.tabType = i;
        JZ();
    }

    private void JZ() {
        this.bdV = new ArrayList();
        this.fHq = new e(this.mPageContext, this.tabType);
        this.fHr = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fHs = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fHt = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bdV.add(this.fHq);
        this.bdV.add(this.fHr);
        this.bdV.add(this.fHs);
        this.bdV.add(this.fHt);
        this.WM.addAdapters(this.bdV);
    }

    public void setData(List<q> list) {
        this.WM.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.WM != null) {
            this.WM.getListAdapter().notifyDataSetChanged();
        }
    }
}
