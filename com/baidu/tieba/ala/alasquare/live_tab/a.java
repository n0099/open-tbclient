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
    private List<com.baidu.adp.widget.ListView.a> asE;
    private d elm;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b eln;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a elo;
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
        this.asE = new ArrayList();
        this.elm = new d(this.mPageContext, this.tabType);
        this.eln = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.elo = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.asE.add(this.elm);
        this.asE.add(this.eln);
        this.asE.add(this.elo);
        this.BK.addAdapters(this.asE);
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
