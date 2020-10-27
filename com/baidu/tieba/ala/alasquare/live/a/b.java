package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private e eCK;
    private BdTypeListView gcr;
    private a gcs;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gct;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gcu;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eCK = tbPageContext;
        this.gcr = bdTypeListView;
        Ly();
    }

    private void Ly() {
        this.gcu = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eCK);
        this.gcu.setFrom(1);
        this.gct = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eCK);
        this.gct.setFrom(1);
        this.gcs = new a((TbPageContext) this.eCK, com.baidu.tieba.ala.alasquare.live.b.b.gcy);
        this.bje.add(this.gcu);
        this.bje.add(this.gct);
        this.bje.add(this.gcs);
        this.gcr.addAdapters(this.bje);
    }

    public void setDatas(List<q> list) {
        if (this.gcr != null) {
            this.gcr.setData(list);
        }
    }

    public void tI(int i) {
        this.gcu.tI(i);
        this.gct.tI(i);
    }

    public void notifyDataSetChanged() {
        if (this.gcr != null && (this.gcr.getAdapter() instanceof BaseAdapter)) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gcs.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.gcu.b(iVar);
        this.gct.b(iVar);
    }
}
