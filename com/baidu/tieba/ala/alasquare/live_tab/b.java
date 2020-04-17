package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdTypeRecyclerView Vf;
    private List<com.baidu.adp.widget.ListView.a> aMd;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c ePE;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Vf = bdTypeRecyclerView;
        BC();
    }

    private void BC() {
        this.aMd = new ArrayList();
        this.ePE = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.aMd.add(this.ePE);
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
