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
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private e dvc;
    private BdTypeListView eOe;
    private a eOf;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a eOg;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b eOh;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dvc = tbPageContext;
        this.eOe = bdTypeListView;
        BC();
    }

    private void BC() {
        this.eOh = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.dvc);
        this.eOh.setFrom(1);
        this.eOg = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.dvc);
        this.eOg.setFrom(1);
        this.eOf = new a((TbPageContext) this.dvc, com.baidu.tieba.ala.alasquare.live.b.b.eOl);
        this.aMd.add(this.eOh);
        this.aMd.add(this.eOg);
        this.aMd.add(this.eOf);
        this.eOe.addAdapters(this.aMd);
    }

    public void setDatas(List<m> list) {
        if (this.eOe != null) {
            this.eOe.setData(list);
        }
    }

    public void oW(int i) {
        this.eOh.oW(i);
        this.eOg.oW(i);
    }

    public void notifyDataSetChanged() {
        if (this.eOe != null && (this.eOe.getAdapter() instanceof BaseAdapter)) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.eOf.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.eOh.b(iVar);
        this.eOg.b(iVar);
    }
}
