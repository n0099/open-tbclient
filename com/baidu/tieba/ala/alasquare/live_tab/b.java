package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdTypeRecyclerView Yc;
    private List<com.baidu.adp.widget.ListView.a> boM;
    private boolean gCA = false;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gCm;
    private d gCz;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Yc = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.boM = new ArrayList();
        this.gCz = new d(this.mPageContext);
        this.gCz.mw(this.gCA);
        this.gCm = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.boM.add(this.gCz);
        this.boM.add(this.gCm);
        this.Yc.addAdapters(this.boM);
    }

    public void setData(List<n> list) {
        this.Yc.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Yc != null) {
            this.Yc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void mw(boolean z) {
        this.gCA = z;
    }
}
