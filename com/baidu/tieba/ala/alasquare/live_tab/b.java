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
    private BdTypeRecyclerView Wu;
    private List<com.baidu.adp.widget.ListView.a> bbu;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fEd;
    private d fEp;
    private boolean fEq = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Wu = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.bbu = new ArrayList();
        this.fEp = new d(this.mPageContext);
        this.fEp.kA(this.fEq);
        this.fEd = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bbu.add(this.fEp);
        this.bbu.add(this.fEd);
        this.Wu.addAdapters(this.bbu);
    }

    public void setData(List<q> list) {
        this.Wu.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void kA(boolean z) {
        this.fEq = z;
    }
}
