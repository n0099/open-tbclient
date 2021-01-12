package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Ya;
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private e gxC;
    private com.baidu.tieba.ala.alasquare.live_tab.a.c gxD;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b gxE;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gxF;
    private Context mContext;
    private TbPageContext mPageContext;
    private int tabType;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Ya = bdTypeRecyclerView;
        this.tabType = i;
        IY();
    }

    private void IY() {
        this.bjZ = new ArrayList();
        this.gxC = new e(this.mPageContext, this.tabType);
        this.gxD = new com.baidu.tieba.ala.alasquare.live_tab.a.c(this.mPageContext);
        this.gxE = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.gxF = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bjZ.add(this.gxC);
        this.bjZ.add(this.gxD);
        this.bjZ.add(this.gxE);
        this.bjZ.add(this.gxF);
        this.Ya.addAdapters(this.bjZ);
    }

    public void setData(List<n> list) {
        this.Ya.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.Ya != null) {
            this.Ya.getListAdapter().notifyDataSetChanged();
        }
    }
}
