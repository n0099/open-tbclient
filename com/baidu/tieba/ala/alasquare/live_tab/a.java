package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView Vi;
    private List<com.baidu.adp.widget.ListView.a> aMj;
    private d ePv;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b ePw;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a ePx;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Vi = bdTypeRecyclerView;
        this.tabType = i;
        BB();
    }

    private void BB() {
        this.aMj = new ArrayList();
        this.ePv = new d(this.mPageContext, this.tabType);
        this.ePw = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.ePx = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.aMj.add(this.ePv);
        this.aMj.add(this.ePw);
        this.aMj.add(this.ePx);
        this.Vi.addAdapters(this.aMj);
    }

    public void setData(List<m> list) {
        this.Vi.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Vi != null) {
            this.Vi.getListAdapter().notifyDataSetChanged();
        }
    }
}
