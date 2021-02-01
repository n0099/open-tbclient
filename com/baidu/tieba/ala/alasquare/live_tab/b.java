package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdTypeRecyclerView XW;
    private List<com.baidu.adp.widget.ListView.a> bns;
    private d gAC;
    private boolean gAD = false;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gAp;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.XW = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.gAC = new d(this.mPageContext);
        this.gAC.mw(this.gAD);
        this.gAp = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bns.add(this.gAC);
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

    public void mw(boolean z) {
        this.gAD = z;
    }
}
