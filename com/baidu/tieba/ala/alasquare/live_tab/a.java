package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private List<com.baidu.adp.widget.ListView.a> apl;
    private d ehi;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b ehj;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a ehk;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Bs = bdTypeRecyclerView;
        this.tabType = i;
        vi();
    }

    private void vi() {
        this.apl = new ArrayList();
        this.ehi = new d(this.mPageContext, this.tabType);
        this.ehj = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.ehk = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.apl.add(this.ehi);
        this.apl.add(this.ehj);
        this.apl.add(this.ehk);
        this.Bs.addAdapters(this.apl);
    }

    public void setData(List<m> list) {
        this.Bs.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Bs != null) {
            this.Bs.getListAdapter().notifyDataSetChanged();
        }
    }
}
