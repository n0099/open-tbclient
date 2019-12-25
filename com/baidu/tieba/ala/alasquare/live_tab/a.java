package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.c;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private List<com.baidu.adp.widget.ListView.a> aoz;
    private c egY;
    private d egZ;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b eha;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a ehb;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Bn = bdTypeRecyclerView;
        uR();
    }

    private void uR() {
        this.aoz = new ArrayList();
        this.egY = new c(this.mPageContext);
        this.egZ = new d(this.mPageContext);
        this.eha = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.ehb = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aoz.add(this.egY);
        this.aoz.add(this.egZ);
        this.aoz.add(this.eha);
        this.aoz.add(this.ehb);
        this.Bn.addAdapters(this.aoz);
    }

    public void setData(List<m> list) {
        this.Bn.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Bn != null) {
            this.Bn.getListAdapter().notifyDataSetChanged();
        }
    }
}
