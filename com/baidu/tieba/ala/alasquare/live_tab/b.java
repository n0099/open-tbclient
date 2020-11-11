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
    private List<com.baidu.adp.widget.ListView.a> bky;
    private d gjI;
    private boolean gjJ = false;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gjv;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xe = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.bky = new ArrayList();
        this.gjI = new d(this.mPageContext);
        this.gjI.lD(this.gjJ);
        this.gjv = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bky.add(this.gjI);
        this.bky.add(this.gjv);
        this.Xe.addAdapters(this.bky);
    }

    public void setData(List<q> list) {
        this.Xe.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }

    public void lD(boolean z) {
        this.gjJ = z;
    }
}
