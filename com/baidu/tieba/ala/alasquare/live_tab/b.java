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
    private List<com.baidu.adp.widget.ListView.a> bbw;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fEh;
    private d fEt;
    private boolean fEu = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Wu = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.bbw = new ArrayList();
        this.fEt = new d(this.mPageContext);
        this.fEt.kC(this.fEu);
        this.fEh = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bbw.add(this.fEt);
        this.bbw.add(this.fEh);
        this.Wu.addAdapters(this.bbw);
    }

    public void setData(List<q> list) {
        this.Wu.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void kC(boolean z) {
        this.fEu = z;
    }
}
