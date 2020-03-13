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
    private List<com.baidu.adp.widget.ListView.a> asF;
    private d elA;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b elB;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a elC;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.BK = bdTypeRecyclerView;
        this.tabType = i;
        wM();
    }

    private void wM() {
        this.asF = new ArrayList();
        this.elA = new d(this.mPageContext, this.tabType);
        this.elB = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.elC = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.asF.add(this.elA);
        this.asF.add(this.elB);
        this.asF.add(this.elC);
        this.BK.addAdapters(this.asF);
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
