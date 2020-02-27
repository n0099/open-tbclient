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
    private List<com.baidu.adp.widget.ListView.a> asE;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c elz;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.BK = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.asE = new ArrayList();
        this.elz = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.asE.add(this.elz);
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
