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
    private BdTypeRecyclerView Vf;
    private List<com.baidu.adp.widget.ListView.a> aMd;
    private d ePq;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b ePr;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a ePs;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Vf = bdTypeRecyclerView;
        this.tabType = i;
        BC();
    }

    private void BC() {
        this.aMd = new ArrayList();
        this.ePq = new d(this.mPageContext, this.tabType);
        this.ePr = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.ePs = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aMd.add(this.ePq);
        this.aMd.add(this.ePr);
        this.aMd.add(this.ePs);
        this.Vf.addAdapters(this.aMd);
    }

    public void setData(List<m> list) {
        this.Vf.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Vf != null) {
            this.Vf.getListAdapter().notifyDataSetChanged();
        }
    }
}
