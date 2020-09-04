package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private List<com.baidu.adp.widget.ListView.a> bbw;
    private e fEe;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c fEf;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b fEg;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a fEh;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Wu = bdTypeRecyclerView;
        this.tabType = i;
        Jv();
    }

    private void Jv() {
        this.bbw = new ArrayList();
        this.fEe = new e(this.mPageContext, this.tabType);
        this.fEf = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.fEg = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.fEh = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bbw.add(this.fEe);
        this.bbw.add(this.fEf);
        this.bbw.add(this.fEg);
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
}
