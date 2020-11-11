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
    private BdTypeRecyclerView Xe;
    private List<com.baidu.adp.widget.ListView.a> bky;
    private e gjs;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c gjt;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b gju;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gjv;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xe = bdTypeRecyclerView;
        this.tabType = i;
        LY();
    }

    private void LY() {
        this.bky = new ArrayList();
        this.gjs = new e(this.mPageContext, this.tabType);
        this.gjt = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gju = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gjv = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bky.add(this.gjs);
        this.bky.add(this.gjt);
        this.bky.add(this.gju);
        this.bky.add(this.gjv);
        this.Xe.addAdapters(this.bky);
    }

    public void setData(List<q> list) {
        this.Xe.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }
}
