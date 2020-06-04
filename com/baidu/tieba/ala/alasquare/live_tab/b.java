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
    private d fcC;
    private boolean fcD = false;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fcq;
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
        this.fcC = new d(this.mPageContext);
        this.fcC.jl(this.fcD);
        this.fcq = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aSj.add(this.fcC);
        this.aSj.add(this.fcq);
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
        this.fcD = z;
    }
}
