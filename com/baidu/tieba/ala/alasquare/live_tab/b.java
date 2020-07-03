package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdTypeRecyclerView Wa;
    private List<com.baidu.adp.widget.ListView.a> aUP;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fnA;
    private d fnM;
    private boolean fnN = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Wa = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.aUP = new ArrayList();
        this.fnM = new d(this.mPageContext);
        this.fnM.jy(this.fnN);
        this.fnA = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aUP.add(this.fnM);
        this.aUP.add(this.fnA);
        this.Wa.addAdapters(this.aUP);
    }

    public void setData(List<q> list) {
        this.Wa.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Wa != null) {
            this.Wa.getListAdapter().notifyDataSetChanged();
        }
    }

    public void jy(boolean z) {
        this.fnN = z;
    }
}
