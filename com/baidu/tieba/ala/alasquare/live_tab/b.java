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
    private BdTypeRecyclerView Xi;
    private List<com.baidu.adp.widget.ListView.a> biN;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gjc;
    private d gjp;
    private boolean gjq = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Xi = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.biN = new ArrayList();
        this.gjp = new d(this.mPageContext);
        this.gjp.lE(this.gjq);
        this.gjc = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.biN.add(this.gjp);
        this.biN.add(this.gjc);
        this.Xi.addAdapters(this.biN);
    }

    public void setData(List<q> list) {
        this.Xi.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Xi != null) {
            this.Xi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void lE(boolean z) {
        this.gjq = z;
    }
}
