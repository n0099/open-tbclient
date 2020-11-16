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
    private BdTypeRecyclerView Xi;
    private List<com.baidu.adp.widget.ListView.a> biN;
    private e giZ;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c gja;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b gjb;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gjc;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xi = bdTypeRecyclerView;
        this.tabType = i;
        Lp();
    }

    private void Lp() {
        this.biN = new ArrayList();
        this.giZ = new e(this.mPageContext, this.tabType);
        this.gja = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gjb = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gjc = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.biN.add(this.giZ);
        this.biN.add(this.gja);
        this.biN.add(this.gjb);
        this.biN.add(this.gjc);
        this.Xi.addAdapters(this.biN);
    }

    public void setData(List<q> list) {
        this.Xi.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xi != null) {
            this.Xi.getListAdapter().notifyDataSetChanged();
        }
    }
}
