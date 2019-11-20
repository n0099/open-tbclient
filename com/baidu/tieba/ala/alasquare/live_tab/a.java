package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.c;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agy;
    private c dvW;
    private d dvX;
    private com.baidu.tieba.ala.alasquare.live_tab.a.b dvY;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a dvZ;
    private Context mContext;
    private TbPageContext mPageContext;
    private BdTypeRecyclerView yJ;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.yJ = bdTypeRecyclerView;
        sY();
    }

    private void sY() {
        this.agy = new ArrayList();
        this.dvW = new c(this.mPageContext);
        this.dvX = new d(this.mPageContext);
        this.dvY = new com.baidu.tieba.ala.alasquare.live_tab.a.b(this.mPageContext);
        this.dvZ = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.agy.add(this.dvW);
        this.agy.add(this.dvX);
        this.agy.add(this.dvY);
        this.agy.add(this.dvZ);
        this.yJ.addAdapters(this.agy);
    }

    public void setData(List<m> list) {
        this.yJ.setData(list);
    }

    public void notifyDataSetChanged() {
        if (this.yJ != null) {
            this.yJ.getListAdapter().notifyDataSetChanged();
        }
    }
}
