package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private List<com.baidu.adp.widget.ListView.a> aSj;
    private e fcc;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fcd;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fce;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fcf;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Vw = bdTypeRecyclerView;
        this.tabType = i;
        CY();
    }

    private void CY() {
        this.aSj = new ArrayList();
        this.fcc = new e(this.mPageContext, this.tabType);
        this.fcd = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fce = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fcf = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aSj.add(this.fcc);
        this.aSj.add(this.fcd);
        this.aSj.add(this.fce);
        this.aSj.add(this.fcf);
        this.Vw.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        this.Vw.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Vw != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
    }
}
