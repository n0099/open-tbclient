package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdTypeRecyclerView BK;
    private List<com.baidu.adp.widget.ListView.a> asP;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c eme;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.BK = bdTypeRecyclerView;
        wR();
    }

    private void wR() {
        this.asP = new ArrayList();
        this.eme = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.asP.add(this.eme);
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
