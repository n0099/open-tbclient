package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private e cVE;
    private BdTypeListView eko;
    private a ekp;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekq;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ekr;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.cVE = tbPageContext;
        this.eko = bdTypeListView;
        wM();
    }

    private void wM() {
        this.ekr = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.cVE);
        this.ekr.setFrom(1);
        this.ekq = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.cVE);
        this.ekq.setFrom(1);
        this.ekp = new a((TbPageContext) this.cVE, com.baidu.tieba.ala.alasquare.live.b.b.ekv);
        this.asF.add(this.ekr);
        this.asF.add(this.ekq);
        this.asF.add(this.ekp);
        this.eko.addAdapters(this.asF);
    }

    public void setDatas(List<m> list) {
        if (this.eko != null) {
            this.eko.setData(list);
        }
    }

    public void oB(int i) {
        this.ekr.oB(i);
        this.ekq.oB(i);
    }

    public void notifyDataSetChanged() {
        if (this.eko != null && (this.eko.getAdapter() instanceof BaseAdapter)) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.ekp.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.ekr.b(iVar);
        this.ekq.b(iVar);
    }
}
