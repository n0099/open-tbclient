package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.c;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ;
    private c dwN;
    private d dwO;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b dwP;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a dwQ;
    private Context mContext;
    private TbPageContext mPageContext;
    private BdTypeRecyclerView zj;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.zj = bdTypeRecyclerView;
        sX();
    }

    private void sX() {
        this.agQ = new ArrayList();
        this.dwN = new c(this.mPageContext);
        this.dwO = new d(this.mPageContext);
        this.dwP = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.dwQ = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.agQ.add(this.dwN);
        this.agQ.add(this.dwO);
        this.agQ.add(this.dwP);
        this.agQ.add(this.dwQ);
        this.zj.addAdapters(this.agQ);
    }

    public void setData(List<m> list) {
        this.zj.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.zj != null) {
            this.zj.getListAdapter().notifyDataSetChanged();
        }
    }
}
