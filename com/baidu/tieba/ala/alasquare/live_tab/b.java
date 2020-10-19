package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private BdTypeRecyclerView Xc;
    private List<com.baidu.adp.widget.ListView.a> bhH;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fTC;
    private d fTP;
    private boolean fTQ = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xc = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.bhH = new ArrayList();
        this.fTP = new d(this.mPageContext);
        this.fTP.lc(this.fTQ);
        this.fTC = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bhH.add(this.fTP);
        this.bhH.add(this.fTC);
        this.Xc.addAdapters(this.bhH);
    }

    public void setData(List<q> list) {
        this.Xc.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xc != null) {
            this.Xc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void lc(boolean z) {
        this.fTQ = z;
    }
}
