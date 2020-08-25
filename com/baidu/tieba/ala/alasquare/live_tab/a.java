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
    private BdTypeRecyclerView Wu;
    private List<com.baidu.adp.widget.ListView.a> bbu;
    private e fEa;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fEb;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fEc;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fEd;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Wu = bdTypeRecyclerView;
        this.tabType = i;
        Jv();
    }

    private void Jv() {
        this.bbu = new ArrayList();
        this.fEa = new e(this.mPageContext, this.tabType);
        this.fEb = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fEc = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fEd = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bbu.add(this.fEa);
        this.bbu.add(this.fEb);
        this.bbu.add(this.fEc);
        this.bbu.add(this.fEd);
        this.Wu.addAdapters(this.bbu);
    }

    public void setData(List<q> list) {
        this.Wu.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }
}
