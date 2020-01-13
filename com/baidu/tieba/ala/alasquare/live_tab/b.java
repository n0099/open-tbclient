package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BdTypeRecyclerView Bs;
    private List<com.baidu.adp.widget.ListView.a> apl;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c eht;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Bs = bdTypeRecyclerView;
        vi();
    }

    private void vi() {
        this.apl = new ArrayList();
        this.eht = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.apl.add(this.eht);
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
