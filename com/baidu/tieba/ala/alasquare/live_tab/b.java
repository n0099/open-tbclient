package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdTypeRecyclerView Vw;
    private List<com.baidu.adp.widget.ListView.a> aSj;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fcf;
    private d fcr;
    private boolean fcs = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Vw = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.aSj = new ArrayList();
        this.fcr = new d(this.mPageContext);
        this.fcr.jl(this.fcs);
        this.fcf = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aSj.add(this.fcr);
        this.aSj.add(this.fcf);
        this.Vw.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        this.Vw.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Vw != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void jl(boolean z) {
        this.fcs = z;
    }
}
