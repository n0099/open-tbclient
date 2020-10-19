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
    private BdTypeRecyclerView Xc;
    private List<com.baidu.adp.widget.ListView.a> bhH;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fTA;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fTB;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fTC;
    private e fTz;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xc = bdTypeRecyclerView;
        this.tabType = i;
        Le();
    }

    private void Le() {
        this.bhH = new ArrayList();
        this.fTz = new e(this.mPageContext, this.tabType);
        this.fTA = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fTB = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fTC = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bhH.add(this.fTz);
        this.bhH.add(this.fTA);
        this.bhH.add(this.fTB);
        this.bhH.add(this.fTC);
        this.Xc.addAdapters(this.bhH);
    }

    public void setData(List<q> list) {
        this.Xc.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xc != null) {
            this.Xc.getListAdapter().notifyDataSetChanged();
        }
    }
}
