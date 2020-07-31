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
    private BdTypeRecyclerView VT;
    private List<com.baidu.adp.widget.ListView.a> aWf;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fsJ;
    private d fsV;
    private boolean fsW = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.VT = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.aWf = new ArrayList();
        this.fsV = new d(this.mPageContext);
        this.fsV.kc(this.fsW);
        this.fsJ = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aWf.add(this.fsV);
        this.aWf.add(this.fsJ);
        this.VT.addAdapters(this.aWf);
    }

    public void setData(List<q> list) {
        this.VT.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.VT != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void kc(boolean z) {
        this.fsW = z;
    }
}
