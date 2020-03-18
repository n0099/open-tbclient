package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView BK;
    private List<com.baidu.adp.widget.ListView.a> asP;
    private d elQ;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b elR;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a elS;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.BK = bdTypeRecyclerView;
        this.tabType = i;
        wR();
    }

    private void wR() {
        this.asP = new ArrayList();
        this.elQ = new d(this.mPageContext, this.tabType);
        this.elR = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.elS = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.asP.add(this.elQ);
        this.asP.add(this.elR);
        this.asP.add(this.elS);
        this.BK.addAdapters(this.asP);
    }

    public void setData(List<m> list) {
        this.BK.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.BK != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }
}
