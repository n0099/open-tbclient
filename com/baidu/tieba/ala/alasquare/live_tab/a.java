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
    private e fcn;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fco;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fcp;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fcq;
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
        this.fcn = new e(this.mPageContext, this.tabType);
        this.fco = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fcp = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fcq = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aSj.add(this.fcn);
        this.aSj.add(this.fco);
        this.aSj.add(this.fcp);
        this.aSj.add(this.fcq);
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
