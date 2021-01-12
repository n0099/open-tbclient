package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView Ya;
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private com.baidu.tieba.ala.alasquare.live_tab.a.a gxF;
    private d gxS;
    private boolean gxT = false;
    private Context mContext;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.Ya = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.bjZ = new ArrayList();
        this.gxS = new d(this.mPageContext);
        this.gxS.ms(this.gxT);
        this.gxF = new com.baidu.tieba.ala.alasquare.live_tab.a.a(this.mPageContext);
        this.bjZ.add(this.gxS);
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

    public void ms(boolean z) {
        this.gxT = z;
    }
}
