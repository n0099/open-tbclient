package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdTypeRecyclerView Vi;
    private List<com.baidu.adp.widget.ListView.a> aMj;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c ePJ;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Vi = bdTypeRecyclerView;
        BB();
    }

    private void BB() {
        this.aMj = new ArrayList();
        this.ePJ = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.aMj.add(this.ePJ);
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
