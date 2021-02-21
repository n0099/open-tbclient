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
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gAD;
    private d gAQ;
    private boolean gAR = false;
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
        this.gAQ = new d(this.mPageContext);
        this.gAQ.mw(this.gAR);
        this.gAD = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bns.add(this.gAQ);
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

    public void mw(boolean z) {
        this.gAR = z;
    }
}
