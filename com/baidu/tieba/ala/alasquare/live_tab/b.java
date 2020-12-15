package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private BdTypeRecyclerView Yf;
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private d grA;
    private boolean grB = false;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a grn;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Yf = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.grA = new d(this.mPageContext);
        this.grA.lZ(this.grB);
        this.grn = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bnf.add(this.grA);
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

    public void lZ(boolean z) {
        this.grB = z;
    }
}
