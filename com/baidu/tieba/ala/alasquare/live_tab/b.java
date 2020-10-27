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
    private BdTypeRecyclerView Xe;
    private List<com.baidu.adp.widget.ListView.a> bje;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gdF;
    private d gdS;
    private boolean gdT = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xe = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.bje = new ArrayList();
        this.gdS = new d(this.mPageContext);
        this.gdS.lu(this.gdT);
        this.gdF = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bje.add(this.gdS);
        this.bje.add(this.gdF);
        this.Xe.addAdapters(this.bje);
    }

    public void setData(List<q> list) {
        this.Xe.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }

    public void lu(boolean z) {
        this.gdT = z;
    }
}
