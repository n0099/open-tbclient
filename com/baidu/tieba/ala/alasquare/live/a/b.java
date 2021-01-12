package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private f eTl;
    private BdTypeListView gwr;
    private a gws;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gwt;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gwu;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eTl = tbPageContext;
        this.gwr = bdTypeListView;
        IY();
    }

    private void IY() {
        this.gwu = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eTl);
        this.gwu.setFrom(1);
        this.gwt = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eTl);
        this.gwt.setFrom(1);
        this.gws = new a((TbPageContext) this.eTl, com.baidu.tieba.ala.alasquare.live.b.b.gwy);
        this.bjZ.add(this.gwu);
        this.bjZ.add(this.gwt);
        this.bjZ.add(this.gws);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setDatas(List<n> list) {
        if (this.gwr != null) {
            this.gwr.setData(list);
        }
    }

    public void tA(int i) {
        this.gwu.tA(i);
        this.gwt.tA(i);
    }

    public void notifyDataSetChanged() {
        if (this.gwr != null && (this.gwr.getAdapter() instanceof BaseAdapter)) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gws.a(iAlaSquareTabController);
    }

    public void a(g gVar) {
        this.gwu.b(gVar);
        this.gwt.b(gVar);
    }
}
