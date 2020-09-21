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
    private BdTypeRecyclerView WM;
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private d fHF;
    private boolean fHG = false;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fHt;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.WM = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.bdV = new ArrayList();
        this.fHF = new d(this.mPageContext);
        this.fHF.kE(this.fHG);
        this.fHt = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bdV.add(this.fHF);
        this.bdV.add(this.fHt);
        this.WM.addAdapters(this.bdV);
    }

    public void setData(List<q> list) {
        this.WM.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.WM != null) {
            this.WM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void kE(boolean z) {
        this.fHG = z;
    }
}
