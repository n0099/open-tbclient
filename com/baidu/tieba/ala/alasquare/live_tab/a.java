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
    private BdTypeRecyclerView Yc;
    private List<com.baidu.adp.widget.ListView.a> boM;
    private e gCj;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c gCk;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b gCl;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gCm;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Yc = bdTypeRecyclerView;
        this.tabType = i;
        MT();
    }

    private void MT() {
        this.boM = new ArrayList();
        this.gCj = new e(this.mPageContext, this.tabType);
        this.gCk = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gCl = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gCm = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.boM.add(this.gCj);
        this.boM.add(this.gCk);
        this.boM.add(this.gCl);
        this.boM.add(this.gCm);
        this.Yc.addAdapters(this.boM);
    }

    public void setData(List<n> list) {
        this.Yc.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Yc != null) {
            this.Yc.getListAdapter().notifyDataSetChanged();
        }
    }
}
