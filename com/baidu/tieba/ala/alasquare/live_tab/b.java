package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView Zq;
    private List<com.baidu.adp.widget.ListView.a> boS;
    private boolean gCA = false;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gCm;
    private d gCz;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Zq = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.boS = new ArrayList();
        this.gCz = new d(this.mPageContext);
        this.gCz.mw(this.gCA);
        this.gCm = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.boS.add(this.gCz);
        this.boS.add(this.gCm);
        this.Zq.addAdapters(this.boS);
    }

    public void setData(List<n> list) {
        this.Zq.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Zq != null) {
            this.Zq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void mw(boolean z) {
        this.gCA = z;
    }
}
