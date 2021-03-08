package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Zq;
    private List<com.baidu.adp.widget.ListView.a> boS;
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
        this.Zq = bdTypeRecyclerView;
        this.tabType = i;
        Kz();
    }

    private void Kz() {
        this.boS = new ArrayList();
        this.gCj = new e(this.mPageContext, this.tabType);
        this.gCk = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gCl = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gCm = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.boS.add(this.gCj);
        this.boS.add(this.gCk);
        this.boS.add(this.gCl);
        this.boS.add(this.gCm);
        this.Zq.addAdapters(this.boS);
    }

    public void setData(List<n> list) {
        this.Zq.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Zq != null) {
            this.Zq.getListAdapter().notifyDataSetChanged();
        }
    }
}
