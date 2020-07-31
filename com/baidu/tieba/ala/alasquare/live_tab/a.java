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
    private BdTypeRecyclerView VT;
    private List<com.baidu.adp.widget.ListView.a> aWf;
    private e fsG;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fsH;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fsI;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fsJ;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.VT = bdTypeRecyclerView;
        this.tabType = i;
        DS();
    }

    private void DS() {
        this.aWf = new ArrayList();
        this.fsG = new e(this.mPageContext, this.tabType);
        this.fsH = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fsI = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fsJ = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aWf.add(this.fsG);
        this.aWf.add(this.fsH);
        this.aWf.add(this.fsI);
        this.aWf.add(this.fsJ);
        this.VT.addAdapters(this.aWf);
    }

    public void setData(List<q> list) {
        this.VT.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.VT != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
    }
}
